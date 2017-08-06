import java.util.Scanner;


public class gameClass 
{
	final int ROWS = 3;
	final int COLS = 3;
	
	String squareBoard[][] = new String[ROWS][COLS];
	
	private int xPosition;
	private int yPosition;
	
	Boolean whoseTurn;
	
	playerClass p1, p2; // Two player objects that will communicate and coordinate play moves
	
	public gameClass(playerClass p1, playerClass p2)
	{
		System.out.println("Tic tac toe game created");
		this.p1 = p1;
		this.p2 = p2;
		whoseTurn = true;
		p1.setBoardPiece("X ");
		p2.setBoardPiece("O ");
	}
	
	public void setX(int xPos)
	{
		this.xPosition = xPos;
	}
	
	public void setY(int yPos)
	{
		this.yPosition = yPos;
	}
	
	public int getX()
	{
		return xPosition;
	}
	
	public int getY()
	{
		return yPosition;
	}
	
	public void startGame()
	{
		intializeBoard();
		introducePlayers();
		printBoard();
		printInstructions();
		playerTurn(p1);
	}
	
	public void printBoard()
	{
		System.out.println("----------------");
		for(int i = 0; i < ROWS; i++)
		{
			System.out.print("| ");
			for(int j = 0; j < COLS; j++)
			{
				System.out.print(squareBoard[i][j]);
				System.out.print(" | ");
			}
			System.out.println();;
			System.out.println("----------------");
		}
	}
	
	public void intializeBoard()
	{
		for(int i = 0; i < ROWS; i++)
		{
			for(int j = 0; j < COLS; j++)
			{
				squareBoard[i][j] = "- ";
			}
		}
	}
	
	public void introducePlayers()
	{
		System.out.println("Welcome Player 1: " + p1.getName());
		System.out.println("Welcome Player 2: " + p2.getName());
		System.out.println("Player 1 your board piece is " + p1.getBoardPiece());
		System.out.println("Player 2 your board piece is " + p2.getBoardPiece());
	}
	
	public void printInstructions()
	{
		System.out.println("To play a board piece enter row and col position corresponding to where you would like the piece to be placed");
	}
	
	public boolean isValidMove(playerClass player, gameClass gameObject)
	{
		if(gameObject.getX() < 3)
		{
			if(gameObject.getY() < 3)
			{
				if(gameObject.squareBoard[gameObject.getX()][gameObject.getY()] == "- ")
				{
					System.out.println("Placement is allowed ..... ");
					gameObject.squareBoard[gameObject.getX()][gameObject.getY()] = player.getBoardPiece();
					printBoard();
					return true;
				}	
			}
		}
		System.out.println("Placement is not allowed ....... ");
		printBoard();
		return false;
	}
	
	public boolean hasWon(String boardPiece)
	{
		System.out.println("Checking if someone has won .... ");
		if(squareBoard[0][0] == boardPiece && squareBoard[0][1] == boardPiece && squareBoard[0][2] == boardPiece)
		{
			return true;
		}
		else if(squareBoard[1][0] == boardPiece && squareBoard[1][1] == boardPiece && squareBoard[1][2] == boardPiece)
		{
			return true;
		}
		else if(squareBoard[2][0] == boardPiece && squareBoard[2][1] == boardPiece && squareBoard[2][2] == boardPiece)
		{
			return true;
		}
		else if(squareBoard[0][0] == boardPiece && squareBoard[1][0] == boardPiece && squareBoard[2][0] == boardPiece)
		{
			return true;
		}
		else if(squareBoard[0][1] == boardPiece && squareBoard[1][1] == boardPiece && squareBoard[2][1] == boardPiece)
		{
			return true;
		}
		else if(squareBoard[0][2] == boardPiece && squareBoard[1][2] == boardPiece && squareBoard[2][2] == boardPiece)
		{
			return true;
		}
		else if(squareBoard[0][0] == boardPiece && squareBoard[1][1] == boardPiece && squareBoard[2][2] == boardPiece)
		{
			return true;
		}
		else if(squareBoard[0][2] == boardPiece && squareBoard[1][1] == boardPiece && squareBoard[2][0] == boardPiece)
		{
			return true;
		}
		System.out.println("No one has won yet .... ");
		return false;
	}
	
	// Draw function basically checks if there are no empty board spaces
	public boolean isDraw()
	{
		System.out.println("Checking for a draw .... ");
		for(int i = 0; i < ROWS; i++)
		{
			for(int j = 0; j < COLS; j++)
			{
				if(squareBoard[i][j] == "- ")
				{
					System.out.println("No draw ..... ");
					return false;
				}
			}
		}
		return true;	
	}
	
	// End game function if one player wins
	public void endGame(playerClass player)
	{
		String decision;
		Scanner in = new Scanner(System.in);
		System.out.println(player.getName() + " has won!!!");
		System.out.println("Play Again ?");
		decision = in.nextLine();
		if(decision.equals("yes"))
		{
			startGame();
		}
		else
		{
			System.exit(1);
		}
	}
	
	// End game function if both players draw
	public void endGame()
	{
		Scanner in = new Scanner(System.in);
		String decision;
		System.out.println("Both players draw ... ");
		System.out.println("Play Again ?");
		decision = in.nextLine();
		if(decision.equals("yes"))
		{
			startGame();
		}
		else
		{
			System.exit(1);
		}
	}
	
	// Main game function regulates the turns and checks whether win or draw conditions are met
	public void playerTurn(playerClass playerTurn)
	{
		boolean changeTurn;
		boolean playerWon;
		boolean playersDraw;
		
		do
		{
			playerTurn.makeMove(this);
			changeTurn = isValidMove(playerTurn, this);
		}while(changeTurn != true);
	
		playerWon = hasWon(playerTurn.getBoardPiece());
		
		if(playerWon)
		{
			endGame(playerTurn);
		}
		
		playersDraw = isDraw();
		
		if(playersDraw)
		{
			endGame();
		}
		
		whoseTurn = !whoseTurn;
		
		if(whoseTurn)
		{
			playerTurn(p1);
		}
		else
		{
			playerTurn(p2);
		}
	}
}
