package net.javaguides.springboot.dto;

public class TradeRequest {
    private String symbol;
    private int quantity;
    private double price;

    public TradeRequest() {
    }

    public TradeRequest(String symbol, int quantity, double price) {
        this.symbol = symbol;
        this.quantity = quantity;
        this.price = price;
    }

    // Getters and setters
    public String getSymbol() {
        return symbol;
    }
    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }
    public int getQuantity() {
        return quantity;
    }
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    public double getPrice() {
        return price;
    }
    public void setPrice(double price) {
        this.price = price;
    }
}
