# Ariel-Maven-project

### 📝 Project Overview

This is a Selenium-based UI automation testing project developed using Java, TestNG, and Maven. The framework is modular, supports ExtentReports for rich test reporting, and uses Log4j for detailed logging. Test data is managed through Excel, and configuration is driven by a centralized `config.properties` file.

### 🔧 Project Structure

* `src/main/java`: Utility and configuration classes
* `src/test/java`: Page objects and test cases
* `src/test/resources`: Properties and resource files
* `Driver/`: ChromeDriver binary (ensure executable permission on macOS/Linux)

### ✅ Prerequisites

* Java 11+
* Maven
* Chrome browser
* [ChromeDriver](https://chromedriver.chromium.org/) with executable permissions (`chmod +x ./Driver/chromedriver` on macOS/Linux)

### 🚀 Running Tests

```bash
mvn test
```

### 📂 Logs & Reports

* **Log4j logs**: Stored in `./Log/Ariellog4j.log`
* **Test reports**: Generated in the `Reports/` folder using ExtentReports

------------------------------
