public class BotMaze {

	public static class PartialSolution {

		public static final char EXIT = 'X';
		public static final char WALL = '#';
		public static final char PATH = '*';
		public static final char FREE = ' ';
		public static final char ESCP = 'E';

		public static final int ACCEPT = 1;
		public static final int ABANDON = 2;
		public static final int CONTINUE = 3;

		private int posX;
		private int posY;
		private Maze maze;

		/**
		 * Constructs a partial solution of a given position and Maze.
		 * 
		 * @param posX  The x position in the maze
		 * @param posY  The y position in the maze
		 * @param maze  The Maze
		 */
		public PartialSolution(int posX, int posY, Maze maze) {
			this.posX = posX;
			this.posY = posY;
			this.maze = maze;
		}

		/**
		 * EXERCISE 1A Examines a partial solution. In this function you must identify
		 * the three different possibility where the given position (x,y) could have, it
		 * means; WALL, PATH or EXIT and determine whether to ACCEPT, ABANDON, CONTINUE.
		 * 
		 * @return one of ACCEPT, ABANDON, CONTINUE
		 */
		public int examine() {
			// Add your code here.
			return 0; // Dummy Return
		}

		/**
		 * EXERCISE 1B Yields all extensions of this partial solution. To keep walking
		 * through the maze, you must to go right, left, up or down to span a new
		 * partial solution.
		 * 
		 * @return an array of PartialSolution that extend this solution (remember the 4
		 *         different position).
		 */
		public PartialSolution[] extend() {
			// Add your code here.
			return null; // Dummy Return
		}
		

		/**
		 * The method is a straightforward translation of the pseudocode 
		 * for backtracking. Note how there is nothing specific about 
		 * the maze problem in this method, it works for any 
		 * partial solution with an examine and extend method
		 * 
		 * @param sol a Partial Solution
		 */
		public static void solve(PartialSolution sol) {
			int exam = sol.examine();
			if (exam == PartialSolution.ACCEPT) {
				sol.save();
			} else if (exam == PartialSolution.CONTINUE) {
				for (PartialSolution p : sol.extend()) {
					sol.mark();
					solve(p);
					sol.free();
				}
			}

		}

		/**
		 * Unmark the partial solution in the maze
		 */
		public void free() {
			if (this.maze.getPosition(this.posX, this.posY) == PATH) {
				this.maze.setPosition(this.posX, this.posY, FREE);
			}
		}

		/**
		 * Mark the partial solution in the maze
		 */
		public void mark() {
			if (this.maze.getPosition(this.posX, this.posY) == FREE) {
				this.maze.setPosition(this.posX, this.posY, PATH);
			}
		}
		
		/**
		 * Save the actual state in the maze and print this
		 */
		public void save() {
			// System.out.println(toString());
			this.maze.setPosition(0, 0, ESCP);
			this.maze.save();
		}

		public String toString() {
			return this.maze.toString();
		}
	}

	/**
	 * A Maze in the Maze Problem
	 *
	 */
	public static class Maze {
		private int numrow;
		private int numcolumn;
		private char[] maze;

		/**
		 * Constructs a Maze at a given start position.
		 * 
		 * @param r the Num of rows
		 * @param c the Num of columns
		 * @param m the Maze input string
		 */
		public Maze(int r, int c, char[] m) {

			this.numrow = r;
			this.numcolumn = c;
			this.maze = new char[this.numcolumn * this.numrow];

			for (int y = 0; y < this.numrow; y++) {
				for (int x = 0; x < this.numcolumn; x++) {
					this.maze[x + y * this.numcolumn] = m[x + y * this.numcolumn];
				}
			}
		}

		public void setPosition(int x, int y, char mark) {
			maze[x + y * this.numcolumn] = mark;
		}

		public char getPosition(int x, int y) {
			return maze[x + y * this.numcolumn];
		}

		public void save() {
			for (int y = 0; y < this.numrow; y++) {
				for (int x = 0; x < this.numcolumn; x++) {
					if (this.maze[x + y * this.numcolumn] == '*') {
						this.maze[x + y * this.numcolumn] = '#';
					}
				}
			}
		}

		public String toString() {
			String output = "";
			for (int x = 0; x < this.numrow; x++) {
				for (int y = 0; y < this.numcolumn; y++) {
					output += maze[y + x * this.numcolumn] + " ";
				}
				output += "\n";
			}
			return output;
		}
	}
}
