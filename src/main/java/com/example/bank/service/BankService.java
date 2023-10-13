package com.example.bank.service;

import com.example.bank.model.TransferBalance;
import com.example.bank.repository.BalanceRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
@AllArgsConstructor
public class BankService {

    private final BalanceRepository repository;

    public BigDecimal getBalance(Long accountId) {

        BigDecimal balance = repository.getBalanceForId(accountId);
        if (balance == null) {
            throw new IllegalArgumentException();
        }
        return balance;
    }

    public BigDecimal addMoney(Long to, BigDecimal amount) {
        BigDecimal currentBalance = repository.getBalanceForId(to);
        if (currentBalance == null) {
            repository.save(to, amount);
            return amount;

        } else {
            BigDecimal updateBalance = currentBalance.add(amount);
            repository.save(to, updateBalance);
            return updateBalance;
        }
    }

    public void makeTransfer(TransferBalance transferBalance) {
        BigDecimal fromBalance = repository.getBalanceForId(transferBalance.getFrom());
        BigDecimal toBalance = repository.getBalanceForId(transferBalance.getFrom());
        if (fromBalance == null || toBalance == null) throw new IllegalArgumentException(" no ids");
        if (transferBalance.getAmount().compareTo(fromBalance) > 0) throw new IllegalArgumentException("no money");

        BigDecimal updateFromBalance = fromBalance.subtract(transferBalance.getAmount());
        BigDecimal updateToBalance = fromBalance.subtract(transferBalance.getAmount());
        repository.save(transferBalance.getFrom(), updateFromBalance);
        repository.save(transferBalance.getTo(), updateToBalance);
    }
}
