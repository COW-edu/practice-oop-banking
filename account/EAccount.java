package account;

public enum EAccount{
    N("예금계좌"),
    S("적금계좌");

    final String information;

    EAccount(String information) {
        this.information = information;
    }
}