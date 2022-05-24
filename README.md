# Challenge
This code projects represents a Coding Challenge provided by CARIAD. 
It was solved with Java and using Spring Boot which is a "Convention over
Configuration" framework for Java.

## Reasons for solving the task this way
- I've split the software up into a main controller, services and models based on the principle "Divide and Conquer". 
  This approach makes the code maintainable, testable and loosely coupled.
    - The main controller takes the get client requests which hold the URLs as query params.
    - The first service then takes the URLs and fetches the numbers from the test server and deserializes the received
      json structures into modelled Java objects.
    - The second service takes the Java objects and processes them as specified in the task. The result is returned to 
      the controller, which puts it to the response for the client.
- I've used Dependency Injection for my services based on the principle "Inversion of Control". By this, dependencies 
  between components are minimized. Testing and maintenance of the code is improved.
- The services implement interfaces which define the main method since it enables to easily  extend the code. By this, 
  it is easier to add functionality to the code by adding implementations for upcoming features.
- I've used WebClient from the Spring WebFlux framework to send requests to the test server. The WebClient is 
  initialized once in the specified service, so that it is not required to initialize the WebClient for every request.
  By this approach, every request can use the already initialized WebClient.

## Limitations of my solution
- I've used WebClient from Spring to send requests to the test server. It offers to specify how often requests shall
  be repeated if a request fails. However, this approach could be improved in the future by ignoring failed requests.
  However, the WebClient makes it hard to handle exceptions caused by failed requests.
- The unit test of the FetchNumbersService Service and the integration test currently depend on a running test server. 
  In the future the test server should be mocked, since its functionality should not be tested in our tests.

## Test, build and run the service
### Prerequisites
- Java 1.8
- Maven
- Docker

### Commands
Run the test server
```
docker run --detach --publish 8090:8090 digitalcrab/coding-challenge-test-server:latest
```
Test und build the service on Unix
```
./mvnw clean install
```
Alternatively: Test and build the service on Windows
```
./mvnw.cmd clean install
```
Run the service
```
./mvnw spring-boot:run
```
Send a request to the service
```
curl http://127.0.0.1:8080/numbers?u=http://127.0.0.1:8090/primes&u=http://127.0.0.1:8090/fibo&u=http://127.0.0.1:8090/rand
```
To stop the service press the keys:
```
cntrl + c
```