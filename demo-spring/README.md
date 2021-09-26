# 다이나믹 프록시

## 스프링 데이터 JPA는 어떻게 동작할까?
- 스프링 데이터 JPA에서 인터페이스 타입의 인스턴스는 누가 만들어 주는것인가?
  * Spring AOP를 기반으로 동작하며 RepositoryFactorySupport에서 프록시를 생성한다.

## 프록시 패턴

![스크린샷 2021-09-26 오전 11 57 16](https://user-images.githubusercontent.com/18282470/134791736-f488b5a7-07ce-4f0d-beca-2af6c8ff7628.png)

- 프록시와 리얼 서브젝트가 공유하는 인터페이스가 있고, 클라이언트는 해당 인터페이스 타입으로 프록시를 사용한다.
- 클라이언트는 프록시를 거쳐서 리얼 서브젝트를 사용하기 때문에 프록시는 리얼 서브젝트에 대한 접근을 관리거나 부가기능을 제공하거나, 리턴값을 변경할 수도 있다.
- 리얼 서브젠트는 자신이 해야 할 일만 하면서(SRP) 프록시를 사용해서 부가적인 기능(접근 제한, 로깅, 트랜잭션, 등)을 제공할 때 이런 패턴을 주로 사용한다.

- 참고
  * https://www.oodesign.com/proxy-pattern.html
  * https://en.wikipedia.org/wiki/Proxy_pattern
  * https://en.wikipedia.org/wiki/Single_responsibility_principle

## 다이나믹 프록시 실습
- 런타임에 특정 인터페이스들을 구현하는 클래스 또는 인스턴스를 만드는 기술
 > “an application can use a dynamic proxy class to create an object that implements multiple arbitrary event listener interfaces”
  * https://docs.oracle.com/javase/8/docs/technotes/guides/reflection/proxy.html
- 프록시 인스턴스 만들기
  * Object Proxy.newProxyInstance(ClassLoader, Interfaces, InvocationHandler)
    ``` java
    BookService bookService = (BookService) Proxy.newProxyInstance(BookService.class.getClassLoader(), new Class[]{BookService.class},
        new InvocationHandler() {
            BookService bookService = new DefaultBookService();
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                if (method.getName().equals("rent")) {
                    System.out.println("aaaa");
                    Object invoke = method.invoke(bookService, args);
                    System.out.println("bbbb");
                    return invoke;
                }

                return method.invoke(bookService, args);
            }
        });
    ```
  * 유연한 구조가 아니다. 그래서 스프링 AOP 등장!
  * 스프링 AOP에 대한 더 자세한 토비의 스프링 3.1, 6장 AOP를 참고하세요.
- 참고
  * https://docs.oracle.com/javase/8/docs/technotes/guides/reflection/proxy.html
  * https://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Proxy.html#newProxyInstance-java.lang.ClassLoader-java.lang.Class:A-java.lang.reflect.InvocationHandler-
