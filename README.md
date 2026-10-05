# jdbc-postgresql-crud
A Java CRUD project using JDBC, Java Collections, and PostgreSQL.


Here’s a README you can copy into `README.md`. Replace the database name and commands if yours differ. **Don’t put your real database password in the README or Java files.**


# JDBC PostgreSQL CRUD

A Java console application that uses JDBC to connect to PostgreSQL and perform CRUD operations on employee records. It also uses Java Collections.

## Features

- Add employee records
- View employee records
- Update employee records
- Delete employee records
- Connect to PostgreSQL using JDBC

## Requirements

- Java JDK
- PostgreSQL
- PostgreSQL JDBC driver

## Database setup

1. Create a PostgreSQL database.
2. Run the SQL statements in `employee.sql` against that database.
3. Configure the database URL, username, and password in `DBconnection.java`.

Do not commit your actual database password to this public repository. Use an environment variable or a local configuration file that is excluded from Git.

## Project files

- `DBconnection.java` — creates the database connection
- `Employee.java` — employee model
- `EmployeeDAO.java` — database operations
- `EmployeeDAOInterface.java` — DAO interface
- `EmployeeMenu.java` — console menu
- `employee.sql` — SQL setup script
- `lib/` — project libraries

## Run

Open the project in your Java IDE, ensure the PostgreSQL JDBC driver is on the classpath, then run `EmployeeMenu.java`.

## License

No license has been added. All rights are reserved unless a license is added to this repository.
```
