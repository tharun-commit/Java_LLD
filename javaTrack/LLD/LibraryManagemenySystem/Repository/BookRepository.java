package javaTrack.LibraryManagemenySystem.Repository;

import javaTrack.LibraryManagemenySystem.Book.Book;

import java.util.Map;

public interface BookRepository {

    void addBook(Book book);
    void removeBook(Book book);
    void updateBook(Book book);

    void showAvailableBooks();
    void showBorrowedBooks();

    Map<String, Book> getBooks();
}
