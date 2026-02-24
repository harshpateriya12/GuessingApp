import java.util.Scanner;
class GameController{
	public static boolean restartGame(Scanner sc){
		System.out.print("Do you want to play agian? (yes/no): ");
		return sc.nextLine().equalsIgnoreCase("yes");
	}
}