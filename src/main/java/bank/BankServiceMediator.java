package bank;

import bank.clerk.*;
import lombok.RequiredArgsConstructor;

import java.util.HashMap;
import java.util.Map;

@RequiredArgsConstructor
public class BankServiceMediator{
    private Map<Integer, Clerk> clerks;
    private final CreateAccountClerk createAccountClerk;
    private final DepositClerk depositClerk;
    private final WithdrawClerk withdrawClerk;
    private final RemittanceClerk remittanceClerk;
    private final ChangeStatusClerk changeStatusClerk;
    private final GetAccountInfoClerk getAccountInfoClerk;


    public void InitAction() {
        clerks = new HashMap<>();
        clerks.put(1, createAccountClerk);
        clerks.put(2, depositClerk);
        clerks.put(3, withdrawClerk);
        clerks.put(4, remittanceClerk);
        clerks.put(5, changeStatusClerk);
        clerks.put(6, getAccountInfoClerk);
    }

    public void executeAction(int action) {
        InitAction();
        Clerk clerk = clerks.get(action);
        clerk.action();
    }
}