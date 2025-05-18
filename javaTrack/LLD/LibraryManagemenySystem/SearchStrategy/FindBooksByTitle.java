package javaTrack.LibraryManagemenySystem.SearchStrategy;

import javaTrack.LibraryManagemenySystem.Book.Book;
import javaTrack.LibraryManagemenySystem.Repository.ManageBookRepository;

import java.util.ArrayList;
import java.util.List;

public class FindBooksByTitle implements BookSearchStrategy {

    private String title;
    private ManageBookRepository bookRepo;

    public FindBooksByTitle(ManageBookRepository bookRepo) {
        this.bookRepo = bookRepo;
    }

    @Override
    public List<Book> findBook(String title) {
        List<Book> booksList = new ArrayList<>();
        for(Book book : bookRepo.getBooks().values()){
            if(book.getTitle().equalsIgnoreCase(title) ){
                booksList.add(book);
            }
        }
        return booksList;
    }
}
