# Backend-Customer Service

The backend-customer is a RESTful microservice with 3 endpoints for authenticating a customer, retrieving and updating his data, and displaying 3 customers by their day of birth in descending order. 

## Prerequisites

For this project Java 8 is required.

## Building

Since this is a maven project, Maven Wrapper plugin is available if maven is not installed on the system. To build the project, the following command from the root  directory must be executed:
```bash
mvn clean package
```

## Running 
This is a springboot project. The default port is 8080, but it can be overriden by executing:
```bash
mvn spring-boot:run -Dspring-boot.run.arguments=--server.port=8085
```

## Descripton 
The application exposes 3 endpoints.
- The first endpoint is for authorizing a customer with a 7 days valid JWT token after validation 
his credential, e.g., *localhost:8080/authenticate*. 
- The second endpoint is for updating and retrieving customer's data. The access token defines whose customer' data will be updates. The new data are included in request body. , e.g., *localhost:8080/update* 
- The third endpoint is for retrieving 3 customers ordered by date of birth in ascending order,
e.g., *localhost:8080/customers*

In the memory database 5 customers are stored:
| customer id |  username  | first name | last name | date of birth | password |
| --- | --- |--- | --- | --- | --- |    
| 1 | helloween1 | Markus | Grosskopf | 1962-01-05 | 7 |
| 2 | helloween2 | Kai | Hansen | 1963-02-10 | 7 |
| 3 | helloween3 | Michael | Weikath | 1964-03-15 | 7 |
| 4 | helloween4 | Michael | Kiske | 1965-04-20 | 7 | 
| 5 | helloween5 | Ingo | Schwichtenberg | 1966-05-25 |7 | 

## How to use it
To import the endpoints in postman, the following curl commands are available:
```bash
curl --location --request POST 'localhost:8080/authenticate' \
--header 'Content-Type: application/json' \
--data-raw '{
    "userName": "helloween1",
    "password": "7"
}'
```
```bash
curl --location --request GET 'localhost:8080/customers' \
--header 'Authorization: Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJoZWxsb3dlZW41IiwiZXhwIjoxNTg3MzIyOTI4LCJpYXQiOjE1ODcyODY5Mjh9.oKuTHMgZY9Km6Zs2DQ5zRZEf7GexXjrSNyNlnxiTL_ykT06yquQz5NhnkbLUJVtOmZsId0M0z23RA3kvw8W4-A'
```
```bash
curl --location --request PUT 'localhost:8080/update' \
--header 'Authorization: Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJoZWxsb3dlZW41IiwiZXhwIjoxNTg3OTEzMjA5LCJpYXQiOjE1ODczMDg0MDl9.CodB2G6lKBCLvjYzq2L_EWnb_VkRasm1R3o1uxreeeOcYu0NnQ3b03ZufC-H6FY4pnCt9WKMWDdrLuhCeyeP-Q' \
--header 'Content-Type: application/json' \
--data-raw '{
    "userName": "helloween6",
    "firstName": "Roland",
    "lastName": "Grapow",
    "dateOfBirth": "1970-03-14T23:00:00.000+0000",
    "password": "6"
}'
```

### Retrieve the access token
To call the first endpoint a post request is sent with the following request body:
```json
{
    "userName": "helloween1",
    "password": "7"
}
```
This will return the access token in this case for the customer with the usename *helloween1*.

### Retrieve 3 customers

After having an access token, the second endpoint can be called with an authorization header which includes the access token, 
*localhost:8080/customers*. Three customers will be displayed ordered by their age in descending order.

### Update customer's data

The third endpoind is for updating customer's data, *PUT localhost8080/:update*. 
An example of the request body which is required is the following:

```json
{
    "userName": "helloween6",
    "firstName": "Roland",
    "lastName": "Grapow",
    "dateOfBirth": "1970-03-14T23:00:00.000+0000",
    "password": "6"
}
```


