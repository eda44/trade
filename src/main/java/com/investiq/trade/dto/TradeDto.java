package com.investiq.trade.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class TradeDto {

    private Long id;

    private Long userId;

    private Long stockId;

    private Long countLots;

    private BigDecimal price;

    private Boolean isAbleToBuy;
}
