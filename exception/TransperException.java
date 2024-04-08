package exception;

import constant.ErrCode;

public class TransperException extends Exception {
    public TransperException(String reason){
        super(String.format("[%s] %s: %s", ErrCode.E103.getCode(), ErrCode.E103.getErrMsg(), reason));
    }
}
