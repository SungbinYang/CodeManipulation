package me.sungbin;

public class App {

    static String name;

    static {
        name = "sungbin";
    }

    Book book = new Book(); // 실제적인 레퍼런스를 가르키는 것이 아닌 논리적인 레퍼런스 (심볼릭 메모리 레퍼런스)를 가르키고 있다.

    public static void main(String[] args) {

        ClassLoader classLoader = App.class.getClassLoader();
        System.out.println(classLoader);
        System.out.println(classLoader.getParent());
        System.out.println(classLoader.getParent().getParent());
    }
}
