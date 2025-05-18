package javaTrack.LibraryManagemenySystem;

import javaTrack.LibraryManagemenySystem.Book.Book;
import javaTrack.LibraryManagemenySystem.LendingService.LendingService;
import javaTrack.LibraryManagemenySystem.Patron.Patron;
import javaTrack.LibraryManagemenySystem.Repository.ManageBookRepository;
import javaTrack.LibraryManagemenySystem.Repository.ManagePatronRepository;
import javaTrack.LibraryManagemenySystem.SearchStrategy.FindBookByISBN;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {

        Book javaBook = new Book("JAVA Book", "J_Author", "J1", "2001");
        Book nodeBook = new Book("NODE Book", "J_Author", "N1", "2002");
        Book cppBook = new Book("C++ Book", "J_Author", "CPP1", "2003");
        Book systemDesignBook = new Book("SYSTEM DESIGN Book", "J_Author", "SD1", "2004");
        Book dsaBook = new Book("DSA Book", "J_Author", "DSA1", "2005");

        Patron patron1 = new Patron("P1", "patron1");
        Patron patron2 = new Patron("P2", "patron2");
        Patron patron3 = new Patron("P3", "patron3");

        ManageBookRepository manageBookRepository = new ManageBookRepository();
        ManagePatronRepository managePatronRepository = new ManagePatronRepository();

        // adding books
        manageBookRepository.addBook(javaBook);
        manageBookRepository.addBook(nodeBook);
        manageBookRepository.addBook(cppBook);
        manageBookRepository.addBook(systemDesignBook);
        manageBookRepository.addBook(dsaBook);

        // adding patrons
        managePatronRepository.addPatron(patron1);
        managePatronRepository.addPatron(patron2);
        managePatronRepository.addPatron(patron3);

        FindBookByISBN searchBook = new FindBookByISBN(manageBookRepository);

        LendingService lendingService = new LendingService(manageBookRepository, managePatronRepository, searchBook);

        lendingService.bookCheckout("CPP1", "P1", LocalDate.now());
        lendingService.bookCheckout("SD1", "P2", LocalDate.now());
        lendingService.bookCheckout("J1", "P3", LocalDate.now());

        manageBookRepository.showAvailableBooks();
        System.out.println();
        manageBookRepository.showBorrowedBooks();

        lendingService.bookReturn("J1", "P3", LocalDate.now());

        System.out.println();
        managePatronRepository.showPatronDetails();

        System.out.println();
        manageBookRepository.showAvailableBooks();



    }
}
