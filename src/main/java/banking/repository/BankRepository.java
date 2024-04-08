package banking.repository;

import banking.domain.BasicAccount;
import banking.dto.DepositDTO;
import banking.dto.TransferDTO;
import banking.dto.WithdrawDTO;
import java.math.BigDecimal;

public interface BankRepository {

  void createAccount(BasicAccount basicAccount);

  void depositAmountToAccount(DepositDTO depositDTO);

  void withdrawAmountToAccount(WithdrawDTO withdrawDTO);

  void transferAmountToAccount(TransferDTO transferDTO);

  BasicAccount findAccount(String accountNumber);

  BasicAccount findAndCalculateInterest(BasicAccount findAccount, BigDecimal interest);
}
