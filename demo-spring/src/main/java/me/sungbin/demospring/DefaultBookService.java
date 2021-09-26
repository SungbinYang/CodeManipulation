package me.sungbin.demospring;

public class DefaultBookService implements BookService {

    public void rent(Book book) {
        System.out.println("rent: " + book.getTitle());
    }
}
