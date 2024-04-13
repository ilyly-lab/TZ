package org.example;

import java.math.BigDecimal;

/**
 * Hello world!
 *
 */
public class TestCard {
    public static int i = 0;

    public static void main( String[] args )
    {//создаем кредитную карту с лимитом 10 000 рублей
        BigDecimal initialBalance = new BigDecimal("10000.00");//Кредитные средства: 10 000.
        BigDecimal creditLimit = new BigDecimal("10000.00");//Кредитная карта с лимитом 10 000.
        BigDecimal own_funds = new BigDecimal("0.00");//Собственные средства: 0.

        CreditCard creditCard = new CreditCard(initialBalance, creditLimit);
        DebitCard debitCard = new DebitCard(own_funds);
        System.out.println(
                "кредитная карта с лимитом: " + creditCard.getCreditLimit() + "\n" +
                "Кредитные средства: " + creditCard.getBalanceInfo() + "\n" +
                "Собственные средства: " + debitCard.getBalanceInfo() + "\n"
        );

        //пополняем карту на 5000 рублей
        BigDecimal topUpAmount = new BigDecimal("5000.00");
        creditCard.top_up(topUpAmount, creditCard, debitCard);
        testBalance("После пополнения на 5000 рублей: ", creditCard, debitCard);

        //После оплаты на 5 000:
        BigDecimal bigDecimal = new BigDecimal("5000.00");
        debitCard.pay(bigDecimal, debitCard, creditCard);
        testBalance("После оплаты на 5000 рублей: ", creditCard, debitCard);

        //После оплаты на 3 000:
        BigDecimal bigDecimal1 = new BigDecimal("3000.00");
        debitCard.pay(bigDecimal1, debitCard, creditCard);
        testBalance("После оплаты на 3000 рублей: ", creditCard, debitCard);

        //После пополнения на 2 000:
        BigDecimal bigDecimal2 = new BigDecimal("2000.00");
        debitCard.top_up(bigDecimal2, creditCard, debitCard);
        testBalance("После пополнения на 2000 рублей: ", creditCard, debitCard);

        //После пополнения на 2 000:
        BigDecimal bigDecimal3 = new BigDecimal("2000.00");
        debitCard.top_up(bigDecimal3, creditCard, debitCard);
        testBalance("После пополнения на 2000 рублей: ", creditCard, debitCard);



    }

    public static void testBalance(String message, CreditCard card, DebitCard debitCard) {
        System.out.println("Test - " + i++);
        System.out.println(message);
        System.out.println("Кредитные средства: " + card.getBalanceInfo());
        System.out.println("Собственные средства: " + debitCard.getBalanceInfo() + "\n");

        assert card.getBalanceInfo().compareTo(new BigDecimal("10000.00")) > 0 || card.getBalanceInfo().compareTo(new BigDecimal("0.00")) < 0 : "Баланс на кредитке должен быть > 0 и < 10000";
        assert debitCard.getBalanceInfo().compareTo(new BigDecimal("0.00")) < 0 : "Баланс на кредитке должен быть > 0 и < 10000";
    }

}
