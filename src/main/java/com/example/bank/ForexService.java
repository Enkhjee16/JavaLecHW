package com.example.bank;

import com.google.gson.JsonObject;
import java.util.ArrayList;
import java.util.List;

public class ForexService {

    // No real token needed because we simulate all results
    public static final String TOKEN = "DEMO_TOKEN_NOT_REQUIRED";

    // Demo account ID (not used in simulation but needed for UI display)
    public static final String ACCOUNT = "62630935";

    // =====================================================
    // TASK 4: GET ACCOUNT INFO (Simulated JSON)
    // =====================================================
    public static ForexAccount getAccountInfo() {

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


    // =====================================================
    // TASK 5: GET ACTUAL PRICE (Simulated JSON)
    // =====================================================
    public static ActualPrice getActualPrice(String instrument) {

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


    // =====================================================
    // TASK 6: GET HISTORICAL PRICES (Simulated JSON List)
    // =====================================================
    public static List<HistoricalPrice> getHistoricalPrices(String instrument, String from, String to) {

        List<HistoricalPrice> list = new ArrayList<>();

        // Simulated sample candles
        list.add(new HistoricalPrice("2025-01-01", 1.0801, 1.0803));
        list.add(new HistoricalPrice("2025-01-02", 1.0810, 1.0812));
        list.add(new HistoricalPrice("2025-01-03", 1.0832, 1.0834));
        list.add(new HistoricalPrice("2025-01-04", 1.0798, 1.0800));
        list.add(new HistoricalPrice("2025-01-05", 1.0825, 1.0827));

        return list;
    }


    // =====================================================
    // TASK 7: OPEN FOREX POSITION (Simulated JSON)
    // =====================================================
    public static OpenPosition openPosition(String instrument, int units) {

        // Simulated opening price + fake trade ID
        double price = 1.08512;
        int tradeId = 12345;

        return new OpenPosition(instrument, units, price, tradeId);
    }
    // =====================================================
    // TASK 8: LIST OPEN TRADES (Simulated JSON List)
    // =====================================================
    public static List<OpenTrade> getOpenPositions() {

        List<OpenTrade> list = new ArrayList<>();

        // Simulated open positions
        list.add(new OpenTrade(12345, "EUR_USD", 1000, 1.08512));
        list.add(new OpenTrade(67890, "GBP_USD", -500, 1.26450));
        list.add(new OpenTrade(11223, "USD_JPY", 2000, 149.550));

        return list;
    }
    // =====================================================
    // TASK 9: CLOSE FOREX POSITION (Simulated JSON)
    // =====================================================
    public static ClosePosition closePosition(int tradeId) {

        // Simulated closing data
        double closePrice = 1.08600; // simulated closing price
        String status = "Trade closed successfully";

        return new ClosePosition(tradeId, status, closePrice);
    }


}
