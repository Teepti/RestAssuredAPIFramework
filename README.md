# RestAssuredAPIFramework
Following steps need to be performed to execute this code.

# Need to install Json-Server Auth on your system
The below link will take to you the Json-Server-Auth github repository
https://github.com/techiediaries/fake-api-jwt-json-server

Step 1: 
Node and npm should be installed on your system.
Path should be updated in your system settings.

Step 2:
Clone the above repositry on your system.

Step 3: Copy the below part of Json and paste it into database.json file in Fake-api-jwt-json-server code.
"person": [
    {
      "first name": "Teepti",
      "last name": "Sachdeva",
      "age": 20,
      "id": 1,
      "address": "jg svhsvj js shvsj",
      "gender": "Female"
    },
    {
      "first name": "Amit",
      "last name": "Sharma",
      "age": 25,
      "id": 2,
      "address": "jg djgf jsdv sjv",
      "gender": "Male"
    },
    {
      "first name": "Priya",
      "last name": "Kumari",
      "age": 20,
      "id": 3,
      "Address": "shwdfj djfg jsgh jsg",
      "Gender": "Female"
    }
  ]
Step4: 
Need to execute the below 2 commands
1. npm install (This will install all your dependencies in your system mentioned in the requirements file of this project).
2. npm run start-auth (This will start the Fake Api auth server).

(These above steps also mentioned in the Readme file when you clone the above repository into your code.

# Need to setup Charles Proxy server free trail on your system

The below link will take to you the downlaodable file of charles Web proxy server.
https://www.charlesproxy.com/download/

1. Download the Windows.msi file on your system and setup that proxy server.
2. After Charles is setup on your system, need to perform 2 things on this
   1. Go to Help Section in the Menu Bar and Select Local IP address
   2. Note down the Hyper-V virtual Ethernet Adapter IP address from that and copy in the config.properties file of Rest API Framework and save that file.
   (Note: Every time you need to perform the above 2 steps whenever you start the proxy server)
   
# Maven should be Setup on your system along with path saved in environment settings.
# Java Should be setup on your system.
# Eclipse should be installed on your system.

# Clone this RestAssured API Framework repository into your system.
After setup all things you need to run the test using maven command

# mvn clean test

# allure serve allure-results (to generate reports in your system)
   

