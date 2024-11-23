package umc.spring.apiPayload.realException.advice;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import umc.spring.apiPayload.realException.exception.ErrorCode;
import umc.spring.apiPayload.realException.exception.ErrorResponse;
import umc.spring.apiPayload.realException.exception.UMCCustomException;

import java.util.stream.Collectors;

@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

  @ExceptionHandler(UMCCustomException.class)
  public ResponseEntity<ErrorResponse> handleCustomException(UMCCustomException e) {
    log.error("CustomException: {}", e.getMessage());
    ErrorResponse response = ErrorResponse.from(e.getErrorCode());
    return ResponseEntity
            .status(e.getErrorCode().getHttpStatus())
            .body(response);
  }

  @ExceptionHandler(MethodArgumentNotValidException.class)
  public ResponseEntity<ErrorResponse> handleValidationException(MethodArgumentNotValidException e) {
    log.error("ValidationException: {}", e.getMessage());
    ErrorResponse response = ErrorResponse.from(ErrorCode.BAD_REQUEST);
    return ResponseEntity
            .status(HttpStatus.BAD_REQUEST)
            .body(response);
  }

  @ExceptionHandler(HttpMessageNotReadableException.class)
  public ResponseEntity<ErrorResponse> handleHttpMessageNotReadableException(HttpMessageNotReadableException e) {
    log.error("HttpMessageNotReadableException: {}", e.getMessage());
    ErrorResponse response = ErrorResponse.from(ErrorCode.BAD_REQUEST);
    return ResponseEntity
            .status(HttpStatus.BAD_REQUEST)
            .body(response);
  }

  @ExceptionHandler(Exception.class)
  public ResponseEntity<ErrorResponse> handleAllException(Exception e) {
    log.error("UnhandledException: {}", e.getMessage());
    ErrorResponse response = ErrorResponse.from(ErrorCode.INTERNAL_SERVER_ERROR);
    return ResponseEntity
            .status(HttpStatus.INTERNAL_SERVER_ERROR)
            .body(response);
  }
}
