package org.example;

import java.math.BigDecimal;

public abstract class BankCard {//сущность банковская карта

    private BigDecimal balance;

    public BankCard(BigDecimal initialBalance) {
        this.balance = initialBalance;
    }

    public void top_up(BigDecimal amount, CreditCard creditCard, DebitCard debitCard) {//если кредитный лимит больше чем остаток, то дополняем до верха, и остальное кладем на дебетовую карту? иначе сразу кладем на дебетовую
        if (creditCard.getCreditLimit().compareTo(creditCard.getBalanceInfo()) > 0) {
            BigDecimal ostatok = creditCard.getCreditLimit().subtract(creditCard.getBalanceInfo());//сколько надо дополнить до 10 000 рублей
            if (ostatok.compareTo(amount) >= 0) {
                creditCard.setBalance(creditCard.getBalanceInfo().add(amount));
            } else {
                creditCard.setBalance(creditCard.getBalanceInfo().add(ostatok));
                BigDecimal amoun2 = amount.subtract(ostatok);//вычитаем из пополняемой суммы то что положили на кредитку
                debitCard.setBalance(debitCard.getBalanceInfo().add(amoun2));
            }

        } else {
            debitCard.setBalance(debitCard.getBalanceInfo().add(amount));
        }
    }
    public boolean pay(BigDecimal amount, DebitCard debitCard, CreditCard creditCard) {
        BigDecimal totalFunds = debitCard.getBalanceInfo().add(creditCard.getBalanceInfo());
        if (totalFunds.compareTo(amount) >= 0) {
            if (debitCard.getBalanceInfo().compareTo(amount) >= 0) {
                debitCard.setBalance(debitCard.getBalanceInfo().subtract(amount));
            } else {
                BigDecimal remainingAmount = amount.subtract(debitCard.getBalanceInfo());
                debitCard.setBalance(BigDecimal.ZERO);
                creditCard.setBalance(creditCard.getBalanceInfo().subtract(remainingAmount));
            }
            return true;
        } else {
            return false;
        }
    }
    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public BigDecimal getBalanceInfo() {
        return balance;
    }

    @Override
    public String toString() {
        return "BankCard{" +
                "balance=" + balance +
                '}';
    }
}
