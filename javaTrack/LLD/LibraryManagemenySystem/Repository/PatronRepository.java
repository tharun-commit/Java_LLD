package javaTrack.LibraryManagemenySystem.Repository;

import javaTrack.LibraryManagemenySystem.Patron.Patron;

public interface PatronRepository {

    void addPatron(Patron patron);
    void updatePatron(Patron patron);

    Patron findByPatronId(String patronId);
    void showPatronDetails();
}
