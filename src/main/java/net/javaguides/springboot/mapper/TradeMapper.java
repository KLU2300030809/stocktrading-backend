package net.javaguides.springboot.mapper;

import net.javaguides.springboot.dto.TradeDTO;
import net.javaguides.springboot.model.Trade;

public class TradeMapper {

    public static TradeDTO toDTO(Trade trade) {
        return new TradeDTO(
            trade.getId(),
            trade.getSymbol(),
            trade.getQuantity(),
            trade.getPrice()
        );
    }

    public static Trade toEntity(TradeDTO dto) {
        Trade trade = new Trade();
        trade.setId(dto.getId());
        trade.setSymbol(dto.getSymbol());
        trade.setQuantity(dto.getQuantity());
        trade.setPrice(dto.getPrice());
        return trade;
    }
}
