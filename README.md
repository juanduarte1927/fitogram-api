# Automation Testing API for Fitogram Challenge

>This example project has the goal of automate the API's from jsonplaceholder


## Prerequisites

Should be installed previously the following tools

[![gradle](https://gradle.org/install/)
[![java](https://img.shields.io/badge/java-v1.8.X-yellow.svg)](https://www.java.com/es/)

## Requisites  
| Name      | Version |  
| --------- | ------- |  
| gradle |  \>= 6.9.x |  
| java | > = 1.8.x |  
| cucumber | > = 4.x |  
| serenity | > = 2.1.x |  

## The project directory structure
​
This project compiles with gradle and follow the standard folder structure  used in the most of Serenity projects that implements the screenplay pattern:
```Gherkin

src 
   test 
        java
		    com.fitogram
			+actors
            +runners
			+stepdefinitions
			
			

       + resources 
        + features                      
            + {feature_name}.feature     
        + serenity.conf                   
```

The labels used during the automation are the following:

| Name               | Description                |  
| ------------------ | -------------------------- |  
| @validateEmailFormat   |  Validate the e-mail format in comments of the posts made by a user  |


##  Tech used
* 
*   
* [gradle](https://gradle.org/install/)  
* [JDK (Java Development Kit)](https://www.oracle.com/java/technologies/javase-downloads.html)  
* [BDD (Behavior-Driven Development)](http://www.thucydides.info/#/)  
* [Cucumber](https://cucumber.io/)  
* [Gherkin](https://cucumber.io/docs/gherkin/)  

>Authors:  
>  Juan Duarte
>  
