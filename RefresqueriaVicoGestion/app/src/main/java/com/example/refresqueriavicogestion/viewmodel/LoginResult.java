package com.example.refresqueriavicogestion.viewmodel;

public class LoginResult {
    private LoggedInUserView success;
    private Integer error;

    public LoginResult(Integer error) {
        this.error = error;
        this.success = null;
    }

    public LoginResult(LoggedInUserView success) {
        this.success = success;
        this.error = null;
    }

    public LoggedInUserView getSuccess() {
        return success;
    }

    public Integer getError() {
        return error;
    }
}
