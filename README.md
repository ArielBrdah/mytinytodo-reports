# Selenium Automation Project

This project demonstrates automation testing practices using Selenium WebDriver. It includes various test cases for web forms, error validation, and site functionalities across multiple websites like Salesforce and eBay.

## Features

- **Automated Form Filling**: Simulates user input for form submissions.
- **Error Message Validation**: Checks for proper error messages when mandatory fields are left empty.
- **Advanced Search Automation**: Automates advanced search functionality on eBay.
- **Password Recovery Simulation**: Tests the forgot password functionality on Salesforce.
- **Reusable Functions**: Implements reusable methods for logging and element retrieval.

## Prerequisites

- **Java**: Ensure Java is installed and configured.
- **Selenium WebDriver**: Compatible with the Chrome browser.
- **ChromeDriver**: Download and specify the path to ChromeDriver executable.
- **Maven**: Recommended for managing dependencies.

## Setup Instructions

1. Clone this repository:
   ```bash
   git clone <repository_url>
   ```

2. Navigate to the project directory:
   ```bash
   cd automation-project-2024
   ```

3. Download [ChromeDriver](https://chromedriver.chromium.org/downloads) and place it in the appropriate directory.

4. Update the `chromedriver` path in the code:
   ```java
   System.setProperty("webdriver.chrome.driver", "<path_to_chromedriver>");
   ```

5. Compile and run the code using your preferred IDE or command line.

## Usage

### Run Specific Test Cases

#### Form Filling Test
Simulates filling out a multi-step form.
```java
app.fill_form_test();
```

#### Error Validation Test
Checks if error messages appear when fields are left empty.
```java
app.error_fields_test();
```

#### Salesforce Password Recovery Test
Tests the forgot password functionality.
```java
app.forgot_password_salesforce();
```

#### eBay Advanced Search Test
Automates advanced search parameters on eBay.
```java
app.advanced_search_ebay();
```

### Logging and Reusability
- **Logging**: Each test step is logged to the console for clarity and debugging.
- **Element Finder**: The `el()` method provides a convenient way to locate elements by CSS selectors.

### Example
```java
App.log("Fill searching article fields...");
WebElement search_word = App.el("#_nkw");
search_word.sendKeys("tent");
```

## Best Practices

- **Code Reusability**: Use helper methods like `el()` and `log()` to reduce redundancy.
- **Thread Management**: Add proper thread sleeps to handle dynamic content loading, or use explicit waits for better reliability.
- **Browser Management**: Always close the browser instance after execution to free resources.

## Future Improvements

- Implement explicit waits for better test reliability.
- Add configuration management for environment variables.
- Include reporting tools like Allure Reports.
- Extend automation to include mobile testing.

## License

This project is licensed under the [MIT License](LICENSE).

---