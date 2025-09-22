package net.javaguides.springboot.controller;

import net.javaguides.springboot.model.Trade;
import net.javaguides.springboot.service.TradeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/trades")
public class TradeController {

    private final TradeService tradeService;

    @Autowired
    public TradeController(TradeService tradeService) {
        this.tradeService = tradeService;
    }

    @PostMapping
    public ResponseEntity<Trade> createTrade(@RequestBody Trade trade) {
        Trade savedTrade = tradeService.saveTrade(trade);
        return new ResponseEntity<>(savedTrade, HttpStatus.CREATED);
    }

    @GetMapping
    public List<Trade> getAllTrades() {
        return tradeService.getAllTrades();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Trade> getTradeById(@PathVariable Long id) {
        Trade trade = tradeService.getTradeById(id);
        return ResponseEntity.ok(trade);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Trade> updateTrade(@PathVariable Long id, @RequestBody Trade tradeDetails) {
        Trade updatedTrade = tradeService.updateTrade(id, tradeDetails);
        return ResponseEntity.ok(updatedTrade);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTrade(@PathVariable Long id) {
        tradeService.deleteTrade(id);
        return ResponseEntity.noContent().build();
    }
}
