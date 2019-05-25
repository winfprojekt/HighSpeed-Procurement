package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.Statement;
//Den Vektor ist für die 
//sinnvolle Speicherung der zurückgelieferten Daten in der Datenbank nötig.
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.sql.rowset.CachedRowSet;

import java.sql.Date;
import javax.sql.rowset.CachedRowSet;
import com.sun.rowset.CachedRowSetImpl;

public class DBUtil {
	Connection connection;

	public DBUtil() {

	}

	// Loading the driver and connecting to the database
	public boolean connectToMysql(String host, String database, String user, String passwd, String utc)
			throws SQLException, ClassNotFoundException {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
			String connectionCommand = "jdbc:mysql://" + host + "/" + database + "?user=" + user + "&password=" + passwd
					+ "&serverTimezone=" + utc;
			connection = DriverManager.getConnection(connectionCommand);
			System.out.println("Datenbankverbindung erfolgreich aufgebaut!");

			return true;
		} catch (Exception ex) {
			System.err.print("Datenbankverbindung konnte nicht aufgebaut werden! Siehe StackTrace!");
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

	// Method for INSERT,DELETE and UPDATE operations
	public void dbExecuteQuery(String sqlStmt) throws SQLException, ClassNotFoundException {
		Statement stmt = null;
		try {
			connectToMysql("193.196.143.168", "aj9s-einkauf", "aj9s-einkauf", "DYUcen7KXKo3dPzt", "UTC");
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
	}
	// Method for retrieving the records from the database
	public ResultSet dbExecute(String sqlQuery) throws ClassNotFoundException, SQLException {
		Statement stmt = null;
		ResultSet rs = null;
		CachedRowSetImpl crs = null;

		try {
			connectToMysql("193.196.143.168", "aj9s-einkauf", "aj9s-einkauf", "DYUcen7KXKo3dPzt", "UTC");
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
		return crs;
	}
}
