import java.util.Random;
import java.util.Scanner;
public class Guessing {
	public static void main(String[] args) throws InvalidInputException{
		Scanner sc = new Scanner(System.in);
		System.out.println("Welcome to guessing app");
		boolean restart;
		
		
		do{
			System.out.print("Enter player Name: ");
		String player = sc.nextLine();
		
		GameConfig game = new GameConfig();
		game.showRules();
		
		
		int attempts = 0;
		
		boolean win = false;
		
		while(attempts < game.getMaxAttempts()){
			
			System.out.print("Enter your guess");
			//int guess = ValidationService.validateInput(sc.nextLine());
			
			String input = sc.nextLine();

            int guess;
            try {
                guess = ValidationService.validateInput(input);
            } catch (InvalidInputException e) {
                // Do not count invalid input as an attempt; just inform and continue
                System.out.println(e.getMessage());
                System.out.println(); // blank line for readability
                continue;
            }

			attempts++;
			
			
			String result = GuessValidator.validateGuess(guess, game.getTargetNumber());
			String hint = HintService.generateHint(game.getTargetNumber(), attempts);
			System.out.println(hint);
			System.out.println(result);
			
			if("correct".equals(result)){
				win = true;
				break;
			}
		}
		
		StorageService.saveResult(player, attempts, win);
		
		restart = GameController.restartGame(sc);
			
		}
		
		while(restart);
		
		
	}
}