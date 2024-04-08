package banking.dto;

import java.math.BigDecimal;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class TransferDTO {

  private String depositAccountNumber;
  private String withdrawAccountNumber;
  private BigDecimal transferAmount;

  @Builder
  public TransferDTO(String depositAccountNumber, String withdrawAccountNumber,
      BigDecimal transferAmount) {
    this.depositAccountNumber = depositAccountNumber;
    this.withdrawAccountNumber = withdrawAccountNumber;
    this.transferAmount = transferAmount;
  }
}
