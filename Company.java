import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

import javax.print.attribute.standard.Media;

public class Company {

	public static void main(String[] args) throws SQLException {
		System.out.println("Booting up...");
		
		Database db = new Database();
		db.connect();
		
		Scanner scan = new Scanner(System.in);
		int menuSelection;
		


		do{
			//Print the menu and get selection
			menuSelection = HandleInput.getMenu(scan);

			//act on whichever menu item the user selected
			if(menuSelection == 1){
				
			}else if(menuSelection == 2){

			}else if(menuSelection == 3){

			}else if(menuSelection == 4){

			}else if(menuSelection == 5){

			}else if(menuSelection == 6){

			}else if(menuSelection == 7){

				scan.nextLine();
				System.out.print("Enter Enemy Name: ");
				String name = scan.nextLine();
				System.out.print("Enter Enemy HP: ");
				int hp = scan.nextInt();
				System.out.println();
				System.out.print("Enter Enemy Souls: ");
				int souls = scan.nextInt();
				scan.nextLine();
				System.out.print("Enter Enemy Weakness: ");
				String weakness = scan.nextLine();
				System.out.print("Enter Enemy Resistance: ");
				String resistance = scan.nextLine();
				System.out.print("Enter Enemy Immunity: ");
				String immunity = scan.nextLine();
				System.out.print("Is this enemy a boss: ");
				String boss = scan.next();

				Enemy e = new Enemy(name, hp, souls, weakness, resistance, immunity, boss);
				db.insertEnemy(e);

			}else if(menuSelection == 8){
				
			}else if(menuSelection == 9){
				System.out.print("Insert EnemyID : ");
				int input = scan.nextInt();


				db.deleteEnemy(input);
			}

			System.out.println(menuSelection);
		}while (menuSelection != 10);
		
		/* try {
			String query = "SELECT * FROM Enemy";
			ResultSet results = db.runQuery(query);
			
			ArrayList<Enemy> lst = new ArrayList<>();
			
			while(results.next()) {
				int EnemyID = results.getInt("EnemyID");
				String EnemyName = results.getString("EnemyName");
				int EnemyHP = results.getInt("EnemyHP");
				int EnemySouls = results.getInt("EnemySouls");
				String EnemyWeakness = results.getString("EnemyWeakness");
				String EnemyResistance = results.getString("EnemyResistance");
				String EnemyImmunity = results.getString("EnemyImmunity");
				String EnemyBoss = results.getString("EnemyBoss");

				Enemy e = new Enemy(EnemyID, EnemyName, EnemyHP, EnemySouls, EnemyWeakness, EnemyResistance, EnemyImmunity, EnemyBoss);
				
				lst.add(e);
			}
			
			for(Enemy e : lst) {
				System.out.println(e);
			}
			
			ResultSet results = db.enemyLookup(72);
			if(results.next()) {
				int EnemyID = results.getInt("EnemyID");
				String EnemyName = results.getString("EnemyName");
				int EnemyHP = results.getInt("EnemyHP");
				int EnemySouls =  results.getInt("EnemySouls");
				String EnemyWeakness = results.getString("EnemyWeakness");
				String EnemyResistance = results.getString("EnemyResistance");
				String EnemyImmunity = results.getString("EnemyImmunity");
				String EnemyBoss = results.getString("EnemyBoss");

				Enemy e = new Enemy(EnemyID, EnemyName, EnemyHP, EnemySouls, EnemyWeakness, EnemyResistance, EnemyImmunity, EnemyBoss);
				
				
			 	System.out.println(e.toString());
			 }
			
			 Employee e = new Employee("222-22-2222", 60000.00, "Kim", "Jane", "Smith");
			 Enemy e = new Enemy(777, "Lenny", 63, 536, "Physical", "Magic", "Fire", "Yes");
			 db.insertEnemy(e);
			
			 System.out.println();
			
			 db.updateEmployeeSalary(e, 65000.00);
			
			 boolean result = db.deleteEnemy(e);
			 System.out.println(result);
			
		 } catch(SQLException e) {
			 System.out.println("Something went wrong!");
			 e.printStackTrace();
		 } */
		
		System.out.println("Shutting down...");

		db.disconnect();

	}
}
