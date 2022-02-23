# AmazonTask
selenium-cucumber-java:

This repository contains a collection of sample selenium-cucumber-java Task and libraries that demonstrate how to use the tool and
develop automation script using the Cucumber (v 6.9.1) BDD framework with Java as programming language. 
It generate HTML reports as well. 

Installation (pre-requisites):
JDK 1.8+ (make sure Java class path is set)
Maven (make sure .m2 class path is set)
IDE (IntelliJ)
IntelliJ Plugins for
Maven
Cucumber
Framework set up
Clone repository from here or download zip and set it up in your local workspace.

Run Some Sample Tests:
You Can Run directly the Runner class 

To run specific feature from the multiple feature files use, mvn test -Dcucumber.options="classpath:features/AmazonSearch.feature"
Reporters
Once you ran your tests HtML Extent Report will be generated in Reports file
![Screenshot 2022-02-23 113357](https://user-images.githubusercontent.com/62815273/155293113-5cbcfc4b-bf78-40be-b2c7-f2cc868ba256.jpg)

Develop automation scripts using BDD approach - Cucumber-Java:
There are already many predefined StepDefinitions which is packaged under /test/java/StepDefenations.
Tests are written in the Cucumber framework using the Gherkin Syntax. 

The Page Object Design Pattern
Within my mob app's UI there are areas that our tests interact with. A Page Object simply models these as objects within the test code.
to reduces the amount of duplicated code So if there is any UI changes, the fix need only be applied in one place. 


