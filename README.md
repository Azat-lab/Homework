# **BELHARD Academy Homework**
_The project is created to see Test Automation exercises._

| *Used Technologies* |
|---------------------|
| OpenJDK 17          |
| JUnit 5.9           |
| Selenium 4.8        |
| Chromedriver        |
| Gradle 8.0          |

_For detailed information please see *build.gradle*_

To designate assembling all outputs and running all checks:

```
gradle build
```

To assemble the application and execute some script or binary:

```
gradle run
```

To run tests type in console:

```
gradle test -i
```

To delete the contents of the build directory:

```
gradle clean
```

## *Project structure*
+ java
  +  +---+ config       | _Tests setup and initialization_ |
  +  +---+ pageobject   | _Application Pages_              |
  +  +---+ tests        | _Test suits_                     |
  +  +---+ utils        | _Framework utilities_            |
+ resources
  +  +---+ app.properties | _Configuration properties_ |

### **Test Automation - Exercise:**

+ Create new Gradle project based on Java and JUnit
+ Create auto-tests for Acme (https://litecart.stqa.ru/en/)

#### 1. Task: Login Positive Test
Login to Web-site and verify SecuredPage opened.


#### Add to the test project above the following test cases

Preconditions:
1.  Clone the test project
2. The project is built successfully

Tasks:
3. In Tests package create test class to verify warning messages using Actions (ie, invalid inputs on Base/Login page)
4. In Tests package create test class to verify error messages using Alert
   Additional: test cases to work with Frames, Tabs.

5. In PageObject package add PageObjects for categories and subcategories of Ducks product
6. On pages above create test cases to validate Sorting functionality
7. Create test case to verify purchasing of different ducks
8. Integrate Selenide helpers
9. Add Allure test report functionality

Questions to discuss:
1. How to get WindowsHandles, TabHandles, etc
2. 

Next steps:
1. Must overview of Belhard Academy slides.
Additional tasks: Investigation of current up-to-date official manuals and tutors for Test Automation tools.

2. Continue to finish homework assessments.
3. Add new functionality to the test project.

Answer on recent questions.

_Please focus on the test project as your final learning outcomes and study results._