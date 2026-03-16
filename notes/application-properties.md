# application.properties

## What it is
A configuration file Spring Boot reads at startup to configure your application.
Lives at: src/main/resources/application.properties (or .yml)

---

## Common built-in properties

```properties
server.port=8081                                        # default is 8080
spring.datasource.url=jdbc:postgresql://localhost/mydb  # DB connection
spring.datasource.username=postgres
spring.datasource.password=secret
logging.level.root=DEBUG                                # log level
```

Spring Boot already knows what to do with these — they map to auto-configured beans.

---

## Custom properties with @Value

application.properties:
```properties
app.name=WorkoutSocial
app.max-users=1000
```

Java class:
```java
@Service
public class WorkoutService {

    @Value("${app.name}")
    private String appName; // Spring injects "WorkoutSocial" automatically

    @Value("${app.max-users}")
    private int maxUsers;
}
```

Syntax: always use ${property.key} inside @Value

---

## Default values

If the property doesn't exist in the file → app crashes on startup.
Always provide a default for non-critical properties:

```java
@Value("${app.name:DefaultApp}") // uses "DefaultApp" if app.name not found
private String appName;
```

Why this matters at JPMC:
Deploying to a new environment and someone forgets to add a property →
without a default the entire app fails to start in production.
With a default it degrades gracefully instead of crashing.
That's the difference between a 2am incident and a non-event.

---

## @ConfigurationProperties — cleaner for multiple related properties

Instead of three separate @Value annotations:

application.properties:
```properties
app.name=WorkoutSocial
app.max-users=1000
app.version=1.0
```

Java class:
```java
@ConfigurationProperties(prefix = "app")
@Component
public class AppConfig {
    private String name;      // maps to app.name
    private int maxUsers;     // maps to app.max-users
    private String version;   // maps to app.version
    // getters and setters
}
```

Spring automatically maps app.name → name, app.max-users → maxUsers etc.
Much cleaner than scattered @Value annotations across multiple classes.

---

## application.properties vs application.yml

Same thing — just different formats. YAML is more readable for nested config:

application.properties:
```properties
spring.datasource.url=jdbc:postgresql://localhost/mydb
spring.datasource.username=postgres
```

application.yml:
```yaml
spring:
  datasource:
    url: jdbc:postgresql://localhost/mydb
    username: postgres
```

JPMC teams typically use .yml for readability.
