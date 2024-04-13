package org.example;

import java.math.BigDecimal;

public class TestBonusCardCredit {


    public static void main(String[] args) {

        BigDecimal balance = new BigDecimal("50000");
        BigDecimal limit = new BigDecimal("300000.00");
        BigDecimal cashback = new BigDecimal("0.00");

        BonusCardCredit bonusCardCredit = new BonusCardCredit(balance, limit, cashback);

        System.out.println("Баланс после пополнения = " + bonusCardCredit.getBalanceInfo());
        bonusCardCredit.pay(new BigDecimal("45000.00"), bonusCardCredit);
        System.out.println("Баланс кредитной карты после оплаты на 45000.00 = " + bonusCardCredit.getBalanceInfo());
        System.out.println("Кешбэк = " + bonusCardCredit.getCashback() + "\n");


        bonusCardCredit.pay(new BigDecimal("5000.00"), bonusCardCredit);
        System.out.println("Баланс после оплаты на 5000 рублей = " + bonusCardCredit.getBalanceInfo());
        System.out.println("Кешбэк = " + bonusCardCredit.getCashback());

        System.out.println("\n" + bonusCardCredit.getAvailableFundsInfo());
    }

}
