# 코드 커버리지는 어떻게 측정할까?

## 코드 커버리지? 테스트 코드가 확인한 소스 코드를 %
- JaCoCo를 써보자.
- https://www.eclemma.org/jacoco/trunk/doc/index.html
- http://www.semdesigns.com/Company/Publications/TestCoverage.pdf

## pom.xml에 플러그인 추가

``` xml
  <plugin>
    <groupId>org.jacoco</groupId>
    <artifactId>jacoco-maven-plugin</artifactId>
    <version>0.8.4</version>
    <executions>
        <execution>
            <goals>
                <goal>prepare-agent</goal>
            </goals>
        </execution>
        <execution>
            <id>report</id>
            <phase>prepare-package</phase>
            <goals>
                <goal>report</goal>
            </goals>
        </execution>
    </executions>
</plugin>
```
