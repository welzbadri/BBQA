# BBQA

Automation Testing of Computers Application
===========================================
Automation Framework :
-	The automation framework has been built with Selenium, Java ,TestNG and Maven.
-	Project libraries are located in the POM.xml file in the project.
-	The framework is built using the POM (Page Object Model) pattern.
-	Separate package for pages and its interaction methods (actions) on elements of these pages.
-	Separate package for tests , each module has its own test class.
-   Logs for every webelement action.
-	A test base class include  (driver/browser selection and URL based on cong. property file) , tear down tests and take screen shot on test failure. 
-	All test data are driven from excel sheet , with a sheet for every module. (No hard coded test data).
-	Utilities class for all reusable components.


Packages:
===========
Project Name : BBComputers

--src/main/java
-  com.bb.appconfig
-  com.bb.model
-  com.bb.pages
-  com.bb.utilities

--src/test/java
-  com.bb.testparser
-  com.bb.testresources
-  com.bb.tests

--resources


Automated Tests Cover the following functionality
==================================================
-	Computer Search
-	Create/Viewing/Editing/Deleting a Computer

Tests not automated
===================
-	Check Menu items presence.
-	Check the duplication of computers while creation.
-	Check the duplication of computers while editing.
-	Check Pagination computers main grid.

Steps to Run
============
-	Build the project on eclipse IDE.
-	In the project root ... Right click on the file (testng.xml) ... Select Run As > TestNG suite.
-	In the project root ... Executing 'mvn clean install' command.

Test report
===========
-	TestNG report generated in test output folder  (test-output >index.html) file in the root of the project
-   Extent report not implemented due to time limitation.

Test Cases
==========
-	List of test cases located in the following folder (Manual Testing/bbComputers_test_cases.pdf) 

Mapping Manual Tests to Automated Tests
=======================================
-	An excel sheet for mapping the manual test cases names and ids with the automated test cases (method names) with status pass or fail 
... located in the following folder (Manual Testing/ Mapping_Manual_Test_Cases_To_Automation.xlsx)


