package dbService.home;

import java.sql.*;
import java.util.ArrayList;

import commonViewModels.home.dataColumnsViewModels;
import commonViewModels.home.dataRowsViewModels;
import commonViewModels.home.dataTableViewModels;
import commonViewModels.home.sqlParameterViewModels;

public class dbService {
	private Connection con;

	public dbService() throws Exception {
		con = DriverManager.getConnection(
				"jdbc:sqlserver://MARSH\\SQLSERVER2012;databaseName=LBS_Service;user=sa;password=geogeo;");
		// con =
		// DriverManager.getConnection("jdbc:sqlserver://10.10.3.32:1433;databaseName=LBS;user=sa;password=1234;");
	}

	private void addSQLParameters(PreparedStatement stmt, ArrayList<sqlParameterViewModels> sqlParameters)
			throws Exception {
		for (int i = 0; i < sqlParameters.size(); i++) {
			switch (sqlParameters.get(i).ParameterAttritube) {
			case "String":
				stmt.setString(i + 1, sqlParameters.get(i).ParameterValue.toString());
				break;
			case "Int":
				stmt.setInt(i + 1, Integer.parseInt(sqlParameters.get(i).ParameterValue.toString()));
				break;
			case "Boolean":
				stmt.setBoolean(i + 1, Boolean.parseBoolean(sqlParameters.get(i).ParameterValue.toString()));
				break;
			}
		}
	}

	/**
	 * 從資料庫取得資料
	 * 
	 * @param sqlCommandText
	 *            執行的sql指令
	 * @param sqlParameters
	 *            sql的參數
	 * @return
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */
	public dataTableViewModels deServiceGetResultSet(String sqlCommandText,
			ArrayList<sqlParameterViewModels> sqlParameters) throws Exception, SQLException, ClassNotFoundException {
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		PreparedStatement stmt = con.prepareStatement(sqlCommandText, ResultSet.TYPE_SCROLL_INSENSITIVE,
				ResultSet.CONCUR_READ_ONLY);
		addSQLParameters(stmt, sqlParameters);

		ResultSet rs = stmt.executeQuery();
		ResultSetMetaData rsmd = rs.getMetaData();

		dataTableViewModels dataTable = new dataTableViewModels(null);
		ArrayList<dataColumnsViewModels> col = null;
		ArrayList<dataRowsViewModels> row = new ArrayList<dataRowsViewModels>();
		dataColumnsViewModels c = null;
		dataRowsViewModels r = null;

		while (rs.next()) {
			col = new ArrayList<dataColumnsViewModels>();
			for (int i = 1; i <= rsmd.getColumnCount(); i++) {
				String columnName = rsmd.getColumnName(i);
				Object value = rs.getObject(columnName);
				c = new dataColumnsViewModels(columnName, value);
				col.add(c);
			}
			r = new dataRowsViewModels(col);
			row.add(r);
		}

		dataTable = new dataTableViewModels(row);

		con.close();
		rs.close();
		return dataTable;
	}

	/**
	 * 執行SQL
	 * 
	 * @param sqlCommandText
	 *            執行的sql指令
	 * @param sqlParameters
	 *            sql的參數
	 * @throws Exception
	 */
	public void deServiceExecute(String sqlCommandText, ArrayList<sqlParameterViewModels> sqlParameters)
			throws Exception {
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		PreparedStatement stmt = con.prepareStatement(sqlCommandText, ResultSet.TYPE_SCROLL_INSENSITIVE,
				ResultSet.CONCUR_READ_ONLY);
		addSQLParameters(stmt, sqlParameters);
		stmt.executeUpdate();
	}
}
