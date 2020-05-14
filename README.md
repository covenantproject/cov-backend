# cov-backend
This repo contains the Java sprint boot code for the backend APIs/application layer, and the SQL code for the database.

Website: https://covn.org

(c) 2020 Covenant Team

Released as open source under the Apache License v2.

# Contributor Agreement
By contributing ideas or code to this project, you agree to  https://github.com/covenantproject/covenant/blob/master/contributor-agreement.txt

# Prerequisites
Following needs to be installed for the successful project compilation:
* Apache Maven
* Java JDK


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
Script with schema is available in the following path:

```
\DB Script\Covenant_Script.sql
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

