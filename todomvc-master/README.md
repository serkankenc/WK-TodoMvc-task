GENERAL INFORMATION:
* Task Name: todomvc web application test automation task
* First Name, Last Name: Serkan Kenc (skenc06@gmail.com)
* Software QA Testing Coding Challenge (UI Part)
* Language: Java
* Installation Guide:
This is a Maven project that host runs this code Java and Maven is already installed and JAVA_HOME already set.
All dependencies in my pom.xml file come from Maven repository which means additional installation is needed.
* Dependencies:
 -Junit
 -Bonigarcia WebDriver
 -Selenium
 -Cucumber
* Plugins: maven-surfire-plugin, CukesRunner, maven-cucumber-reporting
* Framework can be created by using TestNG or Cucumber BDD, I preferred Cucumber BDD.
* The project is built by using Page Object Model(POM) desing pattern but it can improve if case of need. So that locators/methods are in the central location (ToDoPage)
* For reporting I used Maven Plugin in pom.xml file. I have Cucumber and Default HTML reporting with browser
* Gherkin language is used.


WHAT IS TESTED?

 Positive Scenario
 
  User Story 1: User can create task in the list
  
  User Story 2: User can edit existing task in the list
  
  User Story 3: User can delete existing task in the list
  
  User Story 4: User can delete multiple task by clicking clean completed button
 
 Negative Scenario
 
  User Story 1: User can not create task in the list
  
  User Story 2: User can not edit existing task in the list
  
  User Story 3: User can not delete existing task in the list
  
  User Story 4: User can not delete multiple task by clicking clean completed button
   

HOW TESTED? Cucumber BDD

Background: Given the user is on the To Do page, And the user writes tasks to do
  
#User Story 1, Positive Scenario: User can create task in the List

  When the user add new task
  
  Then the new task is added on the list

#User Story 1, Negative Scenario: User cannot add task To Do List (space, blank)

  And the user put space, blank
  
  Then the task is not added on the list

#User Story 2, Positive Scenario: User can edit existing task in the list

  When the user edits existing task
  
  Then the existing task in the list is edited

#User Story 2, Negative Scenario: User can not edit existing task in the list

  When the user does not edit existing task
  
  Then the existing task in the list is not changed

#User Story 3, Positive Scenario: User can delete existing task in the list

  When the user delete existing task in the list
  
  Then the existing task in the list is deleted

#User Story 3, Negative Scenario: User can not delete existing task in the list

  When the user do not delete existing task in the list
  
  Then the number of existing tasks are not changed

#User Story 4, Positive Scenario: User can delete multiple task by clicking clean completed button

  When the user chooses task he or she wants to delete
  
  And the user delete chosen tasks in the list
  
  Then the chosen multiple tasks are removed

#User Story 4, Negative Scenario: User can not delete multiple task by clicking clean completed button

  When the user does not choose any task to delete
  
  Then the number of existing tasks are not changed


PAGES AND CLASSES IN THE FRAMEWORK:

* ToDoPage: Page object class.
* CukesRunner: Creates connection between ToDo.feature file and step definitions.
* FailedTestRunner: To run only failed test we use FailedTestRunner and we do not have to run all the tests.
* Hooks Class: Runs Before and After scenarios.
* ToDo StepDefs: Step definitions class includes our Java codes.
* BrowserUtils: Screenshots, browser operations, synchronization and other ready Selenium methods.
* Configuration Reader: Reads configuration.properties file. 
* Driver: Provides WebDriver factory which has browser drivers.
* ToDo.Feature file: Our positive and negative Test Scenarios are here. Written in Gherkin language.
* Configuration Properties: Works in key&value structure.
* pom.xml: Includes necessary dependencies and plugins.

