package banking.constant;

import lombok.Getter;

@Getter
public enum MenuNumber {
  CREATE_ACCOUNT("1"),
  DEPOSIT("2"),
  WITHDRAW("3"),
  TRANSFER("4"),
  FIND_ACCOUNT("5"),
  EXIT("6");
  private final String menuNumber;

  MenuNumber(String menuNumber) {
    this.menuNumber = menuNumber;
  }

  public String getValue() {
    return menuNumber;
  }

  public static MenuNumber findByValue(String value) {
    for (MenuNumber menuNumber : values()) {
      if (menuNumber.getValue().equals(value)) {
        return menuNumber;
      }
    }
    throw new IllegalArgumentException("일치하는 MenuNumber 없습니다. value: " + value);
  }


}
