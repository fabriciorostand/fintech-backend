package br.com.fiap.fintech.dto;

public class LoginResponse {
    // Attributes
    private boolean success;
    private String message;
    private Integer userId;
    private String userName;

    // Getters
    public boolean isSuccess() {
        return success;
    }

    public String getMessage() {
        return message;
    }

    public Integer getUserId() {
        return userId;
    }

    public String getUserName() {
        return userName;
    }

    // Setters
    public void setSuccess(boolean success) {
        this.success = success;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    // Constructors
    public LoginResponse() {

    }

    public LoginResponse(boolean success, String message, Integer userId, String userName) {
        this.success = success;
        this.message = message;
        this.userId = userId;
        this.userName = userName;
    }
}
