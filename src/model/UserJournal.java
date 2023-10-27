package model;

public class UserJournal {
    private String journalText;

    public UserJournal() {
        // Public no-argument constructor
    }

    public UserJournal(String journalText) {
        this.journalText = journalText;
    }

    public String getJournalText() {
        return journalText;
    }

    public void setJournalText(String journalText) {
        this.journalText = journalText;
    }
}