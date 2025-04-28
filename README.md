# grok-automation-framework

robust and scalable automation framework using Java 17, TestNG, Maven 3.8.4, Extent Reports, Log4j, Cucumber, Serenity, Selenium WebDriver with Driver Manager, Page Object Model (POM), Page Factory, and support for both web and API testing. The framework will follow a data-driven BDD approach with simple and maintainable implementations.

Below is the complete structure and code for the framework, including key components like project structure, configuration files, and essential classes. I'll provide a Maven pom.xml, sample feature file, step definitions, page objects, API utilities, and reporting setup.

## Automation Framework Structure

src/
├── main/
│   ├── java/
│   │   ├── com/
│   │   │   ├── automation/
│   │   │   │   ├── config/
│   │   │   │   │   └── ConfigReader.java
│   │   │   │   ├── driver/
│   │   │   │   │   └── DriverManager.java
│   │   │   │   ├── pages/
│   │   │   │   │   ├── LoginPage.java
│   │   │   │   │   └── HomePage.java
│   │   │   │   ├── api/
│   │   │   │   │   └── ApiClient.java
│   │   │   │   ├── utils/
│   │   │   │   │   ├── ExtentReportManager.java
│   │   │   │   │   ├── LogManager.java
│   │   │   │   │   └── DataProviderUtil.java
│   │   │   │   └── hooks/
│   │   │   │       └── TestHooks.java
│   ├── resources/
│   │   ├── config.properties
│   │   ├── log4j2.xml
│   │   └── testdata/
│   │       └── testdata.xlsx
├── test/
│   ├── java/
│   │   ├── com/
│   │   │   ├── automation/
│   │   │   │   ├── stepdefinitions/
│   │   │   │   │   └── LoginSteps.java
│   │   │   │   └── runner/
│   │   │   │       └── TestRunner.java
│   ├── resources/
│   │   └── features/
│   │       └── Login.feature
pom.xml
serenity.properties



## How to Run
    Ensure Java 17 and Maven 3.8.4 are installed.
    Clone the project and navigate to the project directory.
    Run tests: mvn clean test
## View reports:
    Extent Reports: target/ExtentReports.html
    Serenity Reports: target/site/serenity/index.html
    Cucumber Reports: target/cucumber-reports/cucumber.html
    Logs: target/automation.log
## Key Features
    Modular Design: Uses Page Object Model and Page Factory for maintainable web testing.
    Driver Management: Thread-safe WebDriver management with WebDriverManager.
    BDD with Cucumber: Gherkin-based feature files for clear test scenarios.
    Data-Driven Testing: Reads test data from Excel using Apache POI.
    API Testing: RestAssured for API testing with reusable client.
    Reporting: Extent Reports and Serenity for detailed test reports.
    Logging: Log4j for comprehensive logging.
    Scalability: Thread-safe and configurable for parallel execution.
    Configuration: Centralized configuration via config.properties.
    This framework is robust, scalable, and easy to extend for additional test scenarios, browsers, or APIs.