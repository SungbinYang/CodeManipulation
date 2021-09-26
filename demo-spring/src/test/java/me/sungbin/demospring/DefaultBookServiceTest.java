package me.sungbin.demospring;

import net.bytebuddy.ByteBuddy;
import net.bytebuddy.implementation.InvocationHandlerAdapter;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;
import org.junit.jupiter.api.Test;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import static net.bytebuddy.matcher.ElementMatchers.named;

class DefaultBookServiceTest {

    @Test
    void di() throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
//        MethodInterceptor handler = new MethodInterceptor() {
//
//            DefaultBookService bookService = new DefaultBookService();
//
//            @Override
//            public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
//                if (method.getName().equals("rent")) {
//                    System.out.println("aaaa");
//                    Object invoke = method.invoke(bookService, objects);
//                    System.out.println("bbbb");
//                    return invoke;
//                }
//
//                return method.invoke(bookService, objects);
//            }
//        };
//        DefaultBookService bookService = (DefaultBookService) Enhancer.create(DefaultBookService.class, handler);

        Class<? extends DefaultBookService> proxyClass = new ByteBuddy().subclass(DefaultBookService.class)
                .method(named("rent")).intercept(InvocationHandlerAdapter.of(new InvocationHandler() {

                    DefaultBookService bookService = new DefaultBookService();

                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        System.out.println("aaaa");
                        Object invoke = method.invoke(bookService, args);
                        System.out.println("bbbb");
                        return invoke;
                    }
                }))
                .make().load(DefaultBookService.class.getClassLoader()).getLoaded();

        DefaultBookService bookService = proxyClass.getConstructor(null).newInstance();

        Book book = new Book();
        book.setTitle("spring");
        bookService.rent(book);
        bookService.returnBook(book);
    }

}