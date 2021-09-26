## 애노태이션 프로세서 실습
- [Processor 인터페이스](https://docs.oracle.com/en/java/javase/11/docs/api/java.compiler/javax/annotation/processing/Processor.html)
  * 여러 라운드(rounds)에 거쳐 소스 및 컴파일 된 코드를 처리 할 수 있다.
- 유틸리티
  * AutoService: 서비스 프로바이더 레지스트리 생성기
  ``` xml
  <dependency>
    <groupId>com.google.auto.service</groupId>
    <artifactId>auto-service</artifactId>
    <version>1.0-rc6</version>
  </dependency>
  ```
  ``` java
  @AutoService(Processor.class)
  public class MagicMojaProcessor extends AbstractProcessor {
    ...
  }
  ```
  * 컴파일 시점에 애노테이션 프로세서를 사용하여 META-INF/services/javax.annotation.processor.Processor 파일 자동으로 생성해 줌.
- ServiceProvider
  * https://itnext.io/java-service-provider-interface-understanding-it-via-code-30e1dd45a091
- 참고
  * http://hannesdorfmann.com/annotation-processing/annotationprocessing101
  * http://notatube.blogspot.com/2010/12/project-lombok-creating-custom.html
  * https://medium.com/@jintin/annotation-processing-in-java-3621cb05343a
  * https://medium.com/@iammert/annotation-processing-dont-repeat-yourself-generate-your-code-8425e60c6657
  * https://docs.oracle.com/javase/7/docs/technotes/tools/windows/javac.html#processing
