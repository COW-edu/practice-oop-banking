package banking.repository;

import banking.domain.BasicAccount;
import banking.dto.DepositDTO;
import banking.dto.TransferDTO;
import banking.dto.WithdrawDTO;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

public class MemoryBankRepository implements BankRepository {

  private final Map<String, BasicAccount> accountStorage = new HashMap<>();

  @Override
  public void createAccount(BasicAccount account) {
    accountStorage.put(account.getAccountNumber(), account);
  }


  @Override
  public void depositAmountToAccount(DepositDTO depositDTO) {
    BasicAccount depositToAccount = accountStorage.get(depositDTO.getAccountNumber());
    depositToAccount.setBalance(depositToAccount.getBalance().add(depositDTO.getDepositAmount()));
  }


  @Override
  public void withdrawAmountToAccount(WithdrawDTO withdrawDTO) {
    BasicAccount withdrawToAccount = accountStorage.get(withdrawDTO.getAccountNumber());
    withdrawToAccount.setBalance(
        withdrawToAccount.getBalance().subtract(withdrawDTO.getWithdrawAmount()));
  }


  @Override
  public void transferAmountToAccount(TransferDTO transferDTO) {
    withdrawAmountToAccount(
        new WithdrawDTO(transferDTO.getWithdrawAccountNumber(), transferDTO.getTransferAmount()));
    depositAmountToAccount(
        new DepositDTO(transferDTO.getDepositAccountNumber(), transferDTO.getTransferAmount()));
  }


  @Override
  public BasicAccount findAccount(String accountNumber) {
    return accountStorage.get(accountNumber);
  }


  @Override
  public BasicAccount findAndCalculateInterest(BasicAccount findAccount, BigDecimal interest) {
    findAccount.setBalance(findAccount.getBalance().add(interest));
    return findAccount;
  }


}
