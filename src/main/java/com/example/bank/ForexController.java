package com.example.bank;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ForexController {

    @GetMapping("/forex-account")
    public String forexAccount(Model model) throws Exception {

        ForexAccount acc = ForexService.getAccountInfo();

        model.addAttribute("accountId", ForexService.ACCOUNT);
        model.addAttribute("balance", acc.balance);
        model.addAttribute("currency", acc.currency);
        model.addAttribute("openTrades", acc.openTrades);
        model.addAttribute("marginAvailable", acc.marginAvailable);
        model.addAttribute("nav", acc.nav);

        return "forex_account";
    }
}
