package org.example.hasze;

import org.example.transakcje.Transaction;
import org.apache.commons.codec.digest.DigestUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class hasze {
    public static List<Transaction> generateTransactions(int count) {
        String initialHash = "4d00d79b6733c9cc066584a02ed03410";
        List<Transaction> transactions = new ArrayList<>();

        for (int i = 0; i < count; i++) {
            double randomAmount = generateRandomAmount();
            Transaction transaction = findValidNonce(randomAmount, initialHash);
            transactions.add(transaction);
            initialHash = transaction.calculateHash();
        }

        return transactions;
    }

    private static Transaction findValidNonce(double amount, String lastTransaction) {
        int nonce = 0;
        String hash;
        do {
            hash = new Transaction(amount, lastTransaction, nonce).calculateHash();
            nonce++;
        } while (!hash.endsWith("00000"));

        return new Transaction(amount, lastTransaction, nonce - 1);
    }

    private static double generateRandomAmount() {
        Random random = new Random();
        return Math.round((random.nextDouble() * 1000) * 100.0) / 100.0;
    }

    private static String generateRandomHash() {
        Random random = new Random();
        byte[] bytes = new byte[16];
        random.nextBytes(bytes);
        return DigestUtils.md5Hex(bytes);
    }
}
