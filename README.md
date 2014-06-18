# stringproperties

StringProperties is Java Properties with Extra Features. Open Source Java project under Apache License v2.0

### Current Stable Version is [1.0.1](https://maven-release.s3.amazonaws.com/release/org/javastack/stringproperties/1.0.1/stringproperties-1.0.1.jar)

---

## DOC

#### Usage Example

```java
import org.javastack.stringproperties.StringProperties;

public class Example {
	public static void main(final String[] args) throws Throwable {
		StringProperties p = new StringProperties();
		p.setProperty("state", "awake");
		p.setProperty("msg", "Hi ${user.name}, how are you ${state}?");
		System.out.println(p.getPropertyEval("msg"));
	}
}
```

* More examples in [Example package](https://github.com/ggrandes/stringproperties/tree/master/src/main/java/org/javastack/stringproperties/example/)

---

## MAVEN

Add the maven repository location to your pom.xml: 

    <repositories>
        <repository>
            <id>ggrandes-maven-s3-repo</id>
            <url>https://maven-release.s3.amazonaws.com/release/</url>
        </repository>
    </repositories>

Add the dependency to your pom.xml:

    <dependency>
        <groupId>org.javastack</groupId>
        <artifactId>stringproperties</artifactId>
        <version>1.0.1</version>
    </dependency>

---
Inspired in [Java Properties](http://docs.oracle.com/javase/7/docs/api/java/util/Properties.html) and [Spring-Placeholders](http://docs.spring.io/spring/docs/4.0.4.RELEASE/javadoc-api/org/springframework/beans/factory/config/PlaceholderConfigurerSupport.html).
