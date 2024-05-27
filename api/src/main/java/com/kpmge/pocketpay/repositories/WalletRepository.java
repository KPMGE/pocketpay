package com.kpmge.pocketpay.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kpmge.pocketpay.entities.Wallet;

public interface WalletRepository extends JpaRepository<Wallet, Long> {}
    