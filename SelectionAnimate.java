/******************************************************************************
 *  Compilation:  javac-algs4 SelectionAnimate.java
 *  Execution:    java-algs4 SelectionAnimate n [delayMs]
 *
 *  Live animation of selection sort (Exercise 2.1.17 style):
 *  clear the window and redraw bars after each step.
 *
 *  Colors (same meaning as SelectionBars):
 *    LIGHT_GRAY = already fixed on the left
 *    BLACK      = unsorted region being scanned
 *    BOOK_RED   = current minimum
 *
 *  % java-algs4 SelectionAnimate 20 50
 *
 ******************************************************************************/

import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdRandom;

public class SelectionAnimate {
    private static int delay = 50;

    public static void sort(double[] a) {
        int n = a.length;
        for (int i = 0; i < n; i++) {
            int min = i;
            for (int j = i + 1; j < n; j++) {
                if (less(a[j], a[min]))
                    min = j;
                // show scan progress: red = current min so far
                show(a, i, min);
            }
            exch(a, i, min);
            show(a, i + 1, i);   // after swap, a[i] is fixed
            StdDraw.pause(delay * 2);
        }
        show(a, n, -1);          // fully sorted
    }

    private static void show(double[] a, int i, int min) {
        StdDraw.clear();
        StdDraw.setPenColor(StdDraw.LIGHT_GRAY);
        for (int k = 0; k < i; k++)
            StdDraw.filledRectangle(k, a[k] / 2.0, 0.25, a[k] / 2.0);

        StdDraw.setPenColor(StdDraw.BLACK);
        for (int k = i; k < a.length; k++)
            StdDraw.filledRectangle(k, a[k] / 2.0, 0.25, a[k] / 2.0);

        if (min >= 0) {
            StdDraw.setPenColor(StdDraw.BOOK_RED);
            StdDraw.filledRectangle(min, a[min] / 2.0, 0.25, a[min] / 2.0);
        }
        StdDraw.show();
        StdDraw.pause(delay);
    }

    private static boolean less(double v, double w) {
        return v < w;
    }

    private static void exch(double[] a, int i, int j) {
        double t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        if (args.length > 1)
            delay = Integer.parseInt(args[1]);

        StdDraw.setCanvasSize(700, 320);
        StdDraw.setXscale(-1, n + 1);
        StdDraw.setYscale(-0.05, 1.15);
        StdDraw.enableDoubleBuffering();

        double[] a = new double[n];
        for (int i = 0; i < n; i++)
            a[i] = StdRandom.uniformDouble(0.05, 1.0);

        sort(a);
    }
}
