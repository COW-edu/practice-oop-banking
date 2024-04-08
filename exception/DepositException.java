package exception;

import constant.ErrCode;

public class DepositException extends Exception {
    public DepositException(String reason){
        super(String.format("[%s] %s: %s", ErrCode.E000.getCode(), ErrCode.E000.getErrMsg(), reason));
    }
}
