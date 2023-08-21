package com.investiq.trade.mapper;

import com.investiq.trade.dto.TradeDto;
import com.investiq.trade.model.Trade;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring", injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface TradeMapper {
    List<TradeDto> convertModelToDto(List<Trade> trades);

    Trade convertDtoToModel(TradeDto tradeDto);

    TradeDto convertModelToDto(Trade trade);
}
