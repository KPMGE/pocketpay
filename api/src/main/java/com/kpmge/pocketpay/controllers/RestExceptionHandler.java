import org.springframework.http.ProblemDetail;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.kpmge.pocketpay.exceptions.PocketPayException;

@RestControllerAdvice
public class RestExceptionHandler {
    @ExceptionHandler(PocketPayException.class)
    public ProblemDetail handlePoketpayException(PocketPayException e) {
        e.toProblemDetail();
    }
}