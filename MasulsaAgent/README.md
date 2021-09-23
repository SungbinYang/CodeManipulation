# Javaagent 실습

## Javaagent JAR 파일 만들기
- https://docs.oracle.com/javase/8/docs/api/java/lang/instrument/package-summary.html
- 붙이는 방식은 시작시 붙이는 방식 premain과 런타임 중에 동적으로 붙이는 방식 agentmain이 있다.
- Instrumentation을 사용한다.

## Javaagent 붙여서 사용하기
- 클래스로더가 클래스를 읽어올 때 javaagent를 거쳐서 변경된 바이트코드를 읽어들여 사용한다.
- MasulsaJavaAgent.java
``` java
public class MasulsaAgent {

    public static void premain(String agentArgs, Instrumentation inst) {
        new AgentBuilder.Default()
                .type(ElementMatchers.any())
                .transform((builder, typeDescription, classLoader, javaModule) -> builder.method(named("pullOut")).intercept(FixedValue.value("Rabbit!"))).installOn(inst);
    }

}
```

- pom.xml
``` xml
<dependencies>
    <dependency>
      <groupId>net.bytebuddy</groupId>
      <artifactId>byte-buddy</artifactId>
      <version>1.10.1</version>
    </dependency>
  </dependencies>

  <build>
    <plugins>
      <plugin>
        <groupId>org.apache.maven.plugins</groupId>
        <artifactId>maven-jar-plugin</artifactId>
        <version>3.1.2</version>
        <configuration>
          <archive>
            <index>true</index>
            <manifest>
              <addClasspath>true</addClasspath>
            </manifest>
            <manifestEntries>
              <mode>development</mode>
              <url>${project.url}</url>
              <key>value</key>
              <Premain-Class>me.whiteship.MasulsaAgent</Premain-Class>
              <Can-Redefine-Classes>true</Can-Redefine-Classes>
              <Can-Retransform-Classes>true</Can-Retransform-Classes>
            </manifestEntries>
          </archive>
        </configuration>
      </plugin>
    </plugins>
  </build>
```

- Javaagent 적용
``` bash
-javaagent:/Users/sungbin/workspace/MasulsaJavaAgent/target/MasulsaAgent-1.0-SNAPSHOT.jar
```
