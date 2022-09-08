/*
 * LogisticGrowth class that calculates 
 * the growth problem of mice with 
 * a logistic growth model.
 * Remember to add your name and repo.
 * Name: Caballero Diaz, Sebastian J.
 * Repo: https://github.com/uprm-ciic4010-s20/lab-8-recursion-lab-sebastianjc2
 */
public class LogisticGrowth {

	/* 
	 * EXERCISE 1
     * Finish implementing the recursive function
     * that determines the growth value of mice population.
     * The formula is provided online (see problem description).
     *
     */
	public static double miceGrowth(int n, double rate, double K, double p0) {
		if (n == 0) {
            return p0;
        }
		if(p0==0) {
			return 0.0;
		}
		if(K == 0) {
			return 0.0;
		}
		
        // Add the step function, recursive call below.
        // Hint:  Just a few lines of code are needed.
        // ADD YOUR CODE HERE
        // Keep it simple!
		double pop = miceGrowth(n-1, rate, K, p0);
        return (pop  +  (rate * (1 - (pop/K))) * pop); //Dummy return
	}
}
