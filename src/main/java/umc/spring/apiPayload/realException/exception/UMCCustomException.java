package umc.spring.apiPayload.realException.exception;

import lombok.Getter;

@Getter
public class UMCCustomException extends RuntimeException {

  private final ErrorCode errorCode;

  public UMCCustomException(ErrorCode errorCode) {
    super(errorCode.getMessage());
    this.errorCode = errorCode;
  }

}
