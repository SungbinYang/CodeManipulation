# 애노테이션 프로세서

## 롬복은 어떻게 동작할까?
- [Lombok](https://projectlombok.org/)
  * @Getter, @Setter, @Builder 등의 애노테이션과 애노테이션 프로세서를 제공하여 표준적으로 작성해야 할 코드를 개발자 대신 생성해주는 라이브러리.
- 롬복 사용하기
  * 의존성 추가
  * IntelliJ lombok 플러그인 설치
  * IntelliJ Annotation Processing 옵션 활성화

``` xml
<dependency>
    <groupId>org.projectlombok</groupId>
    <artifactId>lombok</artifactId>
    <version>1.18.8</version>
    <scope>provided</scope>
</dependency>
```
- 롬복 동작 원리
  * 컴파일 시점에 [애노테이션 프로세서](https://docs.oracle.com/javase/8/docs/api/javax/annotation/processing/Processor.html)를 사용하여 소스코드의 [AST(abstract syntax tree)](https://javaparser.org/inspecting-an-ast/)를 조작한다. 
- 논란 거리
  * 공개된 API가 아닌 컴파일러 내부 클래스를 사용하여 기존 소스 코드를 조작한다.
  * 특히 이클립스의 경우엔 java agent를 사용하여 컴파일러 클래스까지 조작하여 사용한다. 해당 클래스들 역시 공개된 API가 아니다보니 버전 호환성에 문제가 생길 수 있고 언제라도 그런 문제가 발생해도 이상하지 않다.
  * 그럼에도 불구하고 엄청난 편리함 때문에 널리 쓰이고 있으며 대안이 몇가지 있지만 롬복의 모든 기능과 편의성을 대체하진 못하는 현실이다.
    * AutoValue
      * https://github.com/google/auto/blob/master/value/userguide/index.md
    * Immutables
      * https://immutables.github.io
- 참고
  * https://docs.oracle.com/javase/8/docs/api/javax/annotation/processing/Processor.html
  * https://projectlombok.org/contributing/lombok-execution-path
  * https://stackoverflow.com/questions/36563807/can-i-add-a-method-to-a-class-from-a-compile-time-annotation
  * http://jnb.ociweb.com/jnb/jnbJan2010.html#controversy
  * https://www.oracle.com/technetwork/articles/grid/java-5-features-083037.html
 
