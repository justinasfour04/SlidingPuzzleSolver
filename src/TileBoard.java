import java.util.*;

public class TileBoard
{
	//String representation of the solution board
	private static final String goalBoard = "123456780";
	
	//The dimensions of the tileBoard
	private static final int SIZE = 3;

	//String representation of a puzzle board
	private String myBoard;

	//String representation of the list of moves that generated this board
	private String myMoves = new String();
	
	//The 2-dimensional representation of the tile board
	private int[][] tileBoard = new int[SIZE][SIZE];

	/* You may add more attributes and methods as you see fit */

	public TileBoard(String board)
	{
		/* Your code goes here */
		this.myBoard = board;
		for (int row = 0; row < SIZE; row++) {
			tileBoard[0][row] = Character.getNumericValue(board.charAt(row));
			tileBoard[1][row] = Character.getNumericValue(board.charAt(row + SIZE));
			tileBoard[2][row] = Character.getNumericValue(board.charAt(row + 2*SIZE)); 
		}
	}

	/*
	 * Returns a list of boards that are one move away.  This list *DOES NOT* contain the
	 * previous board, as this would undo a moving we just made
	 */
	public static List<TileBoard> getNextBoards(TileBoard b)
	{
		/* Your code goes here */
		
		// Initializing the list, the zero finder and the TileBoards
		List<TileBoard> nextMoves = new LinkedList<TileBoard>();
		int[] zero = findZero(b);
		TileBoard nextBoard1 = new TileBoard(b.myBoard); 
		TileBoard nextBoard2 = new TileBoard(b.myBoard); 
		TileBoard nextBoard3 = new TileBoard(b.myBoard); 
		TileBoard nextBoard4 = new TileBoard(b.myBoard);

		// The switch statement takes in as parameter the location of zero tile
		// and then performs associated move to generate next board
		
		/*  Example of each part of switch statement
		 * 
		 *  This part of every switch sets the tileboard field of every successive board by performing the swap
		 * 	nextBoard_.tileBoard = b.swap(_, _, _, _); 
		 * 
		 *  This part sets the string representation of the tileboard
		 *	nextBoard_.myBoard = new String(threeToOne(nextBoard_.tileBoard));
		 *	
		 *  This part updates the moveslist of every successive board
		 *	nextBoard_.myMoves = b.myMoves + "_"; 
		 *	
		 *	This part adds the tileboard into the list
		 *	nextMoves.add(nextBoard_);  
		 */
		
		
		switch (Arrays.toString(zero)) {
		case "[0, 0]":
			nextBoard1.tileBoard = b.swap(0, 0, 0, 1);
			nextBoard1.myBoard = new String(toString(nextBoard1.tileBoard));
			nextBoard1.myMoves = b.myMoves + "R";
			nextMoves.add(nextBoard1); //right move
			
			nextBoard2.tileBoard = b.swap(0, 0, 1, 0);
			nextBoard2.myBoard = new String(toString(nextBoard2.tileBoard));
			nextBoard2.myMoves = b.myMoves + "D";
			nextMoves.add(nextBoard2); //down move
			break;
			
		case "[0, 1]":
			nextBoard1.tileBoard = b.swap(0, 1, 0, 0);
			nextBoard1.myBoard = new String(toString(nextBoard1.tileBoard));
			nextBoard1.myMoves = b.myMoves + "L";
			nextMoves.add(nextBoard1); //left move
			
			nextBoard2.tileBoard = b.swap(0, 1, 1, 1);
			nextBoard2.myBoard = new String(toString(nextBoard2.tileBoard));
			nextBoard2.myMoves = b.myMoves + "D";
			nextMoves.add(nextBoard2); //down move
			
			nextBoard3.tileBoard = b.swap(0, 1, 0, 2);
			nextBoard3.myBoard = new String(toString(nextBoard3.tileBoard));
			nextBoard3.myMoves = b.myMoves + "R";
			nextMoves.add(nextBoard3); //right move
			break;
			
		case "[0, 2]":
			nextBoard1.tileBoard = b.swap(0, 2, 0, 1);
			nextBoard1.myBoard = new String(toString(nextBoard1.tileBoard));
			nextBoard1.myMoves = b.myMoves + "L";
			nextMoves.add(nextBoard1); //left move
			
			nextBoard2.tileBoard = b.swap(0, 2, 1, 2);
			nextBoard2.myBoard = new String(toString(nextBoard2.tileBoard));
			nextBoard2.myMoves = b.myMoves + "R";
			nextMoves.add(nextBoard2); //right move
			break;
			
		case "[1, 0]":
			nextBoard1.tileBoard = b.swap(1, 0, 0, 0);
			nextBoard1.myBoard = new String(toString(nextBoard1.tileBoard));
			nextBoard1.myMoves = b.myMoves + "U";
			nextMoves.add(nextBoard1); //up move
			
			nextBoard2.tileBoard = b.swap(1, 0, 1, 1);
			nextBoard2.myBoard = new String(toString(nextBoard2.tileBoard));
			nextBoard2.myMoves = b.myMoves + "R";
			nextMoves.add(nextBoard2); //right move
			
			nextBoard3.tileBoard = b.swap(1, 0, 2, 0);
			nextBoard3.myBoard = new String(toString(nextBoard3.tileBoard));
			nextBoard3.myMoves = b.myMoves + "D";
			nextMoves.add(nextBoard3); //down move
			break;
			
		case "[1, 1]":
			nextBoard1.tileBoard = b.swap(1, 1, 1, 0);
			nextBoard1.myBoard = new String(toString(nextBoard1.tileBoard));
			nextBoard1.myMoves = b.myMoves + "L";
			nextMoves.add(nextBoard1); //left move
			
			nextBoard2.tileBoard = b.swap(1, 1, 0, 1);
			nextBoard2.myBoard = new String(toString(nextBoard2.tileBoard));
			nextBoard2.myMoves = b.myMoves + "U";
			nextMoves.add(nextBoard2); //up move
			
			nextBoard3.tileBoard = b.swap(1, 1, 1, 2);
			nextBoard3.myBoard = new String(toString(nextBoard3.tileBoard));
			nextBoard3.myMoves = b.myMoves + "R";
			nextMoves.add(nextBoard3); //right move
			
			nextBoard4.tileBoard = b.swap(1, 1, 2, 1);
			nextBoard4.myBoard = new String(toString(nextBoard4.tileBoard));
			nextBoard4.myMoves = b.myMoves + "D";
			nextMoves.add(nextBoard4); //down move
			break;
			
		case "[1, 2]":
			nextBoard1.tileBoard = b.swap(1, 2, 0, 2);
			nextBoard1.myBoard = new String(toString(nextBoard1.tileBoard));
			nextBoard1.myMoves = b.myMoves + "U";
			nextMoves.add(nextBoard1); //up move
			
			nextBoard2.tileBoard = b.swap(1, 2, 1, 1);
			nextBoard2.myBoard = new String(toString(nextBoard2.tileBoard));
			nextBoard2.myMoves = b.myMoves + "L";
			nextMoves.add(nextBoard2); //left move
			
			nextBoard3.tileBoard = b.swap(1, 2, 2, 2);
			nextBoard3.myBoard = new String(toString(nextBoard3.tileBoard));
			nextBoard3.myMoves = b.myMoves + "D";
			nextMoves.add(nextBoard3); //down move
			break;
			
		case "[2, 0]":
			nextBoard1.tileBoard = b.swap(2, 0, 1, 0);
			nextBoard1.myBoard = new String(toString(nextBoard1.tileBoard));
			nextBoard1.myMoves = b.myMoves + "U";
			nextMoves.add(nextBoard1); //up move
			
			nextBoard2.tileBoard = b.swap(2, 0, 2, 1);
			nextBoard2.myBoard = new String(toString(nextBoard2.tileBoard));
			nextBoard2.myMoves = b.myMoves + "R";
			nextMoves.add(nextBoard2); //right move
			break;
			
		case "[2, 1]":
			nextBoard1.tileBoard = b.swap(2, 1, 2, 0);
			nextBoard1.myBoard = new String(toString(nextBoard1.tileBoard));
			nextBoard1.myMoves = b.myMoves + "L";
			nextMoves.add(nextBoard1); //left move
			
			nextBoard2.tileBoard = b.swap(2, 1, 1, 1);
			nextBoard2.myBoard = new String(toString(nextBoard2.tileBoard));
			nextBoard2.myMoves = b.myMoves + "U";
			nextMoves.add(nextBoard2); //up move
			
			nextBoard3.tileBoard =  b.swap(2, 1, 2, 2);
			nextBoard3.myBoard = new String(toString(nextBoard3.tileBoard));
			nextBoard3.myMoves = b.myMoves + "R";
			nextMoves.add(nextBoard3); //right move
			break;
			
		case "[2, 2]":
			nextBoard1.tileBoard = b.swap(2, 2, 2, 1);
			nextBoard1.myBoard = new String(toString(nextBoard1.tileBoard));
			nextBoard1.myMoves = b.myMoves + "L";
			nextMoves.add(nextBoard1); //left move
			
			nextBoard2.tileBoard = b.swap(2, 2, 1, 2);
			nextBoard2.myBoard = new String(toString(nextBoard2.tileBoard));
			nextBoard2.myMoves = b.myMoves + "U";
			nextMoves.add(nextBoard2); //up move
			break;
		}
		
		if (nextMoves.contains(b));
			nextMoves.remove(b);

		return nextMoves;
	}

	/*
	 * Returns the number of moves from the initial board
	 */
	public static int getNumMoves(TileBoard b)
	{
		return b.myMoves.length();
	}

	/*
	 * Evaluates the given board using the Manhattan distance heuristic.
	 */
	public static int calcManhattanDistance(TileBoard b)
	{
		/* Your code goes here */
		int manhattanDistance = 0;
		for (int x = 0; x < SIZE; x++) { // Traversing rows
			for (int y = 0; y < SIZE; y++) { // Traversing columns 
				int value = b.tileBoard[x][y]; // Elements in the tile board
				if (b.tileBoard[x][y] != 0) { // Making sure not to look at the zero tile
					int targetX = (value - 1) / SIZE; // Find the x-coordinate target location(row)
					int targetY = (value - 1) % SIZE; // Find the y-coordinate target location(column)
					int dx = x - targetX; // x-coordinate distance to expected x
					int dy = y - targetY; // y-coordinate distance to expected y
					manhattanDistance += Math.abs(dx) + Math.abs(dy); // The sum of all the moves to needed to get the Manhattan distance
				}
			}
		}
		return manhattanDistance;
	}
	
	/*
	 * Finds the zero within the tileBoard
	 */
	public static int[] findZero(TileBoard b)
	{
		int[] zeroIndex = new int[2];
		for (int x = 0; x < SIZE; x++) { // Traversing rows
			for (int y = 0; y < SIZE; y++) { // Traversing columns 
				int value = b.tileBoard[x][y];
				if (value == 0) {
					zeroIndex[0] = x; //x-coordinate of zero tile 
					zeroIndex[1] = y; //y-coordinate of zero tile
				}
			}
		}
		return zeroIndex;
	}
	
	/*
	 * Swaps entries within the (i,j) entry with (k,l) entry
	 */
	private int[][] swap(int i, int j, int k, int l) 
	{
		// Initializes a new 2d-array for temporary storage to perform the swap
		int[][] swap = new int[SIZE][SIZE];
		
		// Copies all the object information into the swap array to make the copy
		for (int n = 0; n < swap.length; n++) {
			for (int m = 0; m < swap[0].length; m++) {
				swap[n][m] = this.tileBoard[n][m];
			}
		}
		
		// Performs the swap of the zero tile with the adjacent tile
		int tmp = this.tileBoard[i][j];
		swap[i][j] = this.tileBoard[k][l];
		swap[k][l] = tmp;
		
		return swap;
	}
	
    /*
     * Converts the 3x3 board representation back to a string
     */
	public static char[] toString(int[][] b) {
		// sets the size of the 1d array to the product of the number of rows
		// and columns of the 3x3
		int size = b.length * b[0].length;
		// Initializes the new 1d array
		char[] c = new char[size];

		// loops through all locations of the new 1d array
		int i = 0;
		while (i < size) {
			// takes the first row and puts the values in the 1d array
			int xInd1 = 0;
			while (i < 3) {
				c[i] = (char) b[xInd1][0];
				xInd1++;
				i++;
			}
			// takes the second row and puts the values in the 1d array
			int xInd2 = 0;
			while (i > 2 && i < 6) {
				c[i] = (char) b[xInd2][1];
				xInd2++;
				i++;
			}
			// takes the third row and puts the values in the 1d array
			int xInd3 = 0;
			while (i > 5 && i < 9) {
				c[i] = (char) b[xInd3][2];
				xInd3++;
				i++;
			}
		}
		return c;
	}
	
	/*
	 * Prints the 2-dimensional board
	 */
	public static void print(TileBoard b) 
	{
		
		for (int i = 0; i < SIZE; i++) {
			for (int j = 0; j < SIZE; j++) {
				System.out.print(b.tileBoard[i][j]);
				if (j == 2)
					System.out.println();
			}
		}
		System.out.println();
	}
	
	/*
	 * Checks to see is the current board is equal to the goalBoard
	 */
	public boolean isGoal() {
		for (int i = 0; i < SIZE; ++i) { // traversing rows
			for (int j = 0; j < SIZE; ++j) { // traversing columns
				if (i * j == Math.pow(SIZE - 1, 2)) { // Checking entry at (2,2)
					if (!(this.tileBoard[i][j] == 0)) // Checking to see whether it is zero
						return false;
				} else if (this.tileBoard[i][j] != (i * SIZE) + (j + 1)) // Checks to see if all entries are in place
					return false;
			}
		}
		return true;
	}
	
	/*
	 * All the getters and setters below this point --
	 */

	public static String getGoalboard() {
		return goalBoard;
	}
	
	public static void println(Object stuff){
		System.out.println(stuff);
	}

	public String getMyMoves() {
		return myMoves;
	}

	public void setMyMoves(String myMoves) {
		this.myMoves = myMoves;
	}

	public static int getSize() {
		return SIZE;
	}

	public String getMyBoard() {
		return myBoard;
	}

	public int[][] getTileBoard() {
		return tileBoard;
	}

	public void setMyBoard(String myBoard) {
		this.myBoard = myBoard;
	}

	public void setTileBoard(int[][] tileBoard) {
		this.tileBoard = tileBoard;
	}
}
