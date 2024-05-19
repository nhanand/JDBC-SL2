package jdbcdemo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class TransactionManagementDB {

	public static void main(String[] args) throws SQLException {

		String dburl = "jdbc:mysql://localhost:3306/animated_movies";
		String username = "root";
		String password = "root";

		String query1 = "insert into movies values('XYZ','Drama','director1','1995')";
		String query2 = "insert into movies values('ABC','Drama','director1','1996')";
		String query3 = "update movies set director='James' where title='Inside Out'";

		boolean flag = false;

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection(dburl, username, password);
			Statement stmt = con.createStatement();
			con.setAutoCommit(false);

			stmt.addBatch(query1);
			stmt.addBatch(query2);
			stmt.addBatch(query3);

			int[] result = stmt.executeBatch();

			for (int i = 0; i < result.length; i++) {

				System.out.println(result[i]);
				if (result[i] == 0) {
					flag = true;
					break;
				}

			}
			if (flag = false) {

				con.commit();
				System.out.println("Transaction successful..");
			} else {

				con.rollback();
				System.out.println("Transaction Failure");
			}

		} catch (ClassNotFoundException e) {

			System.out.println("Check the steps again...");
		}

	}

}
