package org.example.exception;

import org.example.constant.ErrorCode;

public class MenuInputException extends Exception{
    public MenuInputException(String reason) {
        super(String.format("[%s] %s: %s", ErrorCode.E201.getCode(), ErrorCode.E201.getErrMsg(), reason));
    }
}