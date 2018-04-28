# jsonapp

It is a repository of simple java app with Gson

## Prerequisite
* Java 8
* Maven 3.5+

## Features

* Implement the a simple Gson REST API app



## Build & Test

```
# Clone project from github
git clone https://github.com/harryho/jsonapp.git


# Build & package
mvn clean dependency:copy-dependencies package

# Test 
mvn test

# Development
mvn exec:java -Dexec.mainClass=com.mycompany.app.GsonApp --quiet

```


## Test API
### You will see following message after you run the application

```
Server is running on 127.0.0.1:8080

You can access the API via browser with following URL: localhost:8080/employee
```

* Option 1: Test the URL via browser


* Option 2: Test URL with CURL

```
curl -X GET http://127.0.0.1:8080/employee
```


### You will the json result

```
{
  "empID": 1,
  "name": "James",
  "permanent": false,
  "address": {
    "street": "200 High Street",
    "city": "Bangalore",
    "zipcode": 8975
  },
  "phoneNumbers": [
    123456,
    987654
  ],
  "role": "Manager",
  "cities": [
    "Sydney",
    "Brisbane"
  ],
  "properties": {
    "salary": "1000 Rs",
    "age": "34 years"
  }
}

```


## Use two command script to build and run (Windows cmd)

```
build.cmd
run.cmd

```



