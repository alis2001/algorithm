import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdRandom;
import java.util.Arrays;
public class Rolls
{
    public static void main(String[] args)
    {
        int T = Integer.parseInt(args[0]); // Number of rolls (e.g., 100,000)
        int SIDES = 6;
        
        // STEP 1: Create the array container for 7 counters (indices 0 to 6)
        Counter[] rolls = new Counter[SIDES+1];
        
        // STEP 2: Instantiate a new Counter object for each side (1 through 6)
        for (int i = 1; i <= SIDES; i++)
            rolls[i] = new Counter(i + "'s");
        
        // Simulation Loop: Roll the die T times
        for (int t = 0; t < T; t++)
        {
            int result = StdRandom.uniform(1, SIDES+1); // Generates a random number between 1 and 6
            rolls[result].increment(); // Find the correct Counter object via its reference and increment it
        }
        
        // Print the final tallies for each side
        for (int i = 1; i <= SIDES; i++)
            StdOut.println(rolls[i]);
    }
}