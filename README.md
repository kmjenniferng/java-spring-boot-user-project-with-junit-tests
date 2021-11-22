# Creating RESTful APIs using Java and Spring Boot with JUnit tests

The purpose of this project is to create 5 RESTful APIs to perform the following actions in MySQL database.
1. **Add a user**
2. **Get data for all users**
3. **Get data for 1 user**
4. **Delete 1 user**
5. **Update user name or user email**

## Application Architecture

<img src="https://github.com/kmjenniferng/java-spring-boot-user-project-with-junit-tests/blob/main/system_architecture.png">

## Instructions on running tests using POSTMAN
1. **Add a user**

HTTP:POST localhost:8080/user/addUser

Headers: Key = Content-Type, Value = application/json

Body: { "name":"Peter Smith", "email":"peter@test.com" }

Expected test result: user will be added into MySQL database.

2. **Get data for all users**

HTTP:GET localhost:8080/user/getAllUsers

Headers: Key = Content-Type, Value = application/json

Expected test result: all users data from MySQL database will be shown in response.

3. **Get data for 1 user**

HTTP:GET: localhost:8080/user/getUser/{user_id}

Headers: Key = Content-Type, Value = application/json

Expected test result: user data will be shown in response based on provided user id.

4. **Delete 1 user**

HTTP:DELETE: localhost:8080/user/deleteUser/{user_id}

Headers: Key = Content-Type, Value = application/json

Expected test result: a user with provided user id will be removed from MySQL database.

5. **Update user name or user email**

HTTP:PUT: localhost:8080/user/updateUser/{user_id}

Headers: Key = Content-Type, Value = application/json

Body: { "name":"Sam Smith", "email":"sam@test.com" }

Expected test result: a user name or user email will be updated from MySQL database based on provided user id.

