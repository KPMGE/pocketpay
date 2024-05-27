package com.kpmge.pocketpay.controllers.dto;

import com.kpmge.pocketpay.entities.Wallet;

public record CreateWalletDto(
    String fullName,
    String cpfCnpj,
    String email, 
    String password
) {
    public Wallet toWallet() {
        return new Wallet(fullName, cpfCnpj, email, password);
    }
}
