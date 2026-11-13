import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.Queue;

public class QueueStats {
    public static void main(String[] args) {
        In in = new In("nums.txt");
        var q = new Queue<Integer>();
        while (!in.isEmpty()) { 
            q.enqueue(in.readInt());
        }
        int N = q.size();
        int[] a = new int[N];
        for (int i = 0; i < N; i++){
            a[i] = q.dequeue();
            System.out.println(a[i]);
        }
    }
}
