/*
 * BiologicalSequences class that solve 
 * Similarity sequence problem.
 * Remember to add your name and repo.
 * Name: LastNames, First Name
 * Repo:
 */
public class BiologicalSequences {
	
	/* EXERCISE 2
	 *  implement the recursive function to find 
	 *  the longest common subsequence of two DNASequence. 
	 *  The formula is provided online (see problem description).
	 * 
	 */
	public static DNASequence longestCommonSubsequence(DNASequence a, DNASequence b) {
		DNASequence result = null;
		int m = a.getSize() - 1;
		int n = b.getSize() - 1;

		if (m < 0 || n < 0) {
			result = new DNASequence("");

		} else if (a.getSubsequence(m).equals(b.getSubsequence(n))) {
			// If the above statement is true, a[m] == b[n], what should
		    // the code do?  Add the missing line of code.
			// ADD YOUR CODE HERE
			result = longestCommonSubsequence(a.getSubsequence(0, m), b.getSubsequence(0, n)).append(a.getSubsequence(m));
			
		} else {
			// If a[m] != b[n] then you need to assign the corresponding
	        // longest common subsequence to variables first and second.
	        // Replace the right hand side of the following two statements
			DNASequence first = new DNASequence(longestCommonSubsequence(a, b.getSubsequence(0,n)).toString()); // Dummy declaration
			DNASequence second = new DNASequence(longestCommonSubsequence(a.getSubsequence(0,m), b).toString()); // Dummy declaration
			if (first.getSize() > second.getSize()) {
				result = first;
			} else {
				result = second;
			}
		}
		return result;
	}

	public static class DNASequence {
		int size;
		String data;

		public DNASequence(String data) {
			this.size = data.length();
			this.data = data.toUpperCase();
		}

		public DNASequence(int size, String data) {
			this.size = size;
			this.data = data.toUpperCase();
		}

		public String getData() {
			return data;
		}

		public int getSize() {
			return size;
		}

		public DNASequence getSubsequence(int beginIndex) {
			return new DNASequence(data.substring(beginIndex));
		}

		public DNASequence getSubsequence(int beginIndex, int endIndex) {
			return new DNASequence(data.substring(beginIndex, endIndex));
		}

		public void setData(String data) {
			this.size = data.length();
			this.data = data.toUpperCase();
		}

		public void setSize(int size) {
			this.size = size;
		}

		public DNASequence append(DNASequence other) {
			return new DNASequence(this.getData() + other.getData());
		}

		@Override
		public boolean equals(Object obj) {
			if (obj instanceof DNASequence) {
				return this.getData().equals(((DNASequence) obj).getData());
			}
			return false;
		}

		@Override
		public String toString() {
			return data.toUpperCase();
		}
	}
}
