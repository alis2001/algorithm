/******************************************************************************
 *  Compilation:  javac-algs4 InsertionAnimate.java
 *  Execution:    java-algs4 InsertionAnimate n [delayMs]
 *
 *  Live animation of insertion sort (Exercise 2.1.17 style):
 *  clear the window and redraw bars after each swap.
 *
 *  Colors (same meaning as InsertionBars):
 *    LIGHT_GRAY = untouched / not in current insert range
 *    BLACK      = sorted left side involved in this insertion
 *    BOOK_RED   = item currently being inserted (a[j])
 *
 *  % java-algs4 InsertionAnimate 20 40
 *
 ******************************************************************************/

import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdRandom;

public class InsertionAnimate {
    private static int delay = 40;

    public static void sort(double[] a) {
        int n = a.length;
        show(a, 0, 0);
        for (int i = 1; i < n; i++) {
            int j = i;
            show(a, i, j);
            while (j >= 1 && less(a[j], a[j - 1])) {
                exch(a, j, j - 1);
                j--;
                show(a, i, j);   // watch red bar slide left
            }
            show(a, i, j);
            StdDraw.pause(delay * 2);
        }
        show(a, n - 1, -1);
    }

    private static void show(double[] a, int i, int j) {
        StdDraw.clear();

        // left of insertion point: gray (smaller / already passed)
        StdDraw.setPenColor(StdDraw.LIGHT_GRAY);
        for (int k = 0; k < j; k++)
            StdDraw.filledRectangle(k, a[k] / 2.0, 0.25, a[k] / 2.0);

        // current inserted item
        if (j >= 0) {
            StdDraw.setPenColor(StdDraw.BOOK_RED);
            StdDraw.filledRectangle(j, a[j] / 2.0, 0.25, a[j] / 2.0);
        }

        // rest of sorted prefix: black
        StdDraw.setPenColor(StdDraw.BLACK);
        for (int k = j + 1; k <= i; k++)
            StdDraw.filledRectangle(k, a[k] / 2.0, 0.25, a[k] / 2.0);

        // right of i: untouched gray
        StdDraw.setPenColor(StdDraw.LIGHT_GRAY);
        for (int k = i + 1; k < a.length; k++)
            StdDraw.filledRectangle(k, a[k] / 2.0, 0.25, a[k] / 2.0);

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
