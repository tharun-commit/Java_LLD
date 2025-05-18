package javaTrack.LibraryManagemenySystem.Repository;

import javaTrack.LibraryManagemenySystem.Book.Book;

import java.util.HashMap;
import java.util.Map;

public class ManageBookRepository implements BookRepository {
    private Map<String, Book> books = new HashMap<>();

    public void addBook(Book book){
        books.put(book.getISBN(), book);
    }

    public void removeBook(Book book){
        books.remove(book.getISBN());
    }

    public void updateBook(Book book){
        books.replace(book.getISBN(), book);
    }

    public void showAvailableBooks(){
        for(Book book : books.values()){
            if(book.isAvailable()){
                System.out.println("book -> "+book.getTitle()+" "+ book.getAuthor()+" "+book.getISBN()+" --> "+book.isAvailable());
            }
        }
    }

    public void showBorrowedBooks(){
        for(Book book : books.values()){
            if(!book.isAvailable()){
                System.out.println("book -> "+book.getTitle()+" "+ book.getAuthor()+" "+book.getISBN()+" --> "+book.isAvailable());
            }
        }
    }

    public Map<String, Book> getBooks() {
        return books;
    }

    public void setBooks(Map<String, Book> books) {
        this.books = books;
    }
}
