package javaTrack.LibraryManagemenySystem.SearchStrategy;

import javaTrack.LibraryManagemenySystem.Book.Book;
import javaTrack.LibraryManagemenySystem.Repository.ManageBookRepository;

import java.util.ArrayList;
import java.util.List;

public class FindBookByAuthor implements BookSearchStrategy {

    private String author;
    private ManageBookRepository bookRepo;

    public FindBookByAuthor(ManageBookRepository bookRepo) {
        this.bookRepo = bookRepo;
    }

    @Override
    public List<Book> findBook(String author){
        List<Book> booksList = new ArrayList<>();
        for(Book book : bookRepo.getBooks().values()){
            if(book.getAuthor().equalsIgnoreCase(author)){
                booksList.add(book);
            }
        }
        return booksList;
    }
}
