package umc.spring.apiPayload.realException.exception;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

import static org.springframework.http.HttpStatus.NOT_FOUND;

@Getter
@RequiredArgsConstructor
public enum ErrorCode {
  // Common Errors (1000-1999)
  INTERNAL_SERVER_ERROR(HttpStatus.INTERNAL_SERVER_ERROR, "COMMON-1000", "서버 에러가 발생했습니다."),
  BAD_REQUEST(HttpStatus.BAD_REQUEST, "COMMON-1001", "잘못된 요청입니다."),
  UNAUTHORIZED(HttpStatus.UNAUTHORIZED, "COMMON-1002", "인증이 필요합니다."),
  FORBIDDEN(HttpStatus.FORBIDDEN, "COMMON-1003", "금지된 요청입니다."),

  // Member Errors (2000-2999)
  MEMBER_NOT_FOUND(HttpStatus.NOT_FOUND, "MEMBER-2000", "사용자를 찾을 수 없습니다."),
  NICKNAME_NOT_EXIST(HttpStatus.BAD_REQUEST, "MEMBER-2001", "닉네임은 필수입니다."),

  // Food Category Errors (3000-3999)
  FOOD_CATEGORY_NOT_FOUND(HttpStatus.NOT_FOUND, "FOOD-3000", "음식 카테고리를 찾을 수 없습니다."),

  // Article Errors (4000-4999)
  ARTICLE_NOT_FOUND(HttpStatus.NOT_FOUND, "ARTICLE-4000", "게시글을 찾을 수 없습니다."),

  // Store Errors (5000-5999)
  STORE_CREATE_FAIL(HttpStatus.INTERNAL_SERVER_ERROR, "STORE-5000", "가게 등록에 실패했습니다."),
  STORE_NOT_FOUND(HttpStatus.INTERNAL_SERVER_ERROR, "STORE-5001", "가게를 찾을 수 없습니다."),

  // Region Errors (6000-6999)
  REGION_NOT_FOUND(HttpStatus.NOT_FOUND, "REGION-6000", "해당 지역을 찾을 수 없습니다."),

  REVIEW_CREATE_FAIL(HttpStatus.INTERNAL_SERVER_ERROR, "REVIEW-7000", "리뷰 등록에 실패했습니다."),


  MISSION_CREATE_FAIL(HttpStatus.INTERNAL_SERVER_ERROR, "REVIEW-8000", "미션 등록에 실패했습니다."),
  DUPLICATE_MISSION(HttpStatus.INTERNAL_SERVER_ERROR, "MISSION-8001", "이미 등록된 미션입니다.");





  private final HttpStatus httpStatus;
  private final String code;
  private final String message;
}