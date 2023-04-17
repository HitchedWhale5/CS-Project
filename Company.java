import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

public class Company {

	public static void main(String[] args) {
		System.out.println("Booting up...");
		
		Database db = new Database();
		db.connect();
		
		int x = 1;
		while(x == 1) {
			Scanner scan = new Scanner(System.in);
			System.out.println("Please pick an option from below by typing the designated number: ");
			System.out.println("\n (1): Query1 \n (2): Query2 \n (3): Query3 \n (4): Query4 \n (5): Query5 \n (6): Query6 \n (7): Add \n (8): Update \n (9): Delete \n (10): Exit Program");
			System.out.println();
			try {
				int userInput = scan.nextInt();
				if(userInput == 1) {
					System.out.println("You have selected Query 1! Executing results...");
					//method call for query 1
				}
				else if(userInput == 2) {
					System.out.println("You have selected Query 2! Executing results...");
					//method call for query 2
				}
				else if(userInput == 3) {
					System.out.println("You have selected Query 3! Executing results...");
					//method call for query 3
				}
				else if(userInput == 4) {
					System.out.println("You have selected Query 4! Executing results...");
					//method call for query 4
				}
				else if(userInput == 5) {
					System.out.println("You have selected Query 5! Executing results...");
					//method call for query 5
				}
				else if(userInput == 6) {
					System.out.println("You have selected Query 6! Executing results...");
					//method call for query 6
				}
				else if(userInput == 7) {
					System.out.println("You have selected to add an Enemy into the Enemy table. Please wait...");
					//add enemy method
				}
				else if(userInput == 8) {
					System.out.println("You have selected to update the Enemy table. Please wait...");
					//update enemy method
				}
				else if(userInput == 9) {
					System.out.println("You have selected to delete an Enemy from the Enemy table. Please wait...");
					//delete enemy method
				}
				else if(userInput == 10) {
					System.out.println("Thank you for using Soulscape. :) ");
					x++;
					scan.close();
				}
				else {
					System.out.println("Error: Please input one of the specified numbers. ");
				}
			} catch(Exception e) {
				System.out.println("Error: Please input one of the specified numbers. ");
			}
		}

		
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
