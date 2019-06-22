package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.sun.rowset.CachedRowSetImpl;

public class DBUtil {
	Connection connection = null;

	public DBUtil() {
//Effective Java - Singleton pattern
//connectToMysql(host, database, user, passwd, utc)
	}

	// Loading the driver and connecting to the database
	public boolean connectToMysql(String host, String database, String user, String passwd, String utc)
			throws SQLException, ClassNotFoundException {
		try {
			if (connection == null) {

				Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
				String connectionCommand = "jdbc:mysql://" + host + "/" + database + "?user=" + user + "&password="
						+ passwd + "&serverTimezone=" + utc;
				connection = DriverManager.getConnection(connectionCommand);
				System.out.println("Datenbankverbindung erfolgreich aufgebaut!");
			}
			return true;

		} catch (Exception ex) {
			System.err.print("Datenbankverbindung konnte nicht aufgebaut werden! Siehe StackTrace!" + "/n");
			Logger lgr = Logger.getLogger(DBUtil.class.getName());
			lgr.log(Level.SEVERE, ex.getMessage(), ex);

			return false;
		}
	}

	// Method for disconnecting from the database
	public void disconnectMysql() throws SQLException {
		try {
			if (connection != null && !connection.isClosed()) {
				connection.close();
			}
		} catch (Exception e) {
			Logger lgr = Logger.getLogger(DBUtil.class.getName());
			lgr.log(Level.SEVERE, e.getMessage(), e);
		}
	}

	// Method for executing INSERT,DELETE and UPDATE operations
	public void dbExecuteStatement(String sqlStmt) throws SQLException, ClassNotFoundException {
		Statement stmt = null;
		if (connection != null) {
			try {
				stmt = connection.createStatement();
				stmt.executeUpdate(sqlStmt);
			} catch (SQLException e) {
				Logger lgr = Logger.getLogger(DBUtil.class.getName());
				lgr.log(Level.SEVERE, e.getMessage(), e);
			} finally {
				if (stmt != null) {
					stmt.close();
				}
				disconnectMysql();
			}
		} else {
			System.err.println("Datenbankverbindung verloren!" + "/n");
		}
	}
	//Method for executing prepared INSERT,DELETE and UPDATE operations
	public void dbExecutePreparedStatement(String preparedStmt, Connection connection) throws SQLException, ClassNotFoundException {
		PreparedStatement prepStmt = null;
		if (connection != null) {
			try {
				prepStmt = connection.prepareStatement(preparedStmt);
				prepStmt.executeUpdate(preparedStmt);

			} catch (SQLException e) {
				Logger lgr = Logger.getLogger(DBUtil.class.getName());
				lgr.log(Level.SEVERE, e.getMessage(), e);
			} finally {
				if (prepStmt != null) {
					prepStmt.close();
				}
				disconnectMysql();
			}
		}
	}

	// Method for retrieving the records from the database using Statement (SELECT)
	public ResultSet dbExecuteQuery(String sqlQuery) throws ClassNotFoundException, SQLException {
		Statement stmt = null;
		ResultSet rs = null;
		CachedRowSetImpl crs = null;
		if (connection != null) {
			try {
				stmt = connection.createStatement();
				rs = stmt.executeQuery(sqlQuery);
				crs = new CachedRowSetImpl();
				crs.populate(rs);

			} catch (SQLException e) {
				Logger lgr = Logger.getLogger(DBUtil.class.getName());
				lgr.log(Level.SEVERE, e.getMessage(), e);
			} finally {
				if (rs != null) {
					rs.close();
				}
				if (stmt != null) {
					stmt.close();
				}
				disconnectMysql();
			}
		}
		return crs;
	}
	public static Connection getConnection() {
		
		Connection connection = null;
		try {
			connection = DriverManager.getConnection("jdbc:mysql://193.196.143.168/aj9s-einkauf?user=aj9s-einkauf&password=DYUcen7KXKo3dPzt&serverTimezone=UTC");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return connection;
	}

	// Method for retrieving the records from the database using PreparedStatement(SELECT)
	public ResultSet dbExecutePreparedQuery (String sqlQuery) throws ClassNotFoundException, SQLException {
		PreparedStatement prepStmt = null;
		ResultSet rs = null;
		CachedRowSetImpl crs = null;
		if (connection != null) {
			try {
				prepStmt = connection.prepareStatement(sqlQuery);
				rs = prepStmt.executeQuery(sqlQuery);
				crs = new CachedRowSetImpl();
				crs.populate(rs);

			} catch (SQLException e) {
				Logger lgr = Logger.getLogger(DBUtil.class.getName());
				lgr.log(Level.SEVERE, e.getMessage(), e);
			} finally {
				if (rs != null) {
					rs.close();
				}
				if (prepStmt != null) {
					prepStmt.close();
				}
				disconnectMysql();
			}
		}
		return crs;
	}

}
