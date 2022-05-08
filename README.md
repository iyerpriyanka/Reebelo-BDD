**Reebelo Scenario Automation**

Tools:
Coding Language: Java (ver. 1.8)
Build Tool: Maven


Libraries Used:
*Selenium*
*Cucumber*
*Cucumber Junit*
*Webdriver Manager*

Folder Structure:
Entire code is placed under src/test/ package.

java/com/au/reebelo/ui/automation/ - contains all the source code required to execute automated checks.

Steps to execute in local:
From command prompt:  
mvn test or mvn clean test
Also,can run directly from IDE from TestRunner file
src/test/java/com/au/reebelo/ui/automation/runner/TestRunner**

Sample Reports can be found in:
HTML Report : target/cucumber-report/cucumber.html
Json Report : target/cucumber-report/cucumber.json

Screenshot upon failure / error 
Screenshot : src/test/java/com/au/reebelo/ui/automation/screenshot
