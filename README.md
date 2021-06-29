# Assignments
  Repo for submitting assignments

# Checkout instructions
  Repo url
  git@github.com:GoldenBear19355/Assignments.git
  
  clone master
  git clone -b master git@github.com:GoldenBear19355/Assignments.git
  
# Project Build instructions

  Set your java home and maven home 

  Developed with JDK1.8.21 Maven 3.3.9

1. Build from IDE 

  a. import as MVN into IDE/Eclipse. 
  
  b. set jdk and mvn home in via IDE/env variables.
  
  c. Run as Maven Install  or execute command 'mvn install' or 'mvnw install' (compiles and runs integration tests and generates the deployable jar artifact).
  
  d. Run as Maven Test or execute command 'mvn test' or 'mvnw test' (only to run the endpoint integration tests and reports can be found in \Assignments\target\surefire-reports)

2. Build from CMD / BASH :

  a. Navigate into Project folder. 
  
  b. run command 'mvnw clean install'  or 'mvn clean install' ( compiles and runs integration tests and generates the deployable jar artifact).
  
  c. run command 'mvn test' or 'mvnw test' (only to run the endpoint integration tests and reports can be found in \Assignments\target\surefire-reports)
  
# Deploy instructions

1. From IDE

  a. run as Spring Boot app to deploy the jar in embedded server. 
  
  b. Launch app using postman .
  
  c. send a post request to url http:localhost:8080/lcs with following.
  
  d. set content-type as application/json.
  
  e. use the below sample json body : 
  {
    "setOfStrings": [
      {"value": "commcastaxyzz"},
      {"value": "xyzzcommcastic"},
      {"value": "broadxyzzcommcaster"}
    ]
  }
  
 2. From cmd / bash
 
    a. java -jar <path-to-jar>\demo-1-0.0.1-SNAPSHOT.jar
    
    b. curl -d '{"setOfStrings": [{"value": "commcastaxyzz"},{"value": "xyzzcommcastic"},{"value": "broadxyzzcommcaster"}]}' -H 'Content-Type:application/json' http://localhost:8080/lcs
  
 # General Instructions
 
   a. uses embedded server
   
   b. runs on default port 8080
   
   c. protocol : http
   
   d. Run Demo1Application1Test.java as standalone Junit test, which covers bad request test scenarios. 
  
