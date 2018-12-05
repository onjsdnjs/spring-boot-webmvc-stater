package io.anymobi.springbootwebmvcstater.mvc;

public class AppError {

    private String message;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "AppError{" +
                "message='" + message + '\'' +
                '}';
    }
}
