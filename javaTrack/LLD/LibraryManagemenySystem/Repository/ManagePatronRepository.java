package javaTrack.LibraryManagemenySystem.Repository;

import javaTrack.LibraryManagemenySystem.Patron.BorrowingHistory;
import javaTrack.LibraryManagemenySystem.Patron.Patron;

import java.util.HashMap;
import java.util.Map;

public class ManagePatronRepository implements PatronRepository {

    private Map<String, Patron> patrons = new HashMap<>();

    public void addPatron(Patron patron){
        patrons.put(patron.getPatronId(), patron);
    }

    public void updatePatron(Patron patron){
        patrons.replace(patron.getPatronId(), patron);
    }

    public Patron findByPatronId(String patronId){
        return patrons.get(patronId);
    }

    public void showPatronDetails(){
        for(Patron patron : patrons.values()){
            System.out.print("patron -> "+patron.getPatronId()+" "+ patron.getPatronName());
            for(BorrowingHistory borrowHistory : patron.getBorrowingHistory()){
                System.out.println(" "+borrowHistory.getBook().getTitle()+" "+ borrowHistory.getBorrowDate() +" "+ borrowHistory.getReturnDate());
            }
        }
    }
}
