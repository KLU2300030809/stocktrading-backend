package net.javaguides.springboot.model;

public class Trade {

    private Long id;
    private String symbol;
    private int quantity;
    private double price;

    public Trade() {
    }

    public Trade(Long id, String symbol, int quantity, double price) {
        this.id = id;
        this.symbol = symbol;
        this.quantity = quantity;
        this.price = price;
    }

    // Getters and setters
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
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
