import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;


public class UVA514 {
	public static void main(String args[]) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tokenizer = null;
		int n = Integer.parseInt(reader.readLine());
		while (n != 0) {
			tokenizer = new StringTokenizer(reader.readLine());
			int m = Integer.parseInt(tokenizer.nextToken());
			if (m == 0) {
				n = Integer.parseInt(reader.readLine());
				System.out.println();
			} else {
				Stack<Integer> a = new Stack<Integer>();
				a.push(m);
				for (int i = 1; i < n; i++) {
					a.push(Integer.parseInt(tokenizer.nextToken()));
				}
				
				Stack<Integer> temp = new Stack<Integer>();
				int start = n;
				
				while (!a.isEmpty()) {
					while (!temp.isEmpty() && temp.peek() == start) {
						temp.pop();
						start--;
					}
					int temp2 = a.pop();
					if (temp2 == start) {
						start--;
					} else {
						temp.push(temp2);
					}
				}
				while (!temp.isEmpty() && temp.peek() == start) {
					temp.pop();
					start--;
				}
				if (temp.isEmpty()) {
					System.out.println("Yes");
				} else {
					System.out.println("No");
				}
			}
		}
	}
}
