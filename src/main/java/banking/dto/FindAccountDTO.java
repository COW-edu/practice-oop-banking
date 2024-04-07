package banking.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class FindAccountDTO {

  private String accountNumber;

  @Builder
  public FindAccountDTO(String accountNumber) {
    this.accountNumber = accountNumber;
  }
}
