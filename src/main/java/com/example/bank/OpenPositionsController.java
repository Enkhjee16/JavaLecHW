package com.example.bank;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class OpenPositionsController {

    @GetMapping("/forex-positions")
    public String listPositions(Model model) {

        List<OpenTrade> trades = ForexService.getOpenPositions();

        model.addAttribute("trades", trades);

        return "forex_positions";
    }
}
