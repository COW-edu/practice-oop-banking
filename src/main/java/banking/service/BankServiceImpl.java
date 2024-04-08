package banking.service;

import static banking.constant.ErrorMessage.IS_EXISTED_NUMBER;

import banking.constant.AccountType;
import banking.domain.BasicAccount;
import banking.dto.AccountDTO;
import banking.dto.DepositDTO;
import banking.dto.TransferDTO;
import banking.dto.WithdrawDTO;
import banking.interestpolicy.InterestCalculator;
import banking.repository.BankRepository;
import banking.service.validation.AccountValidationService;
import java.math.BigDecimal;
import java.util.Map;
import java.util.Optional;

public class BankServiceImpl implements BankService {

  private final BankRepository bankRepository;
  private final Map<AccountType, InterestCalculator> interestPolicy;
  private final AccountValidationService validationService;

  public BankServiceImpl(BankRepository bankRepository,
      Map<AccountType, InterestCalculator> interestPolicy,
      AccountValidationService validationService) {
    this.bankRepository = bankRepository;
    this.interestPolicy = interestPolicy;
    this.validationService = validationService;
  }


  @Override
  public void createAccount(AccountDTO accountDTO) {
    if (validationService.isTargetAmountNull(accountDTO)) {
      bankRepository.createAccount(accountDTO.createBasicAccount());
      return;
    }
    bankRepository.createAccount(accountDTO.createSavingAccount());
  }


  @Override
  public void depositAmountToAccount(DepositDTO depositDTO) {
    if (isExistedAccount(depositDTO.getAccountNumber())) {
      bankRepository.depositAmountToAccount(depositDTO);
    }
  }


  @Override
  public void withdrawAmountToAccount(WithdrawDTO withdrawDTO) {
    BasicAccount withdrawAccount = bankRepository.findAccount(withdrawDTO.getAccountNumber());
    boolean validatedGoalAmount = validationService.validateAndCheckWithdraw(withdrawAccount);

    if (validatedGoalAmount || isExistedAccount(withdrawDTO.getAccountNumber())) {
      bankRepository.withdrawAmountToAccount(withdrawDTO);
    }
  }


  @Override
  public void transferAmountToAccount(TransferDTO transferDTO) {
    isExistedAccount(transferDTO.getDepositAccountNumber());
    isExistedAccount(transferDTO.getWithdrawAccountNumber());

    bankRepository.transferAmountToAccount(transferDTO);
  }


  @Override
  public BasicAccount retrieveAndComputeInterest(String accountNumber) {
    BasicAccount findAccount = bankRepository.findAccount(accountNumber);
    BigDecimal interest = calculateInterest(findAccount, interestPolicy);
    return bankRepository.findAndCalculateInterest(findAccount, interest);
  }


  private boolean isExistedAccount(String accountNumber) {
    return Optional.ofNullable(bankRepository.findAccount(accountNumber))
        .orElseThrow(() -> new RuntimeException(IS_EXISTED_NUMBER.getErrorMessage())).isActivated();
  }


  private BigDecimal calculateInterest(BasicAccount findAccount,
      Map<AccountType, InterestCalculator> interestPolicy) {
    InterestCalculator interestCalculator = interestPolicy.get(findAccount.getAccountType());
    return interestCalculator.getInterest(findAccount.getBalance());
  }
}
