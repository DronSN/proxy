package ru.skvrez.proxy_example;

public class BankAccountFactory {

    private static final String DEV_ENV = "dev";

    public BankAccount getBankAccount(String env) {
        if (env.equals(DEV_ENV)) {
            return new BankAccountImpl();
        } else {
            return new BankAccountProxyImpl();
        }
    }
}
