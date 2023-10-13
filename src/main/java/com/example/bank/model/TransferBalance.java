package com.example.bank.model;

import lombok.Data;

import java.math.BigDecimal;

@Data//contains getter and setter. And also toString and equals() and hashCode()
public class TransferBalance {
    private Long from;
    private Long to;
    private BigDecimal amount;

}


