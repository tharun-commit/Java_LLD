package javaTrack.LibraryManagemenySystem.SearchStrategy;

import javaTrack.LibraryManagemenySystem.Book.Book;
import javaTrack.LibraryManagemenySystem.Repository.BookRepository;

import java.util.ArrayList;
import java.util.List;

public class FindBookByISBN implements BookSearchStrategy {

    private String ISBN;
    private BookRepository bookRepo;

    public FindBookByISBN(BookRepository bookRepo) {
        this.bookRepo = bookRepo;
    }

    @Override
    public List<Book> findBook(String ISBN) {
        List<Book> booksList = new ArrayList<>();
        for(Book book : bookRepo.getBooks().values()){
            if(book.getISBN().equalsIgnoreCase(ISBN) ){
                booksList.add(book);
            }
        }
        return booksList;
    }
}
