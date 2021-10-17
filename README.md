# Fashionette QA Test Challenge
## Overview
Automation Test Framework for Fashionette UK shopping portal (https://www.fashionette.co.uk/)



## Technologies/Frameworks used:

<ul>
<li>Java</li>
<li>Selenium</li>
<li>TestNG</li>
<li>Maven</li>
<li>Extent Reports</li>

</ul>

## How to run?
This project runs using either TestNG xml file or using maven as a build tool.
<ul><b>Run using TestNG xml:</b>
Right click on testng.xml file and click on run
</ul>
<ul><b>Run using Maven Build tool:</b> Follow below mentioned steps
</ul>
<ul>
<li><b>mvn clean install</b> - use this command while running the tests for the first time</li>
<li><b>mvn clean test</b> - to run tests</li>

## Cross Browser Testing

By default all the tests will run in chrome browser,In order to run the tests in firefox, change <b>browserName</b> value to firefox in <b>src/main/java/fashionette/qa/automation/config.properties</b></li>

## Test Reports
After running the tests, if wanted to check for the test results extent report then look into this path <b>reports/extent.html</b> </li>




## Covered Test scenarios

1. Add a product to the cart and login
2. Modify user information
3. Apply a voucher

The implemented Test case uses voucher code data which is provided in ``` TestData.csv ``` file



