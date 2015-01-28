import java.util.*;

public class SlidingSolver {
	private static final int MAX_DISTANCE = 100;
	
	private TileBoard initialBoard;

	/* You may add instance and class variables and methods as you see fit */

	/*
	 * Constructs a SlidingSolver with the given input board.
	 */
	public SlidingSolver(String initialBoard) {
		/* Your code here */
		this.initialBoard = new TileBoard(initialBoard);
	}

	/*
	 * Solves the puzzle by performing an A* search over the puzzle space.
	 */
	public SlidingSolution solvePuzzleAStar() {
		/* Your code here */
		TileBoardComparator comparator = new TileBoardComparator();
		
		PriorityQueue<TileBoard> OPEN = new PriorityQueue<TileBoard>(10, comparator);
		PriorityQueue<TileBoard> CLOSED = new PriorityQueue<TileBoard>(10, comparator);
		
		OPEN.add(this.initialBoard);
		
		for (int i = 0; i < MAX_DISTANCE; i++) {

			TileBoard current = OPEN.remove();
			OPEN.addAll(TileBoard.getNextBoards(current));
			CLOSED.add(current);
			TileBoard closed = CLOSED.remove();

			if (current.isGoal()) {
				SlidingSolution goal = new SlidingSolution(closed.getMyMoves(), closed.getMyMoves().length());
				return goal;
			}
		}
		return SlidingSolution.NO_SOLUTION;
	}

	/*
	 * Evaluates the given board.
	 */
	private int evaluateHeuristic(TileBoard p) {
		return TileBoard.getNumMoves(p) + TileBoard.calcManhattanDistance(p);
	}

	/*
	 * Comparator used to order the boards based on their heuristic
	 */
	class TileBoardComparator implements Comparator<TileBoard> {
		public int compare(TileBoard a, TileBoard b) {
			/* Your code here */
			return Integer.valueOf(evaluateHeuristic(a)).compareTo(Integer.valueOf(evaluateHeuristic(b)));
		}
	}
}
