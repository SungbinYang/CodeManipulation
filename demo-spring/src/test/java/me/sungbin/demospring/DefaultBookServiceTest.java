package me.sungbin.demospring;

import org.junit.jupiter.api.Test;

class DefaultBookServiceTest {

    BookService bookService = new BookServiceProxy(new DefaultBookService());

    @Test
    void di() {
        Book book = new Book();
        book.setTitle("spring");
        bookService.rent(book);
    }

}