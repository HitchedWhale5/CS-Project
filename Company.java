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

				System.out.println("What item type would you like to list?");
				System.out.println();
				System.out.println("  [Ammunition] [Armor] [Boss Soul] [Chest Armor]");
				System.out.println("  [Consumable] [Covenant] [Gauntlets] [Helm]");
				System.out.println("  [Item] [Key Item] [Leggings] [Miracle]");
				System.out.println("  [Multiplayer Item] [Ore] [Projectile] [Pyromancy]");
				System.out.println("  [Ring] [Shield] [Soul] [Tool] [Upgrade Material] [Weapon]");  
				scan.nextLine();
				System.out.println();
				System.out.print("What item type would you like to display: ");
				String input = scan.nextLine();
				db.query1(input);
				
			}else if(menuSelection == 2){

				scan.nextLine();
				System.out.print("Enter a letter: ");
				String letter = scan.nextLine();
				letter = letter + "%";
				db.query2(letter);

			}else if(menuSelection == 3){
				System.out.print("What location would you like to see?");
				System.out.println();
				System.out.println("[Anor Londo] [Archdragon Peak] [Catacombs of Carthus]");
				System.out.println("[Cathedral of the Deep] [Cemetary of Ash] [Church of Yorshka]");
				System.out.println("[Consumed Kings Garden] [Farron Keep] [Firelink Shrine]");
				System.out.println("[Grand Archives] [High Wall of Lothric] [Irithyll Dungeon]");
				System.out.println("[Irithyll of the Boreal Valley] [Kiln of the First Flame] [Lothric Castle]");
				System.out.println("[Painted World of Ariandel] [Profaned Capital] [Road of Sacrifices]");
				System.out.println("[Smouldering Lake] [The Dreg Heap] [The Ringed City]");
				System.out.println("[Undead Settlement] [Untended Graves]");
				scan.nextLine();
				System.out.println();
				System.out.print("What location would you like to display: ");
				String input = scan.nextLine();
				db.query3(input);

			}else if(menuSelection == 4){
				
				System.out.print("List desired amount of items: ");
				int input = scan.nextInt();
				db.query4(input);


			}else if(menuSelection == 5){

				System.out.print("What locations would you like to compare?");
				System.out.println();
				System.out.println("[Anor Londo] [Archdragon Peak] [Catacombs of Carthus]");
				System.out.println("[Cathedral of the Deep] [Cemetary of Ash] [Church of Yorshka]");
				System.out.println("[Consumed Kings Garden] [Farron Keep] [Firelink Shrine]");
				System.out.println("[Grand Archives] [High Wall of Lothric] [Irithyll Dungeon]");
				System.out.println("[Irithyll of the Boreal Valley] [Kiln of the First Flame] [Lothric Castle]");
				System.out.println("[Painted World of Ariandel] [Profaned Capital] [Road of Sacrifices]");
				System.out.println("[Smouldering Lake] [The Dreg Heap] [The Ringed City]");
				System.out.println("[Undead Settlement] [Untended Graves]");
				scan.nextLine();
				System.out.println();
				System.out.print("Enter first location: ");
				String first = scan.nextLine();
				System.out.print("Enter Second Location: ");
				String second = scan.nextLine();
				System.out.println();
				db.query5(first, second);
				System.out.println();



			}else if(menuSelection == 6){

				

			}else if(menuSelection == 7){

				scan.nextLine();
				int id = 999;
				System.out.print("Enter Enemy Name: ");
				String name = scan.nextLine();
				System.out.print("Enter Enemy HP: ");
				int hp = scan.nextInt();
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

				Enemy e = new Enemy(id, name, hp, souls, weakness, resistance, immunity, boss);
				db.insertEnemy(e);

			}else if(menuSelection == 8){

				System.out.println("What enemy would you like to change?");
				System.out.println("Enter Enemy ID: ");
				int id = scan.nextInt();
				System.out.println("Enter new health: ");
				int hp = scan.nextInt();
				db.updateEnemyHP(id, hp);
				
			}else if(menuSelection == 9){
				System.out.print("Insert EnemyID : ");
				int input = scan.nextInt();


				db.deleteEnemy(input);
			}

		}while (menuSelection != 10);
		
		System.out.println("Shutting down...");

		db.disconnect();

	}
}
