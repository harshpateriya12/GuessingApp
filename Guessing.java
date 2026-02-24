import java.util.Random;
import java.util.Scanner;
public class Guessing {
	public static void main(String[] args){
		System.out.println("Welcome to guessing app");
		GameConfig game = new GameConfig();
		game.showRules();
		
		Scanner sc = new Scanner(System.in);
		int attempts = 0;
		
		while(attempts < game.getMaxAttempts()){
			System.out.print("Enter your guess");
			int guess = sc.nextInt();
			attempts++;
			
			
			String result = GuessValidator.validateGuess(guess, game.getTargetNumber());
			String hint = HintService.generateHint(game.getTargetNumber(), attempts);
			System.out.println(hint);
			System.out.println(result);
			
			if("correct".equals(result)){
				break;
			}
		}
		
	}
}