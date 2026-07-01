# manual-jdbc

Initialization: createDataSource() configures a HikariDataSource, loading an initial database schema from a SQL script.

Connection: A try-with-resources block safely opens and closes a database connection.

Read (Select): Uses a PreparedStatement to query users named "Badri" and prints their IDs and names.

Create (Insert): Inserts a new user named "bablu".

Update & Delete: Attempts to modify and remove records.