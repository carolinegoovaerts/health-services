# Health Services
Demo app for:
- Java, Maven, Spring Boot, Data Jpa, REST, Freemarker Web UI, Junit 5, Selenium Webdriver
- Layers of abstraction in software testing

## Status
[![Build Status](https://travis-ci.com/carolinegoovaerts/health-services.svg?branch=master)](https://travis-ci.com/carolinegoovaerts/health-services)

## Usage
From the root directory of the project, the following commands can be issued.

### Run Unit tests
By convention, Maven recognizes all test classes named `*Test` as unit test classes.
```
mvn test
```

### Run Integration tests
Also, Maven recognizes all test classes named `*IT` as integration test classes.
```
# just the integration tests
mvn integration-test

# unit + integration tests (more common) 
mvn verify
```

### Run e2e test
We keep this test example out of the Maven build cycle by using an unconventional suffix of E2E:
```
mvn test -D test=ApplicationE2E
```

### Run UI test
Selenium Webdriver + WebDriverManager is used here to exercise the UI test.

The code example requires Firefox to be locally installed. The specific browser implementation can be easily replaced with Chrome or any other supported browser. 
For more info on supported drivers, see https://github.com/bonigarcia/webdrivermanager-examples.

Again, we keep this high level test out of the loop by using another suffix:
```
mvn test -D test=ApplicationUI
```

### Start the application
Exploratory test the application!
```
mvn clean package spring-boot:repackage \
    && java -jar target/health-services.jar
```

## Thanks
- @hamvocke
- @alisterscott
- @bonigarcia
- @jqno
