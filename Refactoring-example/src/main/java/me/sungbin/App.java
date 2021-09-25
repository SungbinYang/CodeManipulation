package me.sungbin;

import java.lang.reflect.Modifier;
import java.util.Arrays;

/**
 * Hello world!
 *
 */
public class App {
    public static void main( String[] args ) throws ClassNotFoundException {
        Class<Book> bookClass = Book.class; // 클래스 타입의 인스턴스를 가져오는 1번째 방법

        Book book = new Book();
        Class<? extends Book> aClass = book.getClass(); // 클래스 타입의 인스턴스를 가져오는 2번째 방법

        Class<?> aClass1 = Class.forName("me.sungbin.Book"); // 클래스 타입의 인스턴스를 가져오는 3번째 방법

        // getFields()는 public한 변수들만 할당을한다.
        // getDeclaredFields()로 접근지시자 상관없이 가져온다.
        // 특정한 필드만 추출하고 싶으면 getDeclaredField("") 의 파라미터에 넣어주면 된다.
        Arrays.stream(bookClass.getDeclaredFields()).forEach(System.out::println);
        System.out.println();
        Arrays.stream(bookClass.getDeclaredFields()).forEach(f -> {
            try {
                f.setAccessible(true); // 접근이 불가능한 영역을 무조건 접근 가능하게 할려고 :: 접근지시자 무시
                System.out.printf("%s %s\n", f, f.get(book));
                int modifiers = f.getModifiers();
                System.out.println(Modifier.isPrivate(modifiers));
                System.out.println(Modifier.isStatic(modifiers));
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        });
        System.out.println();
        Arrays.stream(bookClass.getMethods()).forEach(System.out::println);
        System.out.println();
        Arrays.stream(bookClass.getDeclaredConstructors()).forEach(System.out::println);
        System.out.println();
        Class<? super MyBook> superclass = MyBook.class.getSuperclass();
        System.out.println(superclass);
        System.out.println();
        Arrays.stream(MyBook.class.getInterfaces()).forEach(System.out::println);
        System.out.println();
        Arrays.stream(MyBook.class.getAnnotations()).forEach(System.out::println);
        System.out.println();
        Arrays.stream(Book.class.getDeclaredFields()).forEach(f -> {
            Arrays.stream(f.getAnnotations()).forEach(a -> {
                if (a instanceof MyAnnotation) {
                    MyAnnotation myAnnotation = (MyAnnotation) a;
                    System.out.println(myAnnotation.value());
                    System.out.println(myAnnotation.number());
                }
            });
        });
    }
}
