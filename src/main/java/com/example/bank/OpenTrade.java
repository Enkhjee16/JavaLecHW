package com.example.bank;

public class OpenTrade {

    public int tradeId;
    public String instrument;
    public int units;
    public double price;

    public OpenTrade(int tradeId, String instrument, int units, double price) {
        this.tradeId = tradeId;
        this.instrument = instrument;
        this.units = units;
        this.price = price;
    }
}
