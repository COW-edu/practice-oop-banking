package controller;

import common.Request;
import common.Response;
import exception.DeactivatedAccountException;
import exception.NotExistAccountException;

public interface BankingController {
  Response process(Request request) throws NotExistAccountException, DeactivatedAccountException;
}
