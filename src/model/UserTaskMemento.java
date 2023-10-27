package model;

public class UserTaskMemento {
    private String task;
    private String userAccount;
    private boolean isInsert; // Add a flag to differentiate insert and delete

    public UserTaskMemento(String task, String userAccount, boolean isInsert) {
        this.task = task;
        this.userAccount = userAccount;
        this.isInsert = isInsert;
    }

    public String getTask() {
        return task;
    }

    public String getUserAccount() {
        return userAccount;
    }

    public boolean isInsert() {
        return isInsert;
    }
}
