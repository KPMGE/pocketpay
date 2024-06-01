package com.kpmge.pocketpay.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;

public class WalletAlreadyExistsException extends PocketPayException {
    private String detail;

    public WalletAlreadyExistsException(String detail) {
        this.detail = detail;
    }

    @Override
    public ProblemDetail toProblemDetail() {
        var p = ProblemDetail.forStatus(HttpStatus.UNPROCESSABLE_ENTITY);

        p.setTitle("Wallet data already exists.");
        p.setDetail(detail);

        return p;
    }
}
