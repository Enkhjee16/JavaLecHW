package com.example.bank;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class ActualPriceController {

    @GetMapping("/forex-actual")
    public String showForm() {
        return "forex_actual";
    }

    @PostMapping("/forex-actual")
    public String getPrice(
            @RequestParam String instrument,
            Model model
    ) {

        ActualPrice price = ForexService.getActualPrice(instrument);

        model.addAttribute("instrument", price.instrument);
        model.addAttribute("bid", price.bid);
        model.addAttribute("ask", price.ask);
        model.addAttribute("time", price.time);

        return "forex_actual";
    }
}
