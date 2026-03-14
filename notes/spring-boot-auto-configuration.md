# Spring Boot Auto-Configuration

## The Question
How does Spring Boot know what to configure automatically when you add a dependency?

---

## How it works — 3 steps

Step 1: You add a dependency to pom.xml (e.g. spring-boot-starter-web)
Step 2: Spring Boot sees it on the CLASSPATH
Step 3: Finds matching pre-written auto-configuration class → condition met → creates beans

The condition is simply: "Is this dependency on the classpath?"
You don't need to use it anywhere in your code. Just having it in pom.xml is enough.

---

## @SpringBootApplication — 3 annotations in one

```java
@SpringBootApplication
public class DemoApiApplication { ... }
```

This is actually:

@SpringBootConfiguration  → marks this class as a configuration class
@ComponentScan            → scans packages for @Service, @Repository, @Component etc.
@EnableAutoConfiguration  → triggers auto-configuration based on classpath

---

## Auto-configuration class example (internal Spring code)

```java
@ConditionalOnClass(DispatcherServlet.class) // IF spring-web is on classpath...
public class WebMvcAutoConfiguration {
    // ...automatically set up web server, DispatcherServlet, etc.
}
```

---

## Mental model

```
Add dependency to pom.xml
        ↓
Spring Boot sees it on the classpath
        ↓
Finds matching auto-configuration class
        ↓
Condition met → creates beans automatically
        ↓
Your app just works
```

---

## Why this matters

Before Spring Boot, you had to manually write XML config or Java config
to set up a web server, datasource, JPA etc. Spring Boot eliminated all of that
by auto-configuring based on what's on the classpath.
