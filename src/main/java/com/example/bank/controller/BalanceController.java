package com.example.bank.controller;


import com.example.bank.model.TransferBalance;
import com.example.bank.service.BankService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

@RestController("/balance")
@AllArgsConstructor
public class BalanceController {

    private final BankService bankService;

    @GetMapping("/{accountId}")
    public BigDecimal getBalance(@PathVariable Long accountId) {
        return bankService.getBalance(accountId);

    }

    @PostMapping("/{add}")
    public BigDecimal addMoney(@RequestBody TransferBalance transferBalance) {
        return bankService.addMoney(transferBalance.getTo(), transferBalance.getAmount());

    }

    @PostMapping("/{transfer}")
    public void transfer(@RequestBody TransferBalance transferBalance) {
        bankService.makeTransfer(transferBalance);

    }
}
