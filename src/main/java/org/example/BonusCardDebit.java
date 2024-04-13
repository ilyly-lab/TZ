package org.example;

import java.math.BigDecimal;
import java.util.List;

public class BonusCardDebit extends DebitCard {

    private BigDecimal bonusPoints;//Бонусные баллы в размере 1% от покупок.
    private BigDecimal savingsFromReplenishments;//Накопление в размере 0.005% от суммы пополнений

    public BonusCardDebit(BigDecimal initialBalance, BigDecimal savingsFromReplenishments, BigDecimal bonusPoints) {
        super(initialBalance);
        this.savingsFromReplenishments = savingsFromReplenishments;
        this.bonusPoints = bonusPoints;
    }


    public void top_up(BigDecimal sum, BonusCardDebit bonusCardDebit) {
        BigDecimal bigDecimal = bonusCardDebit.getBalanceInfo().add(sum);
        bonusCardDebit.setBalance(bigDecimal);//Пополнили баланс

        BigDecimal percent = sum.multiply(new BigDecimal("0.00005"));
        BigDecimal result = bonusCardDebit.getSavingsFromReplenishments().add(percent);
        bonusCardDebit.setSavingsFromReplenishments(result);//пополнили накопления 0.005% от суммы пополнения
    }

    public boolean pay(BigDecimal sum, BonusCardDebit bonusCardDebit) {
        if (bonusCardDebit.getBalanceInfo().compareTo(sum) >= 0) {
            bonusCardDebit.setBalance(bonusCardDebit.getBalanceInfo().subtract(sum));

            BigDecimal percent = sum.multiply(new BigDecimal("0.001"));
            BigDecimal result = bonusCardDebit.getBonusPoints().add(percent);
            bonusCardDebit.setBonusPoints(result);
            return true;
        }
        else {
            return false;
        }
    }

    public BigDecimal getBonusPoints() {
        return bonusPoints;
    }

    public void setBonusPoints(BigDecimal bonusPoints) {
        this.bonusPoints = bonusPoints;
    }

    public BigDecimal getSavingsFromReplenishments() {
        return savingsFromReplenishments;
    }

    public void setSavingsFromReplenishments(BigDecimal savingsFromReplenishments) {
        this.savingsFromReplenishments = savingsFromReplenishments;
    }

    public String getAvailableFundsInfo() {
        return toString();
    }

    @Override
    public String toString() {
        return "BonusCardDebit{" +
                "bonusPoints = " + bonusPoints +
                ", savingsFromReplenishments = " + savingsFromReplenishments +
                ", balance = " + getBalanceInfo() +
                '}';
    }
}
