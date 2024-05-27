package com.kpmge.pocketpay.config;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.kpmge.pocketpay.entities.WalletType;
import com.kpmge.pocketpay.repositories.WalletTypeRepository;
import java.util.Arrays;

@Configuration
public class DataLoader implements CommandLineRunner {

    private final WalletTypeRepository walletTypeRepository;

    public DataLoader(WalletTypeRepository walletTypeRepository) {
        this.walletTypeRepository = walletTypeRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        Arrays.stream(WalletType.Variants.values()).forEach(walletType -> walletTypeRepository.save(walletType.get()));
    }
}
