package javaTrack.LibraryManagemenySystem.SearchStrategy;

import javaTrack.LibraryManagemenySystem.Book.Book;

import java.util.List;

public interface BookSearchStrategy {

    List<Book> findBook(String searchKey);
}
