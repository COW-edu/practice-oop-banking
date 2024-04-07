package banking.service;

import banking.domain.BasicAccount;
import banking.dto.AccountDTO;
import banking.dto.DepositDTO;
import banking.dto.TransferDTO;
import banking.dto.WithdrawDTO;

public interface BankService {

  void createAccount(AccountDTO accountDTO);

  void deposit(DepositDTO depositDTO);

  void withdraw(WithdrawDTO withdrawDTO);

  void transfer(TransferDTO transferDTO);

  BasicAccount retrieveAndComputeInterest(String accountInput);

  //BasicAccount findAccount(String accountNumber);


}
