import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Database {
	
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


		System.out.println();
		System.out.println("Results: ");
		System.out.println();
			while(results.next()) {
				String LootName = results.getString("LootName");
				System.out.println(LootName);
				
			}
			System.out.println();
		
	}

	public void query2(String letter) throws SQLException{
		String sql = "Select EnemyID, EnemyName FROM Enemy WHERE EnemyName LIKE ?";
		PreparedStatement stmt = connection.prepareStatement(sql);
		stmt.setString(1, letter);
		ResultSet results = stmt.executeQuery();
		System.out.println();

		System.out.println();
		System.out.println("Results: ");
		System.out.println();
		while(results.next()){

			String EnemyName = results.getString("EnemyName");
			System.out.println(EnemyName);
		}
		System.out.println();
	}

	public void query3(String Location) throws SQLException{
		String sql = "SELECT * FROM Loot JOIN Drops JOIN Enemy JOIN Patrols JOIN Location ON Loot.LootID = Drops.LootID AND Drops.EnemyID = Enemy.EnemyID AND Enemy.EnemyID = Patrols.EnemyID AND Patrols.LocationID = Location.LocationID 	WHERE Location.LocationName = ? GROUP BY Loot.LootID ORDER BY Loot.LootType, Loot.LootName";
		PreparedStatement stmt = connection.prepareStatement(sql);
		stmt.setString(1, Location);
		ResultSet results = stmt.executeQuery();
			
		System.out.println();
		System.out.println("Results: ");
		System.out.println();
		System.out.println();
			while(results.next()) {
				String LootName = results.getString("LootName");
				String LootType = results.getString("LootType");
				System.out.print(LootName);
				for(int i = 0; i < (30-(LootName.length()));i++){System.out.print(" ");}
				System.out.print( "[" + LootType + "]");
				System.out.println();

			}
			
		
			System.out.println();
	}

	public void query4(int amount) throws SQLException{
		String sql = "SELECT EnemyID, EnemyName FROM Enemy NATURAL JOIN Drops NATURAL JOIN Loot GROUP BY EnemyID, EnemyName HAVING count(*) >= ?";
		PreparedStatement stmt = connection.prepareStatement(sql);
		stmt.setInt(1, amount);
		ResultSet results = stmt.executeQuery();

		
		System.out.println();
		System.out.println("Results: ");
		System.out.println();
		while(results.next()){

			String EnemyName = results.getString("EnemyName");
			System.out.println(EnemyName);
		}
		System.out.println();
	}

	public void query5(String first, String second) throws SQLException{
		String sql = "SELECT EnemyID, EnemyName FROM Enemy NATURAL JOIN Patrols NATURAL JOIN Location WHERE LocationName = ? INTERSECT SELECT EnemyID, EnemyName FROM Enemy NATURAL JOIN Patrols NATURAL JOIN Location WHERE LocationName = ?";
		PreparedStatement stmt = connection.prepareStatement(sql);
		stmt.setString(1, first);
		stmt.setString(2, second);
		ResultSet results = stmt.executeQuery();

		System.out.println();
		System.out.println("Results: ");
		System.out.println();
		while(results.next()){

			String EnemyName = results.getString("EnemyName");
			System.out.println(EnemyName);
		}
		System.out.println();

	}

	public void query6(String Location) throws SQLException {

        String sql = "SELECT Location.LocationName AS LocationName, count(*) AS EnemyCount FROM Enemy JOIN Patrols JOIN Location ON Enemy.EnemyID = Patrols.EnemyID AND Patrols.LocationID = Location.LocationID GROUP BY Location.LocationName HAVING count(*) > (SELECT DISTINCT count(*) FROM Enemy JOIN Patrols JOIN Location ON Enemy.EnemyID = Patrols.EnemyID AND Patrols.LocationID = Location.LocationID WHERE Location.LocationName = ?)";

        PreparedStatement stmt = connection.prepareStatement(sql);

        stmt.setString(1, Location);

        ResultSet results = stmt.executeQuery();

        System.out.println();

        while(results.next()){

 

            String LocationName = results.getString("LocationName");

            String EnemyCount = results.getString("EnemyCount");

            System.out.println("Location Name: " + LocationName + "\n" + "Unique Enemy Count: " + EnemyCount + "\n");

        }

        System.out.println();

 

    }

}
