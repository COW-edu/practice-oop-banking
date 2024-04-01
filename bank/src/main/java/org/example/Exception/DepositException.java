package org.example.Exception;

import org.example.Constant.ErrorCode;


public class DepositException extends Exception{
    public DepositException(String reason) {
        super(String.format("[%s] %s: %s", ErrorCode.E102.getCode(), ErrorCode.E102.getErrMsg(), reason));
    }
}