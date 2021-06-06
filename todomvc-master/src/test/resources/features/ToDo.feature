@todo
Feature: ToDo List function

  Positive Scenario
  User Story 1: User can create task in the list
  User Story 2: User can edit existing task in the list
  User Story 3: User can delete existing task in the list
  User Story 4: User can delete multiple task by clicking clean completed button

Background:
  Given the user is on the To Do page
  And the user writes tasks to do

  #User Story 1
  #Positive Scenario:
  Scenario: User can create task in the List
    When the user add new task
    Then the new task is added on the list

  #User Story 1
  #Negative Scenario:
  Scenario: User cannot add task To Do List (space, blank)
    And the user put space, blank
    Then the task is not added on the list

  #User Story 2
  #Positive Scenario:
  Scenario: User can edit existing task in the list
    When the user edits existing task
    Then the existing task in the list is edited

  #User Story 2
  #Negative Scenario:
  Scenario: User can not edit existing task in the list
    When the user does not edit existing task
    Then the existing task in the list is not changed

  #User Story 3
  #Positive Scenario:
  Scenario: User can delete existing task in the list
    When the user delete existing task in the list
    Then the existing task in the list is deleted

  #User Story 3
  #Negative Scenario:
  Scenario: User can not delete existing task in the list
    When the user do not delete existing task in the list
    Then the number of existing tasks are not changed

  #User Story 4
  #Positive Scenario:
  Scenario: User can delete multiple task by clicking clean completed button
    When the user chooses task he or she wants to delete
    And the user delete chosen tasks in the list
    Then the chosen multiple tasks are removed

  #User Story 4
  #Negative Scenario:
  Scenario: User can not delete multiple task by clicking clean completed button
    When the user does not choose any task to delete
    Then the number of existing tasks are not changed