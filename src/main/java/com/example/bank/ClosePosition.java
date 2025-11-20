package com.example.bank;

public class ClosePosition {

    public int tradeId;
    public String status;
    public double closePrice;

    public ClosePosition(int tradeId, String status, double closePrice) {
        this.tradeId = tradeId;
        this.status = status;
        this.closePrice = closePrice;
    }
}
