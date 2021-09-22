package me.sungbin;

public class App {

    static String myName;

    static {
        myName = "sungbin";
    }

    private String foo = "bar";

    public static void main(String[] args) {
        Thread.currentThread();
        System.out.println(App.class.getSuperclass());
    }
}
