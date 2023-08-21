package com.investiq.trade.model;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Setter
@Getter
public class Trade {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "user_id")
    private Long userId;

    @Column(name = "stock_id")
    private Long stockId;

    @Column(name = "count_lots")
    private Long countLots;

    private BigDecimal price;

    @Column(name = "is_able_to_buy")
    private Boolean isAbleToBuy;
}
