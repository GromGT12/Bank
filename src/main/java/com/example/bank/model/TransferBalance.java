package com.example.bank.model;

import lombok.Data;

import java.math.BigDecimal;

@Data//содержит геттеры, сеттеры, и toString и hashCode equals
public class TransferBalance {
    private Long from;
    private Long to;
    private BigDecimal amount;

}


