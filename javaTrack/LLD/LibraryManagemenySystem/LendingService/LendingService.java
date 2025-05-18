package javaTrack.LibraryManagemenySystem.LendingService;

import javaTrack.LibraryManagemenySystem.Book.Book;
import javaTrack.LibraryManagemenySystem.Patron.BorrowingHistory;
import javaTrack.LibraryManagemenySystem.Patron.Patron;
import javaTrack.LibraryManagemenySystem.Repository.BookRepository;
import javaTrack.LibraryManagemenySystem.Repository.PatronRepository;
import javaTrack.LibraryManagemenySystem.SearchStrategy.BookSearchStrategy;

import java.time.LocalDate;
import java.util.*;
import java.util.logging.Logger;

public class LendingService {

    private BookRepository bookRepo;
    private PatronRepository patronRepo;
    private BookSearchStrategy bookSearchStrategy;
    private static final Logger logger = Logger.getLogger(LendingService.class.getName());


    public LendingService(BookRepository bookRepo, PatronRepository patronRepo, BookSearchStrategy bookSearchStrategy) {
        this.bookRepo = bookRepo;
        this.patronRepo = patronRepo;
        this.bookSearchStrategy = bookSearchStrategy;
    }


    public void bookCheckout(String ISBN, String patronId, LocalDate borrowDate){
        List<Book> books = bookSearchStrategy.findBook(ISBN);
        if (books.isEmpty()) {
            logger.warning("Checkout failed: Book with ISBN " + ISBN + " not found.");
            throw new RuntimeException("Book not found");
        }
        Book book = books.getFirst();
        Patron patron = patronRepo.findByPatronId(patronId);

        book.markAsUnavailable();
        patron.getBorrowingHistory().add(new BorrowingHistory(book, borrowDate));

        bookRepo.updateBook(book);
        patronRepo.updatePatron(patron);
        logger.info("Book checked out successfully: ISBN=" + ISBN + ", Patron ID=" + patronId);


    }

    public void bookReturn(String ISBN, String patronId, LocalDate returnDate){
        List<Book> books = bookSearchStrategy.findBook(ISBN);
        if (books.isEmpty()) {
            logger.warning("Return failed: Book with ISBN " + ISBN + " not found.");
            throw new RuntimeException("Book not found");
        }
        Book book = books.getFirst();
        Patron patron = patronRepo.findByPatronId(patronId);

        book.markAsAvailable();
        boolean updated = false;

        for(BorrowingHistory history : patron.getBorrowingHistory()){
            if(history.getBook().getISBN().equalsIgnoreCase(book.getISBN()) && history.getReturnDate() == null){
                history.setReturnDate(returnDate);
                updated = true;
                break;
            }
        }

        if (!updated) {
            logger.warning("Return record not found for ISBN=" + ISBN + " and Patron ID=" + patronId);
        } else {
            logger.info("Book returned successfully: ISBN=" + ISBN + ", Patron ID=" + patronId);
        }

        bookRepo.updateBook(book);
        patronRepo.updatePatron(patron);

    }




}
