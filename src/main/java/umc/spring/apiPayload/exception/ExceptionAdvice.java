//package umc.spring.apiPayload.exception;
//
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.validation.ConstraintViolationException;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.http.HttpHeaders;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.HttpStatusCode;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.MethodArgumentNotValidException;
//import org.springframework.web.bind.annotation.ExceptionHandler;
//import org.springframework.web.bind.annotation.RestController;
//import org.springframework.web.bind.annotation.RestControllerAdvice;
//import org.springframework.web.context.request.ServletWebRequest;
//import org.springframework.web.context.request.WebRequest;
//import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
//import umc.spring.apiPayload.ApiResponse;
//import umc.spring.apiPayload.code.ErrorReasonDTO;
//import umc.spring.apiPayload.code.status.ErrorStatus;
//import umc.spring.apiPayload.code.status.GeneralException;
//
//import java.util.LinkedHashMap;
//import java.util.Map;
//import java.util.Optional;
//
//@Slf4j
//@RestControllerAdvice
//public class ExceptionAdvice extends ResponseEntityExceptionHandler {
//
//    @ExceptionHandler(value = GeneralException.class)
//    public ResponseEntity<ApiResponse<Object>> handleGeneralException(GeneralException e) {
//        log.error("HandleGeneralException: {}", e.getMessage());
//        ErrorReasonDTO errorReason = e.getErrorReason();
//        return ResponseEntity
//                .status(e.getCode().getHttpStatus())  // 올바른 HTTP 상태 코드 사용
//                .body(ApiResponse.onFailure(errorReason.getCode(), errorReason.getMessage(), null));
//    }
//
//
//    // Validation 예외 처리
//    @Override
//    protected ResponseEntity<Object> handleMethodArgumentNotValid(
//            MethodArgumentNotValidException e,
//            HttpHeaders headers,
//            HttpStatusCode status,
//            WebRequest request) {
//
//        log.error("HandleMethodArgumentNotValidException: {}", e.getMessage());
//        Map<String, String> errors = new LinkedHashMap<>();
//
//        e.getBindingResult().getFieldErrors().forEach(fieldError -> {
//            String fieldName = fieldError.getField();
//            String errorMessage = Optional.ofNullable(fieldError.getDefaultMessage()).orElse("");
//            errors.put(fieldName, errorMessage);
//        });
//
//        return ResponseEntity
//                .status(HttpStatus.BAD_REQUEST)
//                .body(ApiResponse.onFailure(ErrorStatus._BAD_REQUEST.getCode(),
//                        ErrorStatus._BAD_REQUEST.getMessage(),
//                        errors));
//    }
//
//    // ConstraintViolationException 처리
//    @ExceptionHandler(ConstraintViolationException.class)
//    public ResponseEntity<ApiResponse<Object>> handleConstraintViolationException(ConstraintViolationException e) {
//        log.error("HandleConstraintViolationException: {}", e.getMessage());
//        String errorMessage = e.getConstraintViolations().stream()
//                .map(violation -> violation.getMessage())
//                .findFirst()
//                .orElse("Validation failed");
//
//        return ResponseEntity
//                .status(HttpStatus.BAD_REQUEST)
//                .body(ApiResponse.onFailure(ErrorStatus._BAD_REQUEST.getCode(),
//                        errorMessage,
//                        null));
//    }
//
//    // 그 외 모든 예외 처리
//    @ExceptionHandler(Exception.class)
//    public ResponseEntity<ApiResponse<Object>> handleAllException(Exception e) {
//        log.error("HandleException: {}", e.getMessage());
//        return ResponseEntity
//                .status(HttpStatus.INTERNAL_SERVER_ERROR)
//                .body(ApiResponse.onFailure(
//                        ErrorStatus._INTERNAL_SERVER_ERROR.getCode(),
//                        ErrorStatus._INTERNAL_SERVER_ERROR.getMessage(),
//                        e.getMessage()));
//    }
//}