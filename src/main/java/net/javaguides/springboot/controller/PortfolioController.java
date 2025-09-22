package net.javaguides.springboot.controller;

import net.javaguides.springboot.model.PortfolioEntry;
import net.javaguides.springboot.service.PortfolioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/portfolio")
@CrossOrigin
public class PortfolioController {

    @Autowired
    private PortfolioService portfolioService;

    @PostMapping("/buy")
    public ResponseEntity<String> buyStock(@RequestParam String symbol,
                                           @RequestParam int quantity,
                                           @RequestParam double price) {
        portfolioService.buyStock(symbol, quantity, price);
        return ResponseEntity.ok("Bought " + quantity + " shares of " + symbol);
    }

    @PostMapping("/sell")
    public ResponseEntity<String> sellStock(@RequestParam String symbol,
                                            @RequestParam int quantity) {
        try {
            portfolioService.sellStock(symbol, quantity);
            return ResponseEntity.ok("Sold " + quantity + " shares of " + symbol);
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping
    public List<PortfolioEntry> getPortfolio() {
        return portfolioService.getPortfolio();
    }
}
