public class ThreeSumMathDemo {

    public static void main(String[] args) {
        String[] letters = {"A", "B", "C", "D", "E"};
        int N = letters.length;

        System.out.println("=== PART 1: COUNTING WITH 3 LOOPS (N = " + N + ") ===");
        System.out.println("Items: A, B, C, D, E (indexes 0, 1, 2, 3, 4)\n");

        int loopCount = 0;

        for (int i = 0; i < N; i++) {
            for (int j = i + 1; j < N; j++) {
                for (int k = j + 1; k < N; k++) {
                    loopCount++;
                    System.out.printf(
                        "Triple #%2d: indexes (%d, %d, %d) -> (%s, %s, %s)%n",
                        loopCount, i, j, k, letters[i], letters[j], letters[k]
                    );
                }
            }
        }

        System.out.println("\nTotal triples found by loops = " + loopCount);

        System.out.println("\n=== PART 2: SAME RESULT USING THE FORMULA ===");
        int step1 = N * (N - 1) * (N - 2);
        int formulaCount = step1 / 6;

        System.out.println("N = " + N);
        System.out.println("N * (N - 1) * (N - 2) = " + N + " * " + (N - 1) + " * " + (N - 2) + " = " + step1);
        System.out.println("Divide by 6           = " + step1 + " / 6 = " + formulaCount);

        System.out.println("\n=== PART 3: WHY N^3 DOMINATES WHEN N IS BIG ===");
        int[] sizes = {5, 10, 100, 1000};

        for (int size : sizes) {
            long exact = (long) size * (size - 1) * (size - 2) / 6;
            double approx = Math.pow(size, 3) / 6.0;

            System.out.printf(
                "N = %4d | exact = %12d | N^3 / 6 = %14.1f%n",
                size, exact, approx
            );
        }
    }
}
