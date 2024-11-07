package org.example;

import org.example.hasze.hasze;
import org.example.transakcje.Transaction;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Transaction> transactions = hasze.generateTransactions(5);

        for (Transaction transaction : transactions) {
            System.out.println(transaction);
            System.out.println("Obl Hash: " + transaction.calculateHash());
        }
    }
}
