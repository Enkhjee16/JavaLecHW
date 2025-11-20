package com.example.bank;

import com.google.gson.JsonObject;

public class ForexService {

    public static final String TOKEN = "DEMO_TOKEN_NOT_REQUIRED";
    public static final String ACCOUNT = "62630935";

    public static ForexAccount getAccountInfo() throws Exception {

        // Simulated JSON like OANDA returns
        JsonObject obj = new JsonObject();
        obj.addProperty("balance", "50000.00");
        obj.addProperty("currency", "EUR");
        obj.addProperty("openTradeCount", 0);
        obj.addProperty("marginAvailable", "50000.00");
        obj.addProperty("NAV", "50000.00");

        ForexAccount acc = new ForexAccount();
        acc.balance = obj.get("balance").getAsString();
        acc.currency = obj.get("currency").getAsString();
        acc.openTrades = obj.get("openTradeCount").getAsInt();
        acc.marginAvailable = obj.get("marginAvailable").getAsString();
        acc.nav = obj.get("NAV").getAsString();

        return acc;
    }
}
