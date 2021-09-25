## 나만의 DI 프레임워크 만들기

- @Inject 라는 애노테이션 만들어서 필드 주입 해주는 컨테이너 서비스 만들기
  ``` java
  public class BookService {

      @Inject
      BookRepository bookRepository;

  }
  ```

- ContainerService.java
  ``` java
  public static <T> T getObject(T classType)
  ```
  * classType에 해당하는 타입의 객체를 만들어 준다.
  * 단, 해당 객체의 필드 중에 @Inject가 있다면 해당 필드도 같이 만들어 제공한다.
