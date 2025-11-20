package com.example.bank;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class OpenPositionController {

    @GetMapping("/forex-open")
    public String showForm() {
        return "forex_open";
    }

    @PostMapping("/forex-open")
    public String open(
            @RequestParam String instrument,
            @RequestParam int units,
            Model model
    ) {

        OpenPosition result = ForexService.openPosition(instrument, units);

        model.addAttribute("instrument", result.instrument);
        model.addAttribute("units", result.units);
        model.addAttribute("price", result.price);
        model.addAttribute("tradeId", result.tradeId);

        return "forex_open";
    }
}
