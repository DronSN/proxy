package ru.skvrez.proxy_example;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

public class BankAccountImpl implements BankAccount {

    private Map<String, BigDecimal> userAccounts;

    public BankAccountImpl() {
        userAccounts = new HashMap<>();
        userAccounts.put("Alex", BigDecimal.valueOf(1_000));
        userAccounts.put("Jhon", BigDecimal.valueOf(897));
        userAccounts.put("Mary", BigDecimal.valueOf(10_987));
    }

    @Override
    public BigDecimal getAmountByUser(String userName) {
        System.out.println("Used BankAccountImpl");
        return userAccounts.get(userName);
    }
}
