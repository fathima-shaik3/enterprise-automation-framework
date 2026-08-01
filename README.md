# 🚀 Enterprise Automation Framework

## 📌 Overview

A Selenium Automation Framework developed using Java, Selenium WebDriver, TestNG, and Maven. This framework follows the Page Object Model (POM) design pattern and automates the Login and Logout functionality of the OrangeHRM application.

It supports data-driven testing using Excel, logging with Log4j2, screenshots, retry mechanism, and Jenkins Continuous Integration.

---

## 🛠 Tech Stack

- Java
- Selenium WebDriver
- TestNG
- Maven
- Apache POI
- Log4j2
- Jenkins
- Git & GitHub

---

## ✨ Features

- Page Object Model (POM)
- Data-Driven Testing (Excel)
- Cross-Browser Support
- ThreadLocal WebDriver
- Retry Analyzer
- Screenshot Capture
- Log4j2 Logging
- Maven Integration
- Jenkins Integration
- TestNG Reports

---

## 📂 Project Structure

```
enterprise-automation-framework
│── src
│   ├── main
│   │   ├── java
│   │   └── resources
│   ├── test
│   │   ├── java
│   │   └── resources
│── pom.xml
│── testng.xml
│── README.md
```

---

## 🧪 Test Scenarios

### Login Test
- Valid Login
- Invalid Password
- Invalid Username

### Logout Test
- Successful Logout
- Verify Login Page after Logout

---

## ⚙️ Configuration

Update credentials in:

```
src/test/resources/config.properties
```

Example:

```
url=https://opensource-demo.orangehrmlive.com/web/index.php/auth/login
username=Admin
password=admin123
browser=chrome
```

---

## ▶️ How to Run

Using Maven:

```bash
mvn clean test
```

Using TestNG:

Run `testng.xml`

Using Jenkins:

Configure a Maven Job and execute:

```
clean test
```

---

## 📊 Reports

Generated after execution:

- TestNG Reports
- Surefire Reports
- Screenshots
- Jenkins Build Results

---

## 👩‍💻 Author

**Shaik Fathima**

QA Automation Engineer | Java | Selenium | TestNG | Maven | Jenkins