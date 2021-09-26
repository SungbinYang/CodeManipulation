# 애노테이션 프로세서

## 롬복은 어떻게 동작할까?
- [Lombok](https://projectlombok.org/)
  * @Getter, @Setter, @Builder 등의 애노테이션과 애노테이션 프로세서를 제공하여 표준적으로 작성해야 할 코드를 개발자 대신 생성해주는 라이브러리.
- 롬복 사용하기
  * 의존성 추가
``` xml
<dependency>
    <groupId>org.projectlombok</groupId>
    <artifactId>lombok</artifactId>
    <version>1.18.8</version>
    <scope>provided</scope>
</dependency>
```
  * IntelliJ lombok 플러그인 설치
  * IntelliJ Annotation Processing 옵션 활성화
 
