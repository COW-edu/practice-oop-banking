package Exception;



import Constant.ErrorCode;


public class TransferException extends Exception{
    public TransferException(String reason) {
        super(String.format("[%s] %s: %s", ErrorCode.E103.getCode(), ErrorCode.E103.getErrMsg(), reason));
    }
}