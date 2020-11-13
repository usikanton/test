 Download webdriver executables first and specify their paths into __service.properties__ _(src/main/resources/service.properties)_ file respectively.
 
 Command for run:
 
 **mvn clean test -Dbrowser=[chrome,firefox,edge]**
 
 Variable "browser" accepts values 'chrome' and 'firefox' to run tests in Google Chrome, Firefox and MS Edge browsers respectively. 
