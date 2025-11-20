package com.example.bank;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class HistoricalPriceController {

    @GetMapping("/forex-history")
    public String showForm() {
        return "forex_history";
    }

    @PostMapping("/forex-history")
    public String getHistory(
            @RequestParam String instrument,
            @RequestParam String from,
            @RequestParam String to,
            Model model) {

        List<HistoricalPrice> list = ForexService.getHistoricalPrices(instrument, from, to);

        model.addAttribute("instrument", instrument);
        model.addAttribute("from", from);
        model.addAttribute("to", to);
        model.addAttribute("list", list);

        // Extract arrays for Chart.js
        model.addAttribute("times", list.stream().map(h -> h.time).toList());
        model.addAttribute("bids", list.stream().map(h -> h.bid).toList());
        model.addAttribute("asks", list.stream().map(h -> h.ask).toList());

        return "forex_history";
    }
}
