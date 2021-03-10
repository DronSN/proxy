package ru.skvrez.proxy_example;

import java.math.BigDecimal;

public class App {
    private static final String DEV_ENV = "dev";
    private static final String PROD_ENV = "prod";
    private static final String USER_NAME = "Jhon";
    public static void main(String[] args) {
        BankAccount bankAccount = new BankAccountFactory().getBankAccount(PROD_ENV);
        BigDecimal userAccountAmount = bankAccount.getAmountByUser(USER_NAME);
        System.out.println(userAccountAmount);
    }
}
