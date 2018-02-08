import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;


public class UVA10172 {
	public static void main(String args[]) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int set = Integer.parseInt(reader.readLine());
		
		for (int k = 0; k < set; k++) {
			StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
			int n = Integer.parseInt(tokenizer.nextToken());
			int s = Integer.parseInt(tokenizer.nextToken());
			int q = Integer.parseInt(tokenizer.nextToken());
			int count = 0;
			ArrayList<LinkedList<Integer>> bs = new ArrayList<LinkedList<Integer>>();
			for (int i = 0; i < n; i++) {
				tokenizer = new StringTokenizer(reader.readLine());
				int m = Integer.parseInt(tokenizer.nextToken());
				count += m;
				LinkedList<Integer> b = new LinkedList<Integer>();
				for (int j = 0; j < m; j++) {
					b.add(Integer.parseInt(tokenizer.nextToken()) - 1);
				}
				bs.add(b);
			}
			
			int pos = 0;
			int time = 0;
			Stack<Integer> stack = new Stack<Integer>();
			while (count != 0) {
				Queue<Integer> b = bs.get(pos);
				while (stack.size() > 0 && (b.size() < q || stack.peek() == pos)) {
					if (stack.peek() == pos) {
						stack.pop();
						count--;
					} else {
						b.add(stack.pop());
					}
					time++;
				}
				
				while (stack.size() < s && b.size() > 0) {
					stack.push(b.poll());
					time++;
				}
				if (count != 0) {
					time += 2;
				}
				pos = (pos + 1) % n;
			}
			
			System.out.println(time);
		}
	}
}
