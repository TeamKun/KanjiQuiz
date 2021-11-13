package net.kunmc.lab.kanjiquiz.command;

public class CommandFeedback {
    private boolean isSuccess;
    private String message;

    public CommandFeedback(boolean isSuccess, String message) {
        this.isSuccess = isSuccess;
        this.message = message;
    }

    public boolean isSuccess() {
        return isSuccess;
    }

    public String message() {
        return message;
    }
}
