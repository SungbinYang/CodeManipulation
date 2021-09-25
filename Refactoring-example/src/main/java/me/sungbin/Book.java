package me.sungbin;

@MyAnnotation("robert")
public class Book {

    private static String B = "BOOK";

    private static final String C = "BOOK";

    @MyAnnotation
    private String a = "a";

    public String d = "d";

    protected String e = "e";

    public Book() {
    }

    @AnotherAnnotation
    public Book(String a, String d, String e) {
        this.a = a;
        this.d = d;
        this.e = e;
    }

    @AnotherAnnotation
    private void f() {
        System.out.println("F");
    }

    public void g() {
        System.out.println("g");
    }

    public int h() {
        return 100;
    }
}
