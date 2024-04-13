package org.example;

import java.math.BigDecimal;

public class CreditCard extends BankCard {

    private BigDecimal creditLimit;

    public CreditCard(BigDecimal initialBalance, BigDecimal creditLimit) {
        super(initialBalance);
        this.creditLimit = creditLimit;
    }

    public BigDecimal getCreditLimit() {
        return creditLimit;
    }

}
