
import java.util.Scanner;

public class HandleInput {
    
    public HandleInput(){

    }

    public static int getMenu(Scanner scan){

        int line;
        boolean done = false;
        int selection;

        //Print Menu
        System.out.println("SoulScape Menu: ");
        System.out.println("1 - <insert query one here>");
        System.out.println("2 - <insert query two here>");
        System.out.println("3 - <insert query three here");
        System.out.println("4 - <insert query four here>");
        System.out.println("5 - <insert query five here>");
        System.out.println("6 - <insert query six here>");
        System.out.println("7 - Add Enemy");
        System.out.println("8 - Update Enemy Health");
        System.out.println("9 - Delete Enemy");
        System.out.println("10 - Exit Program");

        do {
                //Print prompt
                System.out.print("Enter Choice: ");

                //Get the user input
                line = scan.nextInt();
                selection = line;

                //validate input
                if (selection == 1 || selection == 2 || selection == 3 || selection == 4 ||selection == 5 ||selection == 6 ||
                    selection == 7 || selection == 8 || selection == 9 || selection == 10 ){
                        done = true;
                }else{
                    System.out.println("ERROR: bad menu item, please select from the list above");
                }
        }while(!done);
        System.out.println();

        return selection;
    }

}
