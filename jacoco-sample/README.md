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
## 메이븐 빌드

``` bash
  mvn clean verify
```

## 커버리지 만족 못할시 빌드 실패하도록 설정
``` xml
<execution>
    <id>jacoco-check</id>
         <goals>
            <goal>check</goal>
         </goals>
   <configuration>
                <rules>
                    <rule>
                        <element>PACKAGE</element>
                        <limits>
                            <limit>
                                <counter>LINE</counter>
                                <value>COVEREDRATIO</value>
                                <minimum>0.50</minimum>
                            </limit>
                        </limits>
                    </rule>
                </rules>
    </configuration>
</execution>

```

## 코드커버리지 툴(Jacoco)는 어떻게 test 안되것들을 알 수 있을까?
- 바이트 코드를 읽어서 바이트 코드에서 코드커버리지가 챙겨야 하는 부분을 갯수를 세고 코드 실행 할 때 몇개 실행했는지 카운팅 그래서 비교 (바이트코드 조작과 관련)

## 깨달은 점
- 기선님의 강의에서는 maven을 주로 쓰신다. 하지만 이것을 gradle로 바꿔보면 어떨까? 하는 생각이 들었다.
- gradle로 바꾸면 아래와 같다.

``` gradle
plugins {
    id 'java'
    id 'jacoco'
}

group 'me.sungbin'
version '1.0-SNAPSHOT'

repositories {
    mavenCentral()
}

dependencies {
    testImplementation 'org.junit.jupiter:junit-jupiter-api:5.8.0'
    testRuntimeOnly 'org.junit.jupiter:junit-jupiter-engine:5.8.0'
}

test {
    useJUnitPlatform()
}
```
