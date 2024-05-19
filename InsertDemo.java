package jdbcdemo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class InsertDemo {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {

		String title = "Jurassic Park";
		String genre = "Thriller";
		String director = "Andrew";
		String release_year = "2003";

		String dburl = "jdbc:mysql://localhost:3306/animated_movies";
		String username = "root";
		String password = "root";

		Class.forName("com.mysql.cj.jdbc.Driver");

		Connection con = DriverManager.getConnection(dburl, username, password);
		PreparedStatement ps = con.prepareStatement("insert into movies values(?,?,?,?)");

		ps.setString(1, title);
		ps.setString(2, genre);
		ps.setString(3, director);
		ps.setString(4, release_year);

		ps.executeUpdate();
		
		con.close();

	}

}
