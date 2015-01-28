public class SlidingSolverDriver
{

	public static void main(String[] args)
	{
		String puzzle = "123456780";
		SlidingSolution solution = new SlidingSolver(puzzle).solvePuzzleAStar();
		System.out.println(solution.getMoves());
		System.out.println(solution.getMoves().length());
	}

}








