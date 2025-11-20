package com.example.bank;

import com.google.gson.JsonObject;

public class ForexService {


    public static final String TOKEN = "DEMO_TOKEN_NOT_REQUIRED";
    public static final String ACCOUNT = "62630935";


    // TASK 4: GET ACCOUNT INFO (Simulated OANDA JSON)

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


    // TASK 5: GET ACTUAL FOREX PRICE (Simulated JSON)
    public static ActualPrice getActualPrice(String instrument) {

        // Simulated JSON response (like OANDA "pricing" endpoint)
        JsonObject obj = new JsonObject();
        obj.addProperty("instrument", instrument);
        obj.addProperty("bid", 1.08512);
        obj.addProperty("ask", 1.08534);
        obj.addProperty("time", "2025-01-10T14:52:00Z");

        ActualPrice price = new ActualPrice();
        price.instrument = obj.get("instrument").getAsString();
        price.bid = obj.get("bid").getAsDouble();
        price.ask = obj.get("ask").getAsDouble();
        price.time = obj.get("time").getAsString();

        return price;
    }

}
