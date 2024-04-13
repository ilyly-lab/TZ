package org.example;

import java.math.BigDecimal;

public class BonusCardCredit extends CreditCard{

    private BigDecimal cashback;//Потенциальный кэшбэк 5% от покупок при условии трат больше 5 000 тыс

    public BonusCardCredit(BigDecimal initialBalance, BigDecimal creditLimit, BigDecimal cashback) {
        super(initialBalance, creditLimit);
        this.cashback = cashback;
    }

    public boolean pay(BigDecimal sum, BonusCardCredit bonusCardCredit) {

        if (bonusCardCredit.getBalanceInfo().compareTo(sum) >= 0) {
            BigDecimal result = bonusCardCredit.getBalanceInfo().subtract(sum);
            bonusCardCredit.setBalance(result);

            BigDecimal count = new BigDecimal("5000.00");//если сумма пополнения больше 5000, то пополняем кешбэк на 5% от суммы пополнения
            if (sum.compareTo(count) > 0) {
                BigDecimal percent = sum.multiply(new BigDecimal("0.05"));
                BigDecimal result2 = bonusCardCredit.getCashback().add(percent);
                bonusCardCredit.setCashback(result2);
                return true;
            }
            return true;
        } else {
            return false;
        }
    }

    public BigDecimal getCashback() {
        return cashback;
    }

    public void setCashback(BigDecimal cashback) {
        this.cashback = cashback;
    }

    public String getAvailableFundsInfo() {
        return toString();
    }

    @Override
    public String toString() {
        return "BonusCardCredit{" +
                " cashback = " + cashback +
                ", balance = " + getBalanceInfo() +
                '}';
    }
}
