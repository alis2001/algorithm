/******************************************************************************
 *  Compilation:  javac-algs4 SortCompare.java
 *  Execution:    java-algs4 SortCompare alg1 alg2 N T
 *
 *  Compare two sorting algorithms on random Double arrays.
 *
 *  % java-algs4 SortCompare Insertion Selection 1000 100
 *  For 1000 random Doubles
 *   Insertion is 1.7 times faster than Selection
 *
 ******************************************************************************/

import java.util.Arrays;

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

public class SortCompare {

    public static double time(String alg, Double[] a) {
        Stopwatch timer = new Stopwatch();
        if (alg.equals("Insertion")) Insertion.sort(a);
        else if (alg.equals("Selection")) Selection.sort(a);
        else if (alg.equals("Shell")) Shell.sort(a);
        else if (alg.equals("System")) Arrays.sort(a);
        // add Merge / Quick / Heap here when you implement them
        else throw new IllegalArgumentException("Invalid algorithm: " + alg);
        return timer.elapsedTime();
    }

    public static double timeRandomInput(String alg, int N, int T) {
        double total = 0.0;
        Double[] a = new Double[N];
        for (int t = 0; t < T; t++) {
            for (int i = 0; i < N; i++)
                a[i] = StdRandom.uniformDouble(0.0, 1.0);
            total += time(alg, a);
        }
        return total;
    }

    public static void main(String[] args) {
        String alg1 = args[0];
        String alg2 = args[1];
        int N = Integer.parseInt(args[2]);
        int T = Integer.parseInt(args[3]);

        double t1 = timeRandomInput(alg1, N, T);
        double t2 = timeRandomInput(alg2, N, T);

        StdOut.printf("For %d random Doubles\n  %s is", N, alg1);
        StdOut.printf(" %.1f times faster than %s\n", t2 / t1, alg2);
    }
}
