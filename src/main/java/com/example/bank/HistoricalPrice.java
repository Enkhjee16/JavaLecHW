package com.example.bank;

public class HistoricalPrice {
    public String time;
    public double bid;
    public double ask;

    public HistoricalPrice(String time, double bid, double ask) {
        this.time = time;
        this.bid = bid;
        this.ask = ask;
    }
}
