/******************************************************************************
 *  Compilation:  javac-algs4 ShellAnimate.java
 *  Execution:    java-algs4 ShellAnimate n [delayMs]
 *
 *  Live animation of shellsort: clear and redraw after each swap.
 *
 *  Colors:
 *    LIGHT_GRAY = not on the chain being inserted into
 *    BLACK      = other bars on that chain (every h steps)
 *    BOOK_BLUE  = the bar h places away, the one being compared
 *    BOOK_RED   = the bar currently moving along the chain
 *
 *  The label shows the gap h. After each gap finishes, the bars pause
 *  in black so you can see the h-sorted array before h shrinks.
 *
 *  % java-algs4 ShellAnimate 20 60
 *
 ******************************************************************************/

import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdRandom;

public class ShellAnimate {
    private static int delay = 60;

    public static void sort(double[] a) {
        int n = a.length;
        int h = 1;
        while (h < n / 3) h = 3 * h + 1;

        while (h >= 1) {
            for (int i = h; i < n; i++) {
                int j = i;
                show(a, h, i, j);
                while (j >= h && less(a[j], a[j - h])) {
                    exch(a, j, j - h);
                    j -= h;
                    show(a, h, i, j);
                }
            }
            show(a, h, -1, -1);      // this gap is finished
            StdDraw.pause(delay * 12);
            h = h / 3;
        }
    }

    private static void show(double[] a, int h, int i, int j) {
        StdDraw.clear();
        int n = a.length;

        for (int k = 0; k < n; k++) {
            boolean onChain = i >= 0 && k <= i && (i - k) % h == 0;
            if (i < 0)
                StdDraw.setPenColor(StdDraw.BLACK);
            else if (k == j)
                StdDraw.setPenColor(StdDraw.BOOK_RED);
            else if (j >= h && k == j - h)
                StdDraw.setPenColor(StdDraw.BOOK_BLUE);
            else if (onChain)
                StdDraw.setPenColor(StdDraw.BLACK);
            else
                StdDraw.setPenColor(StdDraw.LIGHT_GRAY);

            StdDraw.filledRectangle(k, a[k] / 2.0, 0.25, a[k] / 2.0);
        }

        StdDraw.setPenColor(StdDraw.BLACK);
        if (i < 0)
            StdDraw.text(n / 2.0, 1.08, "h = " + h + " done");
        else
            StdDraw.text(n / 2.0, 1.08, "h = " + h);
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
        StdDraw.pause(4000);
    }
}
