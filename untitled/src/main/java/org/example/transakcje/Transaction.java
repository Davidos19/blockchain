package org.example.transakcje;
import org.apache.commons.codec.digest.DigestUtils;
import org.example.hasze.hasze;
public class Transaction {
    private final double amount;
    private final String lastTransaction;
    private final int nonce;

    public Transaction(double amount, String lastTransaction, int nonce) {
        this.amount = amount;
        this.lastTransaction = lastTransaction;
        this.nonce = nonce;
    }

    public double getAmount() {
        return amount;
    }
    public String getLastTransaction() {
        return lastTransaction;
    }

    public int getNonce() {
        return nonce;
    }

    @Override
    public String toString() {
        return "{" + "\n" +
                "amount: " + amount + "\n" +
                "lastTransaction: '" + lastTransaction + '\'' + "\n"+
                "nonce: " + nonce + "\n" + '}';

    }

    public String calculateHash() {
        String input = amount + lastTransaction + nonce;
        return DigestUtils.md5Hex(input);
    }
}

