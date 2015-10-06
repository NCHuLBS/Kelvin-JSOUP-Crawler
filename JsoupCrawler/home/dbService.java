package JsoupCrawler.home;

import java.sql.*;

public class dbService {

	private String conUrl;

	public dbService() {
		conUrl = "jdbc:sqlserver://localhost:1433;databaseName=BackboneV2;user=sa;password=1234;";
	}

	public String dbServiceGetValue() {
		try {

			Connection con = null;
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			con = DriverManager.getConnection(conUrl);
			String SQL = "SELECT Top 10 * FROM USER_MAIN";
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(SQL);
			while (rs.next()) {
				System.out.println(rs.getString("LOGIN_ID") + ", " + rs.getString("USER_NAME"));
			}
			rs.close();
			stmt.close();
			return "";
		} catch (Exception e) {
			return e.toString();
		}
	}
}
