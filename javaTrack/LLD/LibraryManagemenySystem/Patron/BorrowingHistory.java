package javaTrack.LibraryManagemenySystem.Patron;

import javaTrack.LibraryManagemenySystem.Book.Book;

import java.time.LocalDate;

public class BorrowingHistory {

    private Book book;
    private LocalDate borrowDate;
    private LocalDate returnDate;

    public BorrowingHistory(Book book, LocalDate borrowDate) {
        this.book = book;
        this.borrowDate = borrowDate;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public LocalDate getBorrowDate() {
        return borrowDate;
    }

    public void setBorrowDate(LocalDate borrowDate) {
        this.borrowDate = borrowDate;
    }

    public LocalDate getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(LocalDate returnDate) {
        this.returnDate = returnDate;
    }
}
