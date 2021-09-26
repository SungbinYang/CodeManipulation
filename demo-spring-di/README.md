# 다이나믹 프록시

## 스프링 Dependency Injection은 어떻게 동작할까?
- BookService.java
  ``` java
  @Service
  public class BookService {

      @Autowired
      BookRepository bookRepository;

  }
  ```
- bookRepository 인스턴스는 어떻게 null이 아닌걸까?
- 스프링은 어떻게 BookService 인스턴스에 BookRepository 인스턴스를 넣어준 것일까?

## 프록시 패턴

![스크린샷 2021-09-26 오전 11 57 16](https://user-images.githubusercontent.com/18282470/134791736-f488b5a7-07ce-4f0d-beca-2af6c8ff7628.png)

- 프록시와 리얼 서브젝트가 공유하는 인터페이스가 있고, 클라이언트는 해당 인터페이스 타입으로 프록시를 사용한다.
- 클라이언트는 프록시를 거쳐서 리얼 서브젝트를 사용하기 때문에 프록시는 리얼 서브젝트에 대한 접근을 관리거나 부가기능을 제공하거나, 리턴값을 변경할 수도 있다.
- 리얼 서브젠트는 자신이 해야 할 일만 하면서(SRP) 프록시를 사용해서 부가적인 기능(접근 제한, 로깅, 트랜잭션, 등)을 제공할 때 이런 패턴을 주로 사용한다.

- 참고
  * https://www.oodesign.com/proxy-pattern.html
  * https://en.wikipedia.org/wiki/Proxy_pattern
  * https://en.wikipedia.org/wiki/Single_responsibility_principle
