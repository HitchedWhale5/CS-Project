import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Company {

	public static void main(String[] args) {

		Database db = new Database();
		
		db.connect();
		
		try {
			// String query = "SELECT * FROM Enemy";
			// ResultSet results = db.runQuery(query);
			
			// ArrayList<Enemy> lst = new ArrayList<>();
			
			// while(results.next()) {
			// 	int EnemyID = results.getInt("EnemyID");
			// 	String EnemyName = results.getString("EnemyName");
			// 	int EnemyHP = results.getInt("EnemyHP");
			// 	int EnemySouls = results.getInt("EnemySouls");
			// 	String EnemyWeakness = results.getString("EnemyWeakness");
			// 	String EnemyResistance = results.getString("EnemyResistance");
			// 	String EnemyImmunity = results.getString("EnemyImmunity");
			// 	String EnemyBoss = results.getString("EnemyBoss");

			// 	Enemy e = new Enemy(EnemyID, EnemyName, EnemyHP, EnemySouls, EnemyWeakness, EnemyResistance, EnemyImmunity, EnemyBoss);
				
			// 	lst.add(e);
			// }
			
			// for(Enemy e : lst) {
			// 	System.out.println(e);
			// }
			
			// ResultSet results = db.enemyLookup(72);
			// if(results.next()) {
			// 	int EnemyID = results.getInt("EnemyID");
			// 	String EnemyName = results.getString("EnemyName");
			// 	int EnemyHP = results.getInt("EnemyHP");
			// 	int EnemySouls =  results.getInt("EnemySouls");
			// 	String EnemyWeakness = results.getString("EnemyWeakness");
			// 	String EnemyResistance = results.getString("EnemyResistance");
			// 	String EnemyImmunity = results.getString("EnemyImmunity");
			// 	String EnemyBoss = results.getString("EnemyBoss");

			// 	Enemy e = new Enemy(EnemyID, EnemyName, EnemyHP, EnemySouls, EnemyWeakness, EnemyResistance, EnemyImmunity, EnemyBoss);
				
				
			// 	System.out.println(e.toString());
			// }
			
			// Employee e = new Employee("222-22-2222", 60000.00, "Kim", "Jane", "Smith");
			Enemy e = new Enemy(777, "Lenny", 63, 536, "Physical", "Magic", "Fire", "Yes");
			db.insertEnemy(e);
			
			System.out.println();
			
			// db.updateEmployeeSalary(e, 65000.00);
			
			boolean result = db.deleteEnemy(e);
			System.out.println(result);
			
		} catch(SQLException e) {
			System.out.println("Something went wrong!");
			e.printStackTrace();
		}
		
		db.disconnect();
		
		
	}

}
