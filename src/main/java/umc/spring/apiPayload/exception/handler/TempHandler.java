package umc.spring.apiPayload.exception.handler;


import umc.spring.apiPayload.code.BaseErrorCode;
import umc.spring.apiPayload.code.status.GeneralException;

public class TempHandler extends GeneralException {

    public TempHandler(BaseErrorCode errorCode) {
        super(errorCode);
    }
}