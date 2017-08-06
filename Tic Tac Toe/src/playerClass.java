import java.util.Scanner;

public class playerClass 
{
	private String name;
	private String boardPiece;
	
	public playerClass(String name)
	{
		this.name = name;		
	}
	
	String getName()
	{
		return name;
	}
	 
	String getBoardPiece()
	{
		return boardPiece;
	}
	
	void setBoardPiece(String boardPiece)
	{
		this.boardPiece = boardPiece;
	}
	
	void makeMove(gameClass gameObject)
	{
		int row, col;
		Scanner userInput = new Scanner(System.in);
		System.out.println("Enter where you would like to place your board piece " + this.getName());
		System.out.print("Enter row: ");
		row = userInput.nextInt();
		row-=1;
		gameObject.setX(row);
		
		System.out.println();
		System.out.print("Enter col: ");
		col = userInput.nextInt();
		col-=1;
		gameObject.setY(col);
		System.out.println("Checking if placement is valid ....... ");
	}
}
