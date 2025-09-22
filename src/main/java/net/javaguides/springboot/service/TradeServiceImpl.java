package net.javaguides.springboot.service;

import net.javaguides.springboot.exception.TradeNotFoundException;
import net.javaguides.springboot.model.Trade;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class TradeServiceImpl implements TradeService {

    // In-memory store for trades
    private final Map<Long, Trade> tradeStore = new HashMap<>();
    private final AtomicLong idCounter = new AtomicLong();

    @Override
    public Trade saveTrade(Trade trade) {
        long id = idCounter.incrementAndGet();
        trade.setId(id);
        tradeStore.put(id, trade);
        return trade;
    }

    @Override
    public List<Trade> getAllTrades() {
        return new ArrayList<>(tradeStore.values());
    }

    @Override
    public Trade getTradeById(Long id) {
        Trade trade = tradeStore.get(id);
        if (trade == null) {
            throw new TradeNotFoundException("Trade not found with id: " + id);
        }
        return trade;
    }

    @Override
    public Trade updateTrade(Long id, Trade tradeDetails) {
        Trade trade = getTradeById(id);
        trade.setSymbol(tradeDetails.getSymbol());
        trade.setQuantity(tradeDetails.getQuantity());
        trade.setPrice(tradeDetails.getPrice());
        tradeStore.put(id, trade);
        return trade;
    }

    @Override
    public void deleteTrade(Long id) {
        if (!tradeStore.containsKey(id)) {
            throw new TradeNotFoundException("Trade not found with id: " + id);
        }
        tradeStore.remove(id);
    }
}
