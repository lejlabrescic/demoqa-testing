<p align="center">
  <img src="https://media.tenor.com/cI3eAVLXj48AAAAC/hello-world.gif" />



# E-commerce application testing
For the purpose of the technical part of the job interview, [the e-commerce application](https://shop.demoqa.com/) is being tested. Testing framework that has been used is Selenium, combined with the JUnit. Below you can see steps to run the program, as well as the tested features. 
## About Selenium and JUnit
Selenium is an open-source framework for automating web browsers. It allows users to write scripts in multiple programming languages to interact with web browsers, simulating user actions such as clicking buttons and filling out forms. JUnit is a widely used testing framework for Java applications. It allows developers to write repeatable, automated tests for their code. Together, Selenium and JUnit can be used to automate the testing of web applications, by using Selenium to simulate user actions on the front-end, and JUnit to write tests for the back-end.
## Test suite
To find more about which features are tested, click to visit the detailed project
documentation [on the following link](https://drive.google.com/drive/folders/1MDl8HWSn33nP5kmHbFEPQ8tgAe8rVJcH?usp=sharing).
You will be able to see the description of the product, as well as of every automated test case. Represented below is the short insight into which tests cases are generated in this test suite. 


Test number | Test name |Test expectations  | Test status | Test type |
--- | --- | --- | --- |--- |
1 | testRegistering | User will be registered successfully. | PASS | Positive  |
2 | testLoginLogout | User wcan login and log out from the profile. | PASS  | Positive |
3 | testAddingToCart | User added product to cart. | PASS  | Positive |
4 | testShopping | User successfully bought a product. | PASS | Positive
5 |testSearch | User can search and add products to wishlist.| PASS | Positive
6 | testWrongCredentials |System should recognize wrong credentials and send the alert. | PASS | Negative
7 | testUserExists | System should recognize if the user exists already. |PASS | Negative 
8 | testEmailReset | User should receive email to reset the password. | PASS | Positive
9 | testSorting | User should be able to sort the products according to user's wishes. | PASS | Positive
10 | testCompareProducts | User should be able to compare products. | PASS | Positive
11 | testLeaveBlogComment | User should be able to leave comment about blog. | PASS |Positive

### Bug reports
During the testing and observation of the application, the certain bugs are found on the features. The detailed explanation of them can be found in the [project documentation](https://drive.google.com/drive/folders/1MDl8HWSn33nP5kmHbFEPQ8tgAe8rVJcH?usp=sharing). 
- Shop now & view all blog 
- Compare products feature
- Checking the number of digits in the phone number
- Checking the name of the user during checkout
- Real men's fashion button
- CMO & Designer not in sync with pictures 
- Pictures not loaded after waiting longer duration of time
- Logo leads to many different sources when clicked on
- Picture not found 
- Text overloading the picture
- PayPal, American Express, Amazon & Visa links do not work




## Instructions to run the project
- To run the project, you will need to have installed the environment for Java application development. 

- The pom.xml file contains every dependency needed to run the tests using Selenium and JUnit. After adding the dependencies, the Maven update should be done, to update the dependencies added.
- Apart from that, to use the WebDriver with Selenium, you will have to download the required ChromeDriver with the proper version from the [following link](https://chromedriver.chromium.org/downloads). 
- After the proper zipped file is downloaded, you need to extract it and enter the right path to your WebDriver in your Java class. The explanation can be seen below. 

![Driver](https://static.javatpoint.com/tutorial/selenium/images/selenium-webdriver-first-test-case12.png)

## 🚀 About Me
- Lejla Breščić

🔗 I am an IT student with backgrounds in journalism, graphic and web design. I
enjoy watching stars and constellations using my telescope. I find joy in
exploring technology as well as participating in hackathons and
competitions. My ideal carrier paths are connected with analysis of data and quality assurance.
I love listening to all kinds of music and going on Erasmus
trainings in Europe.

[![linkedin](https://img.shields.io/badge/linkedin-0A66C2?style=for-the-badge&logo=linkedin&logoColor=white)](https://www.linkedin.com/in/lejlabrescic/)
[![Github](https://camo.githubusercontent.com/b2d1ae072c968dbeaf2232f0e1071ae5a7b218b11caec1ae5c69c10ef370a3cc/68747470733a2f2f696d672e736869656c64732e696f2f62616467652f6769746875622d2532333234323932652e7376673f267374796c653d666f722d7468652d6261646765266c6f676f3d676974687562266c6f676f436f6c6f723d7768697465)](https://github.com/lejlabrescic)
