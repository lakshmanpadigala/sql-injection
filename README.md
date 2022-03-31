# sql-injection
Demo project for showing sql-injection and ways to counter it.
SQL Injection

We have developed an java swing application, to demonstrate the sql injection and fixed the vulnerability.

Deployment:

To deploy this project run

1.setup the mysql environment, create a new user and grant all the permission for the user using the command on mysql terminal.
	>> CREATE USER 'new_user_name'@'localhost' IDENTIFIED BY 'new_password';
	>> GRANT ALL PRIVILEGES ON *.* TO 'new_user_name'@'localhost';

2.change username and password in line 12 in connection.java with new_user_name and new_password as,
	>>c = DriverManager.getConnection("jdbc:mysql://localhost:3306/ems?allowMultiQueries=true","new_user_name","new_password");

3.Run the .sql file on mysql terminal isung the command
	>> SOURCE absolute path.../employee-management-system.sql
	
4.Add external jar file "mysql-connector-java-8.0.28.jar" to project library section as per the IDE rules. 

5.Then run the application from "login_page.java" as the main function located there.
