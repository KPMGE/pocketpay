package com.kpmge.pocketpay.services;

import org.springframework.stereotype.Service;

import com.kpmge.pocketpay.controllers.dto.CreateWalletDto;
import com.kpmge.pocketpay.entities.Wallet;
import com.kpmge.pocketpay.repositories.WalletRepository;

@Service
public class WalletService {
    private final WalletRepository walletRepository;

    public WalletService(WalletRepository walletRepository) {
        this.walletRepository = walletRepository;
    }

    public Wallet createWallet(CreateWalletDto dto) {
        return walletRepository.save(dto.toWallet());
    }
}
