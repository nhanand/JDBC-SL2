package jdbcdemo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class CreateAndDropDB {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {

		String dburl = "jdbc:mysql://localhost:3306/animated_movies";
		String username = "root";
		String password = "root";

		String query1 = "create database mydatabase";
		String query2 = "use mydatabase";
		String query3 = "drop database mydatabase";

		Class.forName("com.mysql.cj.jdbc.Driver");

		Connection con = DriverManager.getConnection(dburl, username, password);
		Statement stmt = con.createStatement(); // Execute your query

		stmt.executeUpdate(query1);
		System.out.println("Database created successfully..");

		stmt.executeUpdate(query2);
		System.out.println("Database selected successfully..");

		stmt.executeUpdate(query3);
		System.out.println("Database Deleted successfully..");

		stmt.close();

	}

}
