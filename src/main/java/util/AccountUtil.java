package util;

import account.AccountType;
import common.Message;
import exception.IndexOutOfRangeException;

public class AccountUtil {
  public static AccountType intToAccountType(int index) throws IndexOutOfRangeException {
    if (index < AccountType.MIN_INDEX || index > AccountType.MAX_INDEX) {
      throw new IndexOutOfRangeException(Message.IndexOutOfRange, AccountType.MIN_INDEX, AccountType.MAX_INDEX, index);
    }
    for (AccountType accountType : AccountType.values()) {
      if (index == (accountType.ordinal() + AccountType.MIN_INDEX)) {
        return accountType;
      }
    }
    throw new IndexOutOfRangeException(Message.IndexOutOfRange, AccountType.MIN_INDEX, AccountType.MAX_INDEX, index);
  }
}
