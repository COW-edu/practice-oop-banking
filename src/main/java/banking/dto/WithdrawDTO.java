package banking.dto;

import java.math.BigDecimal;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class WithdrawDTO {

  private String accountNumber;
  private BigDecimal withdrawAmount;

  @Builder
  public WithdrawDTO(String accountNumber, BigDecimal withdrawAmount) {
    this.accountNumber = accountNumber;
    this.withdrawAmount = withdrawAmount;
  }
}