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
