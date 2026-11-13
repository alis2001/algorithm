import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.Stack;
import edu.princeton.cs.algs4.StdOut;

public class Reverse {
    public static void main(String[] args) {
        In in = new In("nums.txt");
        Stack<Integer> stack = new Stack<Integer>();

        // push every number onto the stack
        while (!in.isEmpty())
            stack.push(in.readInt());

        // pop prints them in reverse order
        while (!stack.isEmpty())
            StdOut.println(stack.pop());
    }
}
