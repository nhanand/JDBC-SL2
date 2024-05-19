mysql> use animated_movies;
Database changed
mysql> Delimiter $$
mysql> create procedure SelectAllMovies()
    -> Begin
    -> select * from movies;
    -> End $$
Query OK, 0 rows affected (0.01 sec)

mysql> Delimiter ;
======================================================
package jdbcdemo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ProcedureDemo {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {

		String dburl = "jdbc:mysql://localhost:3306/animated_movies";
		String username = "root";
		String password = "root";
		String query = "Call SelectAllMovies()";

		Class.forName("com.mysql.cj.jdbc.Driver");

		Connection con = DriverManager.getConnection(dburl, username, password);
		Statement stmt = con.createStatement(); // Execute your query

		ResultSet rs = stmt.executeQuery(query);

		while (rs.next()) {

			System.out.print("Title: " + rs.getString("title") + "\t");
			System.out.print("genre: " + rs.getString("genre") + "\t");
			System.out.print("director: " + rs.getString("director") + "\t");
			System.out.println("release_year: " + rs.getString("release_year"));
		}

		con.close();

	}

}
