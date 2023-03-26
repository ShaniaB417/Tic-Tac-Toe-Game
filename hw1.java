/* ////////////////////////////////////////////////////////////////////
//
//   Assignment: Homework 1 - Tic Tac Toe
//   Program: 
//    
//   Author: Shania Brown 
//   Date:   6/16/2022
//
//   Input:  the user will input a number 1-9 with will be were the X will be placed on the board 
//   Output: board with X and O indicating player 1 (user 1 and player 2 (computer) 
//    
//
// ////////////////////////////////////////////////////////////////// */



import java.util.Random;
import java.util.Scanner;

public class hw1 {							

	public static void main(String[] args) {
		
		System.out.println("Welcome to Tic Tac Toe!");
		System.out.println("You are Player 1 and the computer is player 2");							//welcome message explaining instructions to the user as well as how the game board will look
		System.out.println("To play pick a number 1-9, this will be your place on the board.");
		System.out.println("Get three X in a row to win. The board will look like this:  ");
		System.out.println("1|2|3 \n"
							+ "-----\n"
							+ "4|5|6 \n"
							+ "-----\n"
							+ "7|8|9");
		
		
		
		
		
		Scanner scanner = new Scanner(System.in);
		char[][] board = {{' ', ' ', ' '},								 								 //grid for the game using an array 
		      {' ', ' ', ' '},
		      {' ', ' ', ' '}};
		  theBoard(board);
		while (true) {																					// this loop will keep the game going until the computer or the user wins 
		 playerTurn1 (board, scanner);
		if (gameOver(board)){
		break;
		}
		theBoard(board);
		computerTurn(board);
		if (gameOver(board)){
		break;
		}
		theBoard(board);
		}
		scanner.close();
		}
		 
		 
		public static boolean gameOver(char[][] board) {
		if (playerWins(board, 'X')) { 																	// checks if player 1 or player 2 is the winner, if there is a tie then then "the game ended in a tie" message will display
		theBoard(board);
		System.out.println("Player 1 wins!");
		return true;
		}
		if (playerWins (board, 'O')) {
		theBoard(board);
		System.out.println(" player 2 wins!");
		return true;
		}
		for (int i = 0; i < board.length; i++) {
		for (int j = 0; j < board[i].length; j++) {
		if (board[i][j] == ' ') {
		return false;
		}
		}
		}
		theBoard(board);
		System.out.println("The game ended in a tie!");
		return true;
		}
		 
		 
		public static boolean playerWins(char[][] board, char symbol) {									// checks the result to see the winner based on return X or return O 
		if ((board[0][0] == symbol && board [0][1] == symbol && board [0][2] == symbol) ||
		(board[1][0] == symbol && board [1][1] == symbol && board [1][2] == symbol) ||
		(board[2][0] == symbol && board [2][1] == symbol && board [2][2] == symbol) ||
		(board[0][0] == symbol && board [1][0] == symbol && board [2][0] == symbol) ||
		(board[0][1] == symbol && board [1][1] == symbol && board [2][1] == symbol) ||
		(board[0][2] == symbol && board [1][2] == symbol && board [2][2] == symbol) ||
		(board[0][0] == symbol && board [1][1] == symbol && board [2][2] == symbol) ||
		(board[0][2] == symbol && board [1][1] == symbol && board [2][0] == symbol) ) {
		return true;
		}
		return false;
		}
		 
		public static void computerTurn(char[][] board) { 												// this is the computers move, the computer is considered player 2 and will be O on the game board 
			Random rand = new Random();
			int computerMove;
			while (true) {
			computerMove = rand.nextInt(9) + 1;
			if (correctMove(board, Integer.toString(computerMove))) {
			break;
			}
			}
			System.out.println("Computer choose " + computerMove);
			placeMove(board, Integer.toString(computerMove), 'O');
			}
			 
			 
			public static boolean correctMove (char[][] board, String position) {
			switch(position) {																			//check if the user has entered a valid number for their move, the correct move will be a number 1-9 because there are 9 possible spaces on the game board
			case "1":
			return (board[0][0] == ' ');
			case "2":
			return (board[0][1] == ' ');
			case "3":
			return (board[0][2] == ' ');
			case "4":
			return (board[1][0] == ' ');
			case "5":
			return (board[1][1] == ' ');
			case "6":
			return (board[1][2] == ' ');
			case "7":
			return (board[2][0] == ' ');
			case "8":
			return (board[2][1] == ' ');
			case "9":
			return (board[2][2] == ' ');
			default:
			return false;
			}
			}
			 
			public static void  playerTurn1 (char[][] board, Scanner scanner) {
			String userInput;
			while (true) {
			System.out.println("player 1's move please enter a number");							//ask the user to enter a number and check if it is a correct move, if not tell the user that it is incorrect and to pick a new number 
			userInput = scanner.nextLine();
			if (correctMove(board, userInput)){
			break;
			} else {
			System.out.println(userInput + "this is not a correct move.");
			}
			}
			placeMove(board, userInput, 'X');														// if the move is correct place an X 
			}	
			 
		

		 
		 
		public static void placeMove(char[][] board, String position, char symbol) {
		switch(position) {																			// Corresponds to where the user places their game piece (x) on the game board 
		case "1":
		board[0][0] = symbol;
		break;
		case "2":
		board[0][1] = symbol;
		break;
		case "3":
		board[0][2] = symbol;
		break;
		case "4":
		board[1][0] = symbol;
		break;
		case "5":
		board[1][1] = symbol;
		break;
		case "6":
		board[1][2] = symbol;
		break;
		case "7":
		board[2][0] = symbol;
		break;
		case "8":
		board[2][1] = symbol;
		break;
		case "9":
		board[2][2] = symbol;
		break;
		default:
		System.out.println(":(");
		}
		}
		 
		public static void theBoard(char[][] board) {												// 3x3 grid for game 
		System.out.print((board[0][0]));
		System.out.print("|");
		System.out.print((board[0][1]));
		System.out.print("|");
		System.out.println((board[0][2]));
		System.out.println("-----");
		System.out.print((board[1][0]));
		System.out.print("|");
		System.out.print((board[1][1]));
		System.out.print("|");
		System.out.println((board[1][2]));
		System.out.println("-----");
		System.out.print((board[2][0]));
		System.out.print("|");
		System.out.print((board[2][1]));
		System.out.print("|");
		System.out.println((board[2][2]));
		}

					
		  
	  
		 
}
	    
