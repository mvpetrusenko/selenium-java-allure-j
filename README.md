# selenium-java-allure
project for AQA portfolio 

OK: 

1. Rest API tests 
2. UX tests (clicking Accept Cookies button is OK)

NOK (To Be Done): 

1. add @After...? to quit a browser after each test 
2. edit Allure report: 
  2.1. report shows ONLY Rest API test results, NOT BOTH API and UX test results 
  2.2. maybe, add other details about test execution to the report 
  
3. Add project to Docker 
4. Add project to Jenkins 
5. Reformat project structures (variables, reusable code etc.)


Jenkins need Java version from 11, I have 8 

I created Docker image, while running (docker run java-docker) have the error: no main manifest attribute, in /app/app.jar 

To solve it I added in MANIFEST.MF file the name of my class with main method as a started point: 

"Manifest-Version: 1.0
Main-Class: tests.UI.base.BaseUITest" 

But it didn`t solve the problem



