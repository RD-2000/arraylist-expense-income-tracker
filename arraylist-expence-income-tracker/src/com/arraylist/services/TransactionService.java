package com.arraylist.services;

import com.arraylist.model.Transaction;
import com.arraylist.model.Wallet;

import java.time.LocalDate;
import java.util.ArrayList;

public class TransactionService {
    private ArrayList<Transaction> transactions = new ArrayList<>();
    private int nextId = 1;

    public void addTransaction(Wallet wallet, String type, double amount, String category) {
        if (type.equalsIgnoreCase("Expense") && wallet.getBalance() < amount) {
            System.out.println("Insufficient balance!");
            return;
        }

        if (type.equalsIgnoreCase("Expense")) {
            wallet.setBalance(wallet.getBalance() - amount);
        } else if (type.equalsIgnoreCase("Income")) {
            wallet.setBalance(wallet.getBalance() + amount);
        }

        Transaction transaction = new Transaction(nextId++, type, amount, category, LocalDate.now());
        transactions.add(transaction);
        System.out.println("Transaction added successfully.");
    }

    public ArrayList<Transaction> getTransactionsByWallet(Wallet wallet) {
        ArrayList<Transaction> walletTransactions = new ArrayList<>();
        for (Transaction transaction : transactions) {
            if (transaction.getId() == wallet.getId()) {
                walletTransactions.add(transaction);
            }
        }
        return walletTransactions;
    }
}


