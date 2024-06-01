package com.kpmge.pocketpay.services;

import org.springframework.stereotype.Service;

import com.kpmge.pocketpay.controllers.dto.CreateWalletDto;
import com.kpmge.pocketpay.entities.Wallet;
import com.kpmge.pocketpay.exceptions.WalletAlreadyExistsException;
import com.kpmge.pocketpay.repositories.WalletRepository;

@Service
public class WalletService {
    private final WalletRepository walletRepository;

    public WalletService(WalletRepository walletRepository) {
        this.walletRepository = walletRepository;
    }

    public Wallet createWallet(CreateWalletDto dto) {
        var walletDb = walletRepository.findByCpfCnpjOrEmail(dto.cpfCnpj(), dto.email());
        if (walletDb.isPresent()) {
            throw new WalletAlreadyExistsException("CpfCnpj or Email already exists.");
        }

        return walletRepository.save(dto.toWallet());
    }
}
