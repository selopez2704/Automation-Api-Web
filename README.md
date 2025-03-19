# Automation-Api-Web

## Project Description

This project aims to create an automation framework that allows for the execution of tests in both web applications and APIs. By utilizing tools like TestNG, Cucumber, and Selenium, the goal is to facilitate test comprehension and execution while promoting collaboration through clear documentation.

## Technologies Used

- **Language:** Java 17
- **Testing Framework:** TestNG
- **Web Automation:** Selenium
- **BDD Tool:** Cucumber
- **Environment Management:** Docker
- **Continuous Integration:** Jenkins

## Framework Objectives

- Execute tests in web and API environments.
- Integrate Cucumber to facilitate writing scenarios in natural language.
- Share data between different step definitions in Cucumber.
- Provide a data provider that reads usernames and passwords from a JSON file.
- Configure multiple browsers (Chrome, Firefox, Edge) for testing.
- Implement Jenkins for CI/CD, sending notifications to Slack upon test completion.

## Project Structure

- **LICENSE**
- **README.md**
- **allure-results/**
- **logs/**
- **pom.xml**
- **src/**
  - **main/**
    - **java/**
      - **com/**
  - **test/**
    - **java/**
      - **com/**
    - **resources/**
      - **data/**
      - **properties/**
      - **suites/**
    - **screenshots/**
- **target/**

## Environment Requirements

1. **Java 17**: Ensure you have Java installed and configured on your machine.
2. **Docker**: For running Selenium Grid.
3. **Maven**: For dependency management and project building.
4. **Jenkins**: For continuous integration.

## Initial Setup

1. **Clone the repository:**

   ```bash
   git clone <REPOSITORY_URL>
   ```

2. **Navigate to the project directory:**

   ```bash
   cd <directory_name>
   ```

3. **Install dependencies:**

   ```bash
   mvn clean install
   ```

## TODO: Test Execution

## Continuous Integration with Jenkins

1. Set up a Jenkins server using Docker.
2. Create a `JenkinsFile` in the root of the project to define the pipeline.
3. Ensure the pipeline is configured to run tests using the Selenium Grid.
4. Configure Jenkins to send a message to Slack upon test completion.

## Scenarios to Automate

### WEB

- Validate valid and locked user (error message).
- Make a purchase of the cheapest product in the store.

### API

- Method: GET
  - URL: `https://pokeapi.co/api/v2/pokemon/{pokemon_name}/`
  - Description: Search for a Pokémon by its name.

## License

This project is licensed under the MIT License. See the LICENSE file for more details.

---

Thank you for reviewing this project! If you have any questions or comments, feel free to reach out.
