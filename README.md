# stringproperties

StringProperties is Java Properties with Extra Features. Open Source Java project under Apache License v2.0

### Current Stable Version is [1.0.1](https://search.maven.org/#search|ga|1|g%3Aorg.javastack%20a%3Astringproperties)

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

Add the dependency to your pom.xml:

    <dependency>
        <groupId>org.javastack</groupId>
        <artifactId>stringproperties</artifactId>
        <version>1.0.1</version>
    </dependency>

---
Inspired in [Java Properties](http://docs.oracle.com/javase/7/docs/api/java/util/Properties.html) and [Spring-Placeholders](http://docs.spring.io/spring/docs/4.0.4.RELEASE/javadoc-api/org/springframework/beans/factory/config/PlaceholderConfigurerSupport.html).
