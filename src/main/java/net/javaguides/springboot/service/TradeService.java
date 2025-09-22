package net.javaguides.springboot.service;

import net.javaguides.springboot.model.Trade;

import java.util.List;

public interface TradeService {

    Trade saveTrade(Trade trade);

    List<Trade> getAllTrades();

    Trade getTradeById(Long id);

    Trade updateTrade(Long id, Trade trade);

    void deleteTrade(Long id);
}
