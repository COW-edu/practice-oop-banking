package banking.constant;

import lombok.Getter;

@Getter
public enum AccountType {
  
  BASIC(1), SAVING(2);

  private final int typeNum;

  AccountType(int typeNum) {
    this.typeNum = typeNum;
  }
}
