package me.sungbin.demospring;

import org.junit.jupiter.api.Test;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

class DefaultBookServiceTest {

    BookService bookService = (BookService) Proxy.newProxyInstance(BookService.class.getClassLoader(), new Class[]{BookService.class}, new InvocationHandler() {

        BookService bookService = new DefaultBookService();

        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            if (method.getName().equals("rent")) {
                System.out.println("aaaaa");
                Object invoke = method.invoke(bookService, args);
                System.out.println("bbbb");
                return invoke;
            }
            return method.invoke(bookService, args);
        }
    });

    @Test
    void di() {
        Book book = new Book();
        book.setTitle("spring");
        bookService.rent(book);
        bookService.returnBook(book);
    }

}