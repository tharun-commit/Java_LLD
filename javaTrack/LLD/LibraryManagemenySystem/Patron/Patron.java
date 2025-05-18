package javaTrack.LibraryManagemenySystem.Patron;

import java.util.*;

public class Patron {

    private String patronId;
    private String patronName;
    private List<BorrowingHistory> borrowingHistory;

    public Patron(String patronId, String patronName) {
        this.patronId = patronId;
        this.patronName = patronName;
        this.borrowingHistory = new ArrayList<>();
    }

    public String getPatronId() {
        return patronId;
    }

    public void setPatronId(String patronId) {
        this.patronId = patronId;
    }

    public String getPatronName() {
        return patronName;
    }

    public void setPatronName(String patronName) {
        this.patronName = patronName;
    }

    public List<BorrowingHistory> getBorrowingHistory() {
        return borrowingHistory;
    }

    public void setBorrowingHistory(List<BorrowingHistory> borrowingHistory) {
        this.borrowingHistory = borrowingHistory;
    }
}
