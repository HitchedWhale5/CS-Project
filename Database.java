import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Database {

	/*
	 * load SQL driver (JDBC: Java Database Connector/ODBC)
	 * - add to build path
	 * 
	 * set up our database (script)
	 * 
	 * connect to the database
	 * 
	 * insert/modify/delete data (Java)
	 * 
	 * query data (Java)
	 * 
	 * disconnect from the database
	 * 
	 */
	

	private String url = "jdbc:sqlite:/D:/UW La Crosse/Junior Year/Spring semester/CS 364/Project/Soulscapel.db";
	
	private Connection connection;
	
	public Database() {
		
	}
	
	public void connect() {
		try {
			connection = DriverManager.getConnection(url);
		} catch (SQLException e) {
			System.out.println("Cannot connect!");
		}
	}
	
	public void disconnect() {
		try {
			connection.close();
		} catch (SQLException e) {
			System.out.println("Cannot disconnect!");
		}
	}
	
	public ResultSet runQuery(String query) throws SQLException {
		PreparedStatement stmt = connection.prepareStatement(query);
		ResultSet results = stmt.executeQuery();
		return results;
	}
	
	public ResultSet enemyLookup(int EnemyID) throws SQLException {
		String query = "SELECT * FROM Enemy WHERE EnemyID = ?";
		PreparedStatement stmt = connection.prepareStatement(query);
		stmt.setInt(1, EnemyID);
		ResultSet results = stmt.executeQuery();
		return results;
	}

	public void insertEnemy(Enemy e) throws SQLException {
		String sql = "INSERT INTO Enemy (EnemyName, EnemyHP, EnemySouls, EnemyWeakness, EnemyResistance, EnemyImmunity, EnemyBoss) VALUES (?, ?, ?, ?, ?, ?, ?)";
		PreparedStatement stmt = connection.prepareStatement(sql);
		stmt.setString(1, e.getEnemyName());
		stmt.setInt(2, e.getEnemyHP());
		stmt.setInt(3, e.getEnemySouls());
		stmt.setString(4, e.getEnemyWeakness());
		stmt.setString(5, e.getEnemyResistance());
		stmt.setString(6, e.getEnemyImmunity());
		stmt.setString(7, e.getEnemyBoss());
		int numRowsAffected = stmt.executeUpdate();
		System.out.println("Number of rows affected: " + numRowsAffected);
	}
	
	public void updateEnemyHP(int enemyID, int EnemyHP) throws SQLException {
		String sql = "UPDATE Enemy SET EnemyHP = ? WHERE EnemyID = ?";
		PreparedStatement stmt = connection.prepareStatement(sql);
		stmt.setInt(1, EnemyHP);
		stmt.setInt(2, enemyID);
		stmt.executeUpdate();
	}
	
	public boolean deleteEnemy(int e) throws SQLException {
		String sql = "DELETE FROM Enemy WHERE EnemyID = ?";
		PreparedStatement stmt = connection.prepareStatement(sql);
		stmt.setInt(1, e);
		int numRowsAffected = stmt.executeUpdate();
		return numRowsAffected > 0;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}

