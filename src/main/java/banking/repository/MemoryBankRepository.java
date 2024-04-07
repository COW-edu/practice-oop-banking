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
    System.out.println(account.getAccountInfo());
    accountStorage.put(account.getAccountNumber(), account);
  }


  @Override
  public void depositAmount(DepositDTO depositDTO) {
    BasicAccount depositAccount = accountStorage.get(depositDTO.getAccountNumber());
    depositAccount.setBalance(depositAccount.getBalance().add(depositDTO.getDepositAmount()));
  }


  @Override
  public void withdrawAmount(WithdrawDTO withdrawDTO) {
    BasicAccount withdrawAccount = accountStorage.get(withdrawDTO.getAccountNumber());
    withdrawAccount.setBalance(
        withdrawAccount.getBalance().subtract(withdrawDTO.getWithdrawAmount()));
  }


  @Override
  public void transferAmount(TransferDTO transferDTO) {
    withdrawAmount(
        new WithdrawDTO(transferDTO.getWithdrawAccountNumber(), transferDTO.getTransferAmount()));
    depositAmount(
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
