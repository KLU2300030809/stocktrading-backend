package net.javaguides.springboot.service;

import net.javaguides.springboot.model.PortfolioEntry;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class PortfolioService {

    private final Map<String, PortfolioEntry> portfolio = new HashMap<>();

    public void buyStock(String symbol, int quantity, double price) {
        symbol = symbol.toUpperCase();
        PortfolioEntry entry = portfolio.getOrDefault(symbol, new PortfolioEntry(symbol, 0, 0));

        int newQuantity = entry.getQuantity() + quantity;
        double newAvgPrice = ((entry.getAvgPrice() * entry.getQuantity()) + (price * quantity)) / newQuantity;

        entry.setQuantity(newQuantity);
        entry.setAvgPrice(newAvgPrice);
        portfolio.put(symbol, entry);
    }

    public void sellStock(String symbol, int quantity) {
        symbol = symbol.toUpperCase();
        PortfolioEntry entry = portfolio.get(symbol);
        if (entry == null || entry.getQuantity() < quantity) {
            throw new RuntimeException("Not enough shares to sell");
        }

        entry.setQuantity(entry.getQuantity() - quantity);
        if (entry.getQuantity() == 0) {
            portfolio.remove(symbol);
        }
    }

    public List<PortfolioEntry> getPortfolio() {
        return new ArrayList<>(portfolio.values());
    }
}
