import java.util.Scanner;

public class main 
{
	public static void main(String[] args) 
	{
		String playerOneName;
		String playerTwoName;
		Scanner userInput = new Scanner(System.in); // User input object
		System.out.println("Enter Player 1 Name: ");
		playerOneName = userInput.nextLine();
		System.out.println("Enter Player 2 Name: ");
		playerTwoName = userInput.nextLine();
		
		playerClass player1 = new playerClass(playerOneName);
		playerClass player2 = new playerClass(playerTwoName);
		
		gameClass gameObject = new gameClass(player1, player2);
		gameObject.startGame();
	}

}
