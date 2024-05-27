package com.kpmge.pocketpay.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kpmge.pocketpay.entities.WalletType;

public interface WalletTypeRepository extends JpaRepository<WalletType, Long> { }
