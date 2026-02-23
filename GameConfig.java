import java.util.Random;

class GameConfig{
	private  final int MIN = 1;
	private  final int MAX = 100;
	private  final int MAX_ATTEMPTS = 5;
	private  final int MAX_HINTS = 3;
	
	int target;
	
	public GameConfig(){
		Random random = new Random();
		this.target = random.nextInt(MAX - MIN + 1) + MIN;
	}
	
	public int getTargetNumber(){
		return target;
	}
	
	public int getMaxAttempts(){
		return MAX_ATTEMPTS;
	}
	public int getMaxHints(){
		return MAX_HINTS;
	}
	
	public void showRules(){
		System.out.println("Guess a number between " + MIN + "and" + MAX);
		System.out.println("You have " + MAX_ATTEMPTS + " Attempts.");
		System.out.println("Hints will be provided after wrong guess.\n");
	}
}