package com.investiq.trade.service;

import com.investiq.trade.dto.TradeDto;
import com.investiq.trade.error.NoSuchTradeException;
import com.investiq.trade.mapper.TradeMapper;
import com.investiq.trade.model.Trade;
import com.investiq.trade.repository.TradeRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TradeService {

    private final TradeRepository tradeRepository;
    private final TradeMapper tradeMapper;

    public TradeService(TradeRepository tradeRepository, TradeMapper tradeMapper) {
        this.tradeRepository = tradeRepository;
        this.tradeMapper = tradeMapper;
    }

    public List<TradeDto> getAllTrades() {
        return tradeMapper.convertModelToDto(tradeRepository.findAll());
    }
    public TradeDto saveNewTrade(TradeDto tradeDto){
        Trade trade = tradeRepository.save(tradeMapper.convertDtoToModel(tradeDto));
        return tradeMapper.convertModelToDto(trade);
    }

    public TradeDto getTradeById(Long id) {
        Optional<Trade> optionalTrade = tradeRepository.findById(id);
        return optionalTrade.map(tradeMapper::convertModelToDto).orElse(null);
    }

    public void deleteById(Long id) {
        tradeRepository.deleteById(id);
    }

    public TradeDto updateTrade(Long id, TradeDto tradeDto) {
        Trade newTrade = tradeMapper.convertDtoToModel(tradeDto);
        Optional<Trade> optionalTrade = tradeRepository.findById(id);
        if (optionalTrade.isPresent()) {
            Trade trade = optionalTrade.get();
            trade.setId(newTrade.getId());
            trade.setPrice(newTrade.getPrice());
            trade.setUserId(newTrade.getUserId());
            trade.setCountLots(newTrade.getCountLots());
            trade.setStockId(newTrade.getStockId());
            trade.setIsAbleToBuy(newTrade.getIsAbleToBuy());
            return tradeMapper.convertModelToDto(tradeRepository.save(trade));
        }
        return null;
    }
}
