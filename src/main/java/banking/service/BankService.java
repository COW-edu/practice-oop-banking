package banking.service;

import banking.domain.BasicAccount;
import banking.dto.AccountDTO;
import banking.dto.DepositDTO;
import banking.dto.TransferDTO;
import banking.dto.WithdrawDTO;

public interface BankService {

  void createAccount(AccountDTO accountDTO);

  void depositAmountToAccount(DepositDTO depositDTO);

  void withdrawAmountToAccount(WithdrawDTO withdrawDTO);

  void transferAmountToAccount(TransferDTO transferDTO);

  BasicAccount retrieveAndComputeInterest(String accountInput);
}
