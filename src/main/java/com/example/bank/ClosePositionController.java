package com.example.bank;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class ClosePositionController {

    @GetMapping("/forex-close")
    public String showForm(Model model) {

        // Load open trades for dropdown
        model.addAttribute("trades", ForexService.getOpenPositions());

        return "forex_close";
    }

    @PostMapping("/forex-close")
    public String closeTrade(
            @RequestParam int tradeId,
            Model model
    ) {

        ClosePosition closed = ForexService.closePosition(tradeId);

        model.addAttribute("tradeId", closed.tradeId);
        model.addAttribute("status", closed.status);
        model.addAttribute("closePrice", closed.closePrice);

        // Reload list for dropdown
        model.addAttribute("trades", ForexService.getOpenPositions());

        return "forex_close";
    }
}
