package bank;

import bank.clerk.*;
import lombok.RequiredArgsConstructor;

import java.util.HashMap;
import java.util.Map;

@RequiredArgsConstructor
public class BankServiceMediator {

    private static final int CREATE_ACCOUNT = 1;
    private static final int DEPOSIT = 2;
    private static final int WITHDRAW = 3;
    private static final int REMITTANCE = 4;
    private static final int CHANGE_STATUS = 5;
    private static final int GET_ACCOUNT_INFO = 6;

    private final Map<Integer, Clerk> clerks = new HashMap<>();
    private final CreateAccountClerk createAccountClerk;
    private final DepositClerk depositClerk;
    private final WithdrawClerk withdrawClerk;
    private final RemittanceClerk remittanceClerk;
    private final ChangeStatusClerk changeStatusClerk;
    private final GetAccountInfoClerk getAccountInfoClerk;


    private void InitAction() {

        clerks.put(CREATE_ACCOUNT, createAccountClerk);
        clerks.put(DEPOSIT, depositClerk);
        clerks.put(WITHDRAW, withdrawClerk);
        clerks.put(REMITTANCE, remittanceClerk);
        clerks.put(CHANGE_STATUS, changeStatusClerk);
        clerks.put(GET_ACCOUNT_INFO, getAccountInfoClerk);
    }

    public void executeAction(int action) {
        InitAction();
        Clerk clerk = clerks.get(action);
        clerk.action();
    }
}