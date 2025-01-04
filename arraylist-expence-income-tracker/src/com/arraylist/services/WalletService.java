package com.arraylist.services;

import com.arraylist.model.Wallet;

import java.util.ArrayList;

public class WalletService {

    private ArrayList<Wallet> wallets = new ArrayList<>();
    private int nextId = 1;

    public Wallet createWallet(String name, double initialBalance) {
        Wallet wallet = new Wallet(nextId++, name, initialBalance);
        wallets.add(wallet);
        return wallet;
    }

    public Wallet getWalletById(int id) {
        for (Wallet wallet : wallets) {
            if (wallet.getId() == id) {
                return wallet;
            }
        }
        return null;
    }

    public ArrayList<Wallet> getAllWallets() {
        return wallets;
    }
}


