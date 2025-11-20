package com.example.bank;

public class OpenPosition {
    public String instrument;
    public int units;
    public double price;
    public int tradeId;

    public OpenPosition(String instrument, int units, double price, int tradeId) {
        this.instrument = instrument;
        this.units = units;
        this.price = price;
        this.tradeId = tradeId;
    }
}
