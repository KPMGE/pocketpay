import org.springframework.http.ProblemDetail;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.kpmge.pocketpay.exceptions.PocketPayException;

@RestControllerAdvice
public class RestExceptionHandler {
    @ExceptionHandler(PocketPayException.class)
    public ProblemDetail handlePoketpayException(PocketPayException e) {
        e.toProblemDetail();
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ProblemDetail handleMethodArgumentNotValidException(MethodArgumentNotValidException e) {
        var errorFields = e.getFieldErrors()
            .stream()
            .map(f -> new InvalidParam(f.getField(), f.getDefaultMessage()))
            .toList();
    }

    private record InvalidParam(String name, String reason) {}
}