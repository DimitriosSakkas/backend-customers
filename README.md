# Backend-Customer Service

The backend-customer is a RESTful microservice with 3 endpoint for authenticating
a customer, retrieving and updating his data, and displaying 3 customers in descending
order. 

## Getting Started



- The first endpoint is for authorizing a customer with  a valid JWT token after validation 
his credential, e.g., *localhost:8080/authenticate*
- The second endpoint is for updating and retrieving customer's data. By sending JWT token 
it is specified which customer' data has to be updated, e.g., *localhost:8080/update* 
- The third endpoint is for retrieving 3 customers ordered by date of birth in ascending order,
e.g., *localhost:8080/customers*
 
## Building Servive

Clone the project from GitHub and 
For this project Java 8 has been used. If Apache Maven is not installed, Maven wrapper plugin 
can be used. 
## Start Sevice

## Run Tests 