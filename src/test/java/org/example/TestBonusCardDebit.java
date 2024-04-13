package org.example;

import java.math.BigDecimal;

import static org.junit.Assert.*;

public class TestBonusCardDebit {

    public static void main(String[] args) {

        BigDecimal bigDecimal = new BigDecimal("0.00");
        BonusCardDebit bonusCardDebit = new BonusCardDebit(bigDecimal, new BigDecimal("0.00"), new BigDecimal("0.00"));//Создали бонусную карту с нулевым балансом
        BigDecimal bigDecimal1 = new BigDecimal("100000.00");
        bonusCardDebit.top_up(bigDecimal1, bonusCardDebit);
        BigDecimal count = new BigDecimal("5.00");
        assertTrue(bonusCardDebit.getSavingsFromReplenishments().compareTo(count) == 0);
        System.out.println("Баланс после пополнения на 100000 рублей = " + bonusCardDebit.getBalanceInfo());
        System.out.println("Накопление в размере 0.005% от суммы пополнений = " + bonusCardDebit.getSavingsFromReplenishments() + "\n");

        BigDecimal bigDecimal3 = new BigDecimal("500000.00");
        bonusCardDebit.top_up(bigDecimal3, bonusCardDebit);
        System.out.println("Баланс после пополнения на 500000.00 рублей = " + bonusCardDebit.getBalanceInfo());
        System.out.println("Накопление в размере 0.005% от суммы пополнений = " + bonusCardDebit.getSavingsFromReplenishments() + "\n");


        bonusCardDebit.pay(bigDecimal1, bonusCardDebit);
        System.out.println("Баланс после оплаты на 100000.00 рублей = " + bonusCardDebit.getBalanceInfo());
        System.out.println("Бонусные баллы в размере 1% от покупок = " + bonusCardDebit.getBonusPoints() + "\n");

        bonusCardDebit.pay(bigDecimal3, bonusCardDebit);
        System.out.println("Баланс после оплаты на 500000.00 рублей = " + bonusCardDebit.getBalanceInfo());
        System.out.println("Бонусные баллы в размере 1% от покупок = " + bonusCardDebit.getBonusPoints());

        System.out.println("\n" + bonusCardDebit.getAvailableFundsInfo());

    }

}
