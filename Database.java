import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

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
	

	private String url = "jdbc:sqlite:/D:/UW La Crosse/Junior Year/Spring semester/CS 364/Project/Soulscapel.db";;
	
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
	
	public void query1(String itemType) throws SQLException{
		String sql = "SELECT * FROM Loot GROUP BY LootType, LootName, LootID HAVING LootType = ?";
		PreparedStatement stmt = connection.prepareStatement(sql);
		stmt.setString(1, itemType);
		ResultSet results = stmt.executeQuery();

		
		ArrayList<Loot> lst = new ArrayList<>();
			

		System.out.println();
			while(results.next()) {
				int LootID = results.getInt("LootID");
				String LootName = results.getString("LootName");
				String LootType = results.getString("LootType");

				Loot e = new Loot(LootID, LootName, LootType);
				
				lst.add(e);
			}
			
			for(Loot e : lst) {
				System.out.println(e);
			}
			System.out.println();
		
	}

	public void query2(String letter) throws SQLException{
		String sql = "Select EnemyID, EnemyName FROM Enemy WHERE EnemyName LIKE ?";
		PreparedStatement stmt = connection.prepareStatement(sql);
		stmt.setString(1, letter);
		ResultSet results = stmt.executeQuery();
		System.out.println();

		while(results.next()){

			String EnemyName = results.getString("EnemyName");
			System.out.println(EnemyName);
		}
		System.out.println();
	}

	public void query3(String Location) throws SQLException{
		String sql = "SELECT * FROM Loot JOIN Drops JOIN Enemy JOIN Patrols JOIN Location ON Loot.LootID = Drops.LootID AND Drops.EnemyID = Enemy.EnemyID AND Enemy.EnemyID = Patrols.EnemyID AND Patrols.LocationID = Location.LocationID 	WHERE Location.LocationName = ?";
		PreparedStatement stmt = connection.prepareStatement(sql);
		stmt.setString(1, Location);
		ResultSet results = stmt.executeQuery();

		ArrayList<Loot> lst = new ArrayList<>();
			

		System.out.println();
			while(results.next()) {
				int LootID = results.getInt("LootID");
				String LootName = results.getString("LootName");
				String LootType = results.getString("LootType");

				Loot e = new Loot(LootID, LootName, LootType);
				
				lst.add(e);
			}
			
			for(Loot e : lst) {
				System.out.println(e);
			}
			System.out.println();
	}

}
