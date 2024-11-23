package umc.spring.apiPayload.realException.exception;

import lombok.*;
import org.springframework.http.HttpStatus;

@Getter
@Builder
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ErrorResponse {
  private HttpStatus httpStatus;
  private String code;
  private String message;

  public static ErrorResponse from(ErrorCode errorCode) {
    return ErrorResponse.builder()
            .httpStatus(errorCode.getHttpStatus())
            .code(errorCode.getCode())
            .message(errorCode.getMessage())
            .build();
  }
}
