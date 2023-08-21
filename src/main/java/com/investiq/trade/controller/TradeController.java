package com.investiq.trade.controller;

import com.investiq.trade.dto.TradeDto;
import com.investiq.trade.service.TradeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController()
@RequestMapping("/api/v1/trades")
public class TradeController {

    private final TradeService tradeService;

    public TradeController(TradeService tradeService) {
        this.tradeService = tradeService;
    }

    @GetMapping()
    public ResponseEntity<List<TradeDto>> getAllTrades() {
        return new ResponseEntity<>(tradeService.getAllTrades(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TradeDto> getTrade(@PathVariable("id") Long id) {
        return new ResponseEntity<>(tradeService.getTradeById(id), HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity<TradeDto> saveTrade(@RequestBody TradeDto tradeDto) {
        return new ResponseEntity<>(tradeService.saveNewTrade(tradeDto), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteTrade(@PathVariable("id") Long id) {
        return new ResponseEntity<>("OK", HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<TradeDto> updateTrade(@PathVariable ("id") Long id, @RequestBody TradeDto tradeDto) {
        return new ResponseEntity<>(tradeService.updateTrade(id, tradeDto), HttpStatus.OK);
    }
}
