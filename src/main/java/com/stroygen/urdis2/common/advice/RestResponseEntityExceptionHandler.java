package com.stroygen.urdis2.common.advice;

import com.stroygen.urdis2.exception.StoryNotFoundException;
import io.micrometer.common.lang.Nullable;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.net.URI;

@Slf4j
@ControllerAdvice
public class RestResponseEntityExceptionHandler extends ResponseEntityExceptionHandler{

    @ExceptionHandler(StoryNotFoundException.class)
    public ResponseEntity<Object> notFound(Exception ex, WebRequest request) {
        HttpStatus status = HttpStatus.NOT_FOUND;
        String message = ex.getMessage();
        URI type = URI.create("/errors/not-found");

        ProblemDetail body = createProblemDetail(ex, status, message, null, null, request);
        body.setType(type);

        return handleExceptionInternal(ex, body, new HttpHeaders(), status, request);
    }

    @Override
    protected ResponseEntity<Object> handleExceptionInternal(
            Exception ex,
            @Nullable Object body,
            HttpHeaders headers,
            HttpStatusCode statusCode,
            WebRequest request
    ) {
        if (statusCode.is5xxServerError()) {
            log.error(ex.getLocalizedMessage(), ex);  // 5xx 오류 시 예외 로그를 기록
        }
        return super.handleExceptionInternal(ex, body, headers, statusCode, request);
    }
}
