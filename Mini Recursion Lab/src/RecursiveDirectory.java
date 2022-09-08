public class RecursiveDirectory {
	
	public static class PartialSolution {
		
		public static final int ACCEPT = 1;
		public static final int ABANDON = 2;
		public static final int CONTINUE = 3;
		
		private File fs;
		public String regex;
		public String matches;

		/**
		 * Constructs a partial solution of a given FileSystem Node.
		 * 
		 * @param fs  FileSystem Node
		 * @param regex Regular expression
		 * @param matches Actual matches
		 */
		public PartialSolution(File fs, String regex, String matches) {
			this.fs = fs;
			this.regex = regex;
			this.matches = matches;
		}

		/**
		 * EXERCISE 1A Examines a partial solution. In this function you must identify
		 * the three different possibility where the given FileSystem Node could have, it
		 * means; is a Directory, regex Match or regex not Match and determine whether 
		 * to CONTINUE, ACCEPT, ABANDON. Like the NQueens Problem (Section 13.6).
		 * 
		 * @return one of ACCEPT, ABANDON, CONTINUE
		 */
		public int examine() {
			// Add your code here.
			return 0; // Dummy Return
		}

		/**
		 * EXERCISE 1B Yields all extensions of this partial solution. To keep walking
		 * through the FileSystem, you must to go every File child's to span a new
		 * partial solution.
		 * 
		 * @return an array of PartialSolution that extend this solution.
		 */
		public PartialSolution[] extend() {
			// Add your code here.
			return null; // Dummy Return
		}
		

		/**
		 * The method is a straightforward translation of the pseudocode 
		 * for backtracking. Note how there is nothing specific about 
		 * the FileSystem problem in this method, it works for any 
		 * partial solution with an examine and extend method
		 * 
		 * @param sol a Partial Solution
		 */
		public static void solve(PartialSolution sol) {
			int exam = sol.examine();
			if (exam == PartialSolution.ACCEPT) {
				sol.addMatches(sol.fs.toString() + "\n");
			} else if (exam == PartialSolution.CONTINUE) {
				for (PartialSolution p : sol.extend()) {
					sol.toggle();
					solve(p);
					sol.addMatches(p.getMatches());
					sol.toggle();
				}
			}
		}

		/**
		 * Toggle mark the partial solution in the maze
		 */
		public void toggle() {
			fs.setFlag(!fs.getFlag());
		}

		public String getMatches() {
			return matches;
		}

		public void addMatches(String matches) {
			this.matches += matches;
		}
	}
}
