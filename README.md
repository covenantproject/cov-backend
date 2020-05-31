# Prerequisites
Following needs to be installed for the successful project compilation:
* Apache Maven
* Java JDK 1.8 (Attn contributors: please use JDK 1.8. Do not use a newer version)


# Install dependencies

```
mvn install
```

## Configuration variables

All environment config variables are in the path:

```
\src\main\resources\application.properties
```

### DB Script

DB is PostgreSQL
Database creation script is available in the following path:

```
\DB Script\1_Table_Script.sql - creates all the tables in release1 schema
\DB Script\1_Documentation_Constraints.sql - adds comments to all table and columns. Applies CHECK CONSTRAINTS to char/varchar columns with constrained values.

```

### Running the project and base url

Click F5 to run the project in VS code
REST service will run in the following URL:

```
http://localhost:8080/covid_service/api
```

### Output file for deployment

After mvn installation, .war file will be generated which can be deployed to tomcat enabled server.
.war file will be available in the following path:

```
\target\covid_service.war
```

