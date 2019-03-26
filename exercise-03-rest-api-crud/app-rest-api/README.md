# Getting Started

### How to use it
* run MySQL container defined in `app-db`
* `exec-build.bat` - build Docker image of `app-rest-api`
* `exec-run-network.bat` - create network `if` does not exist
* `exec-run.bat` - run container in shared network (same as for `app-db`)
* `exec-connect.bat` - connect to running container
* hit http://localhost:8888/all/
* hit http://localhost:8888/all/create

### Extras
It is possible to run Spring Boot application via any if:
* * `mvn spring-boot:run -X`
* * `java -jar target/app-rest-api.jar -Xdebug`

### More information
The following guides illustrate how to use some features concretely:

* [Accessing data with MySQL](https://spring.io/guides/gs/accessing-data-mysql/)
* [Accessing Data with JPA](https://spring.io/guides/gs/accessing-data-jpa/)
* [Accessing JPA Data with REST](https://spring.io/guides/gs/accessing-data-rest/)
* [Accessing Neo4j Data with REST](https://spring.io/guides/gs/accessing-neo4j-data-rest/)
* [Accessing MongoDB Data with REST](https://spring.io/guides/gs/accessing-mongodb-data-rest/)

