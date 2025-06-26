# API Automation - Cucumber Setup

This project demonstrates how to set up and run **Cucumber** tests with **Maven** for API automation.

## Project Setup

### 1. Clone the Repository

Clone the repository to your local machine:
```bash
git clone git@github.com:kuldeep04/fancode.git
cd fancodeApiAutomation
```
### 2. Prerequisites

Before running the tests, ensure you have the following installed:
	•	Java 16+
	•	Maven 3.6+
	•	Git

### 3. Install Dependencies

Navigate to the project directory and run the following Maven command to download and install all required dependencies:
```bash
mvn clean install
```
This will install all dependencies defined in the `pom.xml` file, including Cucumber, JUnit, and Rest-Assured.

### Running the Tests

To run the Cucumber tests, execute the following command:

```bash
mvn clean test
```

This command will:
- Compile the project.
- Run the tests specified in the `TestRunner.java` file.
- Generate a report in the `target/cucumber-reports` directory.

### Test Execution Breakdown:

- **TestRunner.java**: This is the main entry point for running the tests. It uses the `@CucumberOptions` annotation to specify:
    - The location of the feature files.
    - The glue code (step definitions).
    - The format of the test reports.

- **Feature Files**: Located in `src/test/resources/features/` directory, where you write your Gherkin syntax scenarios.

- **Step Definitions**: Located in `src/test/java/org/fancode/stepDefinitions/`. These classes contain the logic for each step in your feature files.

---

## Maven Surefire Plugin Configuration

To run Cucumber tests with Maven, the `maven-surefire-plugin` is configured in the `pom.xml` file to use JUnit 4. Below is the configuration used:

```xml
<plugin>
    <groupId>org.apache.maven.plugins</groupId>
    <artifactId>maven-surefire-plugin</artifactId>
    <version>3.1.2</version>
    <configuration>
        <includes>
            <include>**/TestRunner.java</include>
        </includes>
    </configuration>
</plugin>
```

This ensures that only the Cucumber runner is executed when running the tests.

---

## Viewing Test Reports

Once the tests complete, a detailed HTML report will be generated under `target/cucumber-reports/`. You can view the test results by opening the `cucumber.html` file in your browser.

---

## Troubleshooting

If you encounter any issues while running tests, here are a few things to check:

- Ensure your `TestRunner.java` class is correctly annotated with `@RunWith(Cucumber.class)`.
- Ensure the feature files are properly located in `src/test/resources/features/`.
- If the tests are not running, check that the Maven Surefire Plugin is correctly configured to run the `TestRunner` class.

---

## Dependencies

This project uses the following dependencies:
- **JUnit 4**: For running Cucumber tests.
- **Cucumber**: For running Gherkin-based tests.
- **Rest-Assured**: For API testing.
- **Maven Surefire Plugin**: For running tests in Maven.

Make sure you have the latest versions of these dependencies in your `pom.xml` file.
