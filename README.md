# About
This is a simple SpringBoot application that accepts request in text (multiline String) and generates a report around expected metrics. 

# Issue
Generate a report from a given input string data that includes multiple lines.
Each line that contains data delimited by a comma (,) in the following order and map in the below order :
customerId,contractId,geozone,teamcode,projectcode,buildduration

# Steps to run the application
1. Build the application : mvn clean install
2. Start the application CustomerReportApplication
3. The application is running at port http://localhost:8080/customer
4. The controller accepts text data in request at http://localhost:8080/customer/report endpoint.
5. The String is mapped into List of Customer data modal.
6. The CustomerService class then calculates different metrics for the report.

# How to test
Once the application is running use postman to send a POST request with the text data in request body.
1. Method : POST
2. URL : http://localhost:8080/customer/report
3. Request : Type Text
````
2343225,2345,us_east,RedTeam,ProjectApple,3445s
1223456,2345,us_west,BlueTeam,ProjectBanana,2211s
3244332,2346,eu_west,YellowTeam3,ProjectCarrot,4322s
1233456,2345,us_west,BlueTeam,ProjectDate,2221s
3244132,2346,eu_west,YellowTeam3,ProjectEgg,4122s
````

5. Click Send.
6. Result is available as text


<img width="1028" alt="image" src="https://github.com/masingh09/Oracle_assignment/assets/13362700/3a3c99b4-f860-4cdb-944b-ebab791be4c3">

 
