package banking.repository;

import banking.domain.BasicAccount;
import banking.dto.DepositDTO;
import banking.dto.TransferDTO;
import banking.dto.WithdrawDTO;
import java.math.BigDecimal;

public interface BankRepository {

  void createAccount(BasicAccount basicAccount);

  void depositAmount(DepositDTO depositDTO);

  void withdrawAmount(WithdrawDTO withdrawDTO);

  void transferAmount(TransferDTO transferDTO);

  BasicAccount findAccount(String accountNumber);

  BasicAccount findAndCalculateInterest(BasicAccount findAccount, BigDecimal interest);
}
