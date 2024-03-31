package Exception;


import Constant.ErrorCode;

public class WithdrawException extends Exception{
    public WithdrawException(String reason) {
        super(String.format("(%s) %s: %s", ErrorCode.E101.getCode(), ErrorCode.E101.getErrMsg(), reason));
    }
}