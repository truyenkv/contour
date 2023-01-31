# Contour Framework

### Introduce
- This is overall test automation framework is builded by Maven, Java, Junit5, Allure Report.
- This framework apply PageObject module.

### Install on your local
- Install editor - Inteliji (Optional). 
- Install Java - set JAVA_HOME. 
- Install Manve - set MAVEN_HOME. 

### How to run  
1. Pull code from GitHub and open by editor or cd to folder where contains the source code.  
2. This is manven project, please use command line to run the test case, there are many options
- Run with defautl config: `mvn clean test`
   -  The default browser is Chrome
   -  The default environment is DEV
   -  Run all test case.
- Run with options:
   - Run with special browser, example run: `mvn clean test -Dbrowser=firefox`
   - Run with special environment, example: `mvn clean test -Denv=staging`
   - Run with special group test case: `mvn clean test -Dgroups=smoke`
   - Run with multiple condition: `mvn clean test --Dbrowser=firefox -Denv=staging -Dgroups=smoke`
3. View report
- After completing run test case, please view report with command line: `mvn allure:serve`
