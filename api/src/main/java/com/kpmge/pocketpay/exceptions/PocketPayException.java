package com.kpmge.pocketpay.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;

public class PocketPayException extends RuntimeException {
    public ProblemDetail toProblemDetail() {
        var p =  ProblemDetail.forStatus(HttpStatus.INTERNAL_SERVER_ERROR);
        p.setTitle("Pocketpay internal server error.");
        return p;
    }
}
