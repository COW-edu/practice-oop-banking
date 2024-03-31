package bank;

import bank.clerk.*;

import java.util.HashMap;
import java.util.Map;

public class BankServiceMediator{
    private Map<Integer, Clerk> clerks;
    private final CreateAccountClerk createAccountClerk;
    private final DepositClerk depositClerk;
    private final WithdrawClerk withdrawClerk;
    private final RemittanceClerk remittanceClerk;
    private final ChangeStatusClerk changeStatusClerk;


    public BankServiceMediator(CreateAccountClerk createAccountClerk, DepositClerk depositClerk, WithdrawClerk withdrawClerk, RemittanceClerk remittanceClerk, ChangeStatusClerk changeStatusClerk) {
        this.createAccountClerk = createAccountClerk;
        this.depositClerk = depositClerk;
        this.withdrawClerk = withdrawClerk;
        this.remittanceClerk = remittanceClerk;
        this.changeStatusClerk = changeStatusClerk;
        InitAction();

    }
    public void InitAction() {
        clerks = new HashMap<>();
        clerks.put(1, createAccountClerk);
        clerks.put(2, depositClerk);
        clerks.put(3, withdrawClerk);
        clerks.put(4, remittanceClerk);
        clerks.put(5, changeStatusClerk);
    }

    public void action() {
        throw new UnsupportedOperationException("지원하지 않는 기능입니다.");
    }

    public void executeAction(int action) {
        Clerk clerk = clerks.get(action);
        if (clerk != null) {
            clerk.action();
        } else {
            throw new InvalidInputException("잘못된 입력입니다.");
        }
    }
    private static class InvalidInputException extends RuntimeException {
        public InvalidInputException(String message) {
            super(message);
        }
    }
}