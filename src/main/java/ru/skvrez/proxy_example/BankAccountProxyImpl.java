package ru.skvrez.proxy_example;

import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.time.Instant;

public class BankAccountProxyImpl implements BankAccount {

    private static final String END_LINE = "\n";
    BankAccount bankAccount;
    Path logFile;

    public BankAccountProxyImpl() {
        this.logFile = Paths.get("./access_account.log");
        this.bankAccount = new BankAccountImpl();
    }

    @Override
    public BigDecimal getAmountByUser(String userName) {
        System.out.println("Used BankAccountProxyImpl");
        logAccountAccess(userName);
        return bankAccount.getAmountByUser(userName);
    }

    private void logAccountAccess(String userName) {
        String logFileLine =
                String.format("Reading account info about user %s at %s%s", userName, Instant.now(), END_LINE);
        try {
            Files.write(logFile, logFileLine.getBytes(), StandardOpenOption.APPEND);
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
