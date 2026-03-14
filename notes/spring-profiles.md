# Spring Profiles (@Profile)

## The Problem
Different environments (dev, UAT, prod) need different configs.
DB credentials, Kafka topics, API endpoints all differ per environment.
You never want prod credentials in your dev config or vice versa.

---

## The Solution — Profile-specific properties files

```
application.properties          ← always loaded (base config)
application-dev.properties      ← loaded when dev profile is active
application-prod.properties     ← loaded when prod profile is active
```

Spring Boot loads the base file first, then OVERLAYS the active profile's
file on top of it. Active profile settings override base settings.

---

## How to set the active profile

Option 1 — hardcoded in application.properties (BAD):
```properties
spring.profiles.active=dev
```
Risk: you might forget to change it before deploying to prod.
Risk: prod credentials could accidentally be committed to your repo.

Option 2 — JVM argument at startup (PREFERRED at JPMC):
```bash
java -jar app.jar --spring.profiles.active=prod
```
The Jenkins or Spinnaker pipeline passes this dynamically based on
which environment it's deploying to. No hardcoding, no human error,
no security risk.

---

## @Profile on beans

```java
@Service
@Profile("dev")
public class MockEmailService implements EmailService {
    // sends fake emails in dev — nobody gets spammed
}

@Service
@Profile("prod")
public class RealEmailService implements EmailService {
    // sends real emails in prod only
}
```

Spring only registers the bean that matches the active profile.
The other bean is completely ignored.

---

## Why JVM argument is better (interview answer)

1. Dynamic — pipeline knows which environment it's deploying to
2. No human error — nobody forgets to change application.properties
3. Security — prod credentials never hardcoded in source code
4. Works with Jenkins/Spinnaker automatically

---

## Connection to JPMC

Different Kafka topics, DB connections, and API endpoints per environment
are all handled through profile-specific properties files.
The app code never changes — only the config.
Spinnaker passes the active profile as a JVM argument at deploy time.
