package banking.dto;

import java.math.BigDecimal;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class DepositDTO {

  private String accountNumber;
  private BigDecimal depositAmount;

  @Builder
  public DepositDTO(String accountNumber, BigDecimal depositAmount) {
    this.accountNumber = accountNumber;
    this.depositAmount = depositAmount;
  }
}
