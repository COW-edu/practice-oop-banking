package org.example.user;

public class User {
    private String id;
    private String pw;

    public User(String id, String pw) {
        this.id = id;
        this.pw = pw;
    }

    public boolean SuccessLogin(String id, String pw) {
        boolean ok = false; //2번
        if (this.id.equals(id) && this.pw.equals(pw)) {
            ok = true;
        }
        return ok;
    }
}
