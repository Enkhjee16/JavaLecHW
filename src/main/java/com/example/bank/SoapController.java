package com.example.bank;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import soapclient.*;

@Controller
public class SoapController {

    @GetMapping("/soap")
    public String soapForm() {
        return "soap_form";
    }

    @PostMapping("/soap/result")
    public String soapResult(
            @RequestParam String currency,
            @RequestParam String startDate,
            @RequestParam String endDate,
            Model model
    ) throws Exception {

        MNBArfolyamServiceSoapImpl service = new MNBArfolyamServiceSoapImpl();
        MNBArfolyamServiceSoap client = service.getCustomBindingMNBArfolyamServiceSoap();

        String xml = client.getExchangeRates(startDate, endDate, currency);

        model.addAttribute("currency", currency);
        model.addAttribute("startDate", startDate);
        model.addAttribute("endDate", endDate);
        model.addAttribute("rates", XmlParser.parse(xml));

        return "soap_result";
    }
}
