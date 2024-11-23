//package umc.spring.apiPayload.code.status;
//
//import lombok.AllArgsConstructor;
//import lombok.Getter;
//import lombok.NoArgsConstructor;
//import lombok.RequiredArgsConstructor;
//import umc.spring.apiPayload.code.BaseErrorCode;
//import umc.spring.apiPayload.code.ErrorReasonDTO;
//
//@Getter
//@RequiredArgsConstructor
//public class GeneralException extends RuntimeException {
//
//    private  BaseErrorCode code;
//
//    public GeneralException(BaseErrorCode code) {
//        super(code.getReason().getMessage());
//        this.code = code;
//    }
//
//    public ErrorReasonDTO getErrorReason() {
//        return this.code.getReason();
//    }
//
//    public ErrorReasonDTO getErrorReasonHttpStatus() {
//        return this.code.getReasonHttpStatus();
//    }
//}