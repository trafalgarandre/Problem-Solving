import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Stack;
import java.util.StringTokenizer;


public class UVA11995 { 
	public static void main(String args[]) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String s;
		while ((s = reader.readLine()) != null) {
			int n = Integer.parseInt(s);
			Stack<Integer> stack = new Stack<Integer>();
			LinkedList<Integer> queue = new LinkedList<Integer>();
			PriorityQueue<Integer> pqueue = new PriorityQueue<Integer>(1000, Collections.reverseOrder());
			boolean checks = true, checkq = true, checkp = true;
			int count = 3;
			for (int i = 0; i < n; i++) {
				StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
				int type = Integer.parseInt(tokenizer.nextToken());
				int val = Integer.parseInt(tokenizer.nextToken());
				if (type == 1) {
					stack.push(val);
					queue.add(val);
					pqueue.add(val);
				} else {
					if (checks && (stack.isEmpty() || stack.pop() != val)) {
						checks = false;
						count--;
					}
					if (checkq && (queue.isEmpty() || queue.poll() != val)) {
						checkq = false;
						count--;
					}
					if (checkp && (pqueue.isEmpty() || pqueue.poll() != val)) {
						checkp = false;
						count--;
					}
				}
			}
			if (count == 0) {
				System.out.println("impossible");
			} else if (count == 1) {
				if (checks) {
					System.out.println("stack");
				} else if (checkq) {
					System.out.println("queue");
				} else if (checkp) {
					System.out.println("priority queue");
				}
			} else {
				System.out.println("not sure");
			}
		}
	}
}
