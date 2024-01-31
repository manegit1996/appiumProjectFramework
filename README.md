
This project is designed to enable automated testing of specific funcionalities of mobile application, souch as validating the login form and conducting end-to-end test for selected product's purchase process

## Necessary tools to have on your machine for starting the project:
   - git
   - Java JDK: Provided download link: (https://www.oracle.com/java/technologies/downloads/)
   (I recommend setting the "JAVA_HOME" environment variable to the path
   of the Java JDK installation (check with `echo $JAVA_HOME`))
   - IDE
- Xcode (WebDriverAgent and Simulator)
- Appium
- Apache Maven

## Installation steps and User instructions:
   - Create a new folder somewhere on your machine.
   - Open cmd/terminal and navigate to that folder.
   - Clone the repository using the following command (copy the path from the GitHub repository, either using https or ssh):
     ```
     git clone [repository_path]
     ```
   - Open a new terminal and install Homebrew on iOS (if You don't have):
     ```
     /bin/bash -c "$(curl -fsSL https://raw.githubusercontent.com/Homebrew/install/HEAD/install.sh)"
     ```
   - Install Maven using Homebrew:
     ```
     brew install maven
     ```
## Download the application:
https://github.com/saucelabs/sample-app-mobile/releases
- Download iOS.Simulator.SauceLabs.Mobile.Sample.app.2.7.1.zip file

- Install and set up Appium
 (refer to this site:https://appium.io/docs/en/2.2/quickstart/install/)
----or----
``` 
npm install -g appium

```
- Install and configure Xcode WebDriverAgent

- Run the project:
Open the project in your IDE
(folder that You created when clonning the project)

- Run appium

- Build Xcode WebDriverAgent

- Run Simulator iPhone 11 from Xcode
(Xcode -> Open Developer Tool -> Simulator)
Note: please check if the udid-s of device are same in project code and in Your local simulator.
Check your udid for iPhone 11. Run command
```
xcrun simctl

```
## Install Application to Your simulator
Go to downloads folder, extract the application and just drag it to Your simulator

- Run Maven command to download neccessery tools and dependencies:
```
mvn clean install
```

## Execute the tests 
- Run  `testng.xml` in the project to execute the tests

- After executing the tests, under `extent.xml` will be created test cases reports.
- Also, under Screenshot folder will be created `screenshots` for invalid login



## Contact information:
Please feel free to contact me at manojlovic.nikola@yahoo.com if you encounter any difficulties running the project



