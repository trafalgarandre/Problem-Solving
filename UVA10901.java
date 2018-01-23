import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


public class UVA10901 {
	public static void main(String args[]) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int c = Integer.parseInt(reader.readLine());
		
		StringTokenizer tokenizer;
		
		for (int i = 0; i < c; i++) {
			tokenizer = new StringTokenizer(reader.readLine());
			int n = Integer.parseInt(tokenizer.nextToken());
			int t = Integer.parseInt(tokenizer.nextToken());
			int m = Integer.parseInt(tokenizer.nextToken());
			Queue<Integer> left = new LinkedList<Integer>();
			Queue<Integer> right = new LinkedList<Integer>();
			int[] a = new int[m];
			int time = 0;
			boolean state = true;
			for (int j = 0; j < m; j++) {
				tokenizer = new StringTokenizer(reader.readLine());
				int tempt = Integer.parseInt(tokenizer.nextToken());
				String temps = tokenizer.nextToken();
				a[j] = tempt;
				if (temps.equals("left")) {
					left.add(j);
				} else {
					right.add(j);
				}
			}
			while (!left.isEmpty() || !right.isEmpty()) {
				if (state) {
					if (left.isEmpty()) {
						state = false;
						time = Math.max(a[right.peek()], time) + t;
					} else {
						int count = 0;
						while (!left.isEmpty() && a[left.peek()] <= time && count < n) {
							a[left.poll()] = time + t;
							count++;
						}
						if (count == 0) {
							if (!right.isEmpty() && right.peek() < left.peek()) {
								if (a[right.peek()] > time) {
									time = a[right.peek()];
								}
								time += t;
							} else {
								time = a[left.peek()] + t;
								a[left.poll()] = time;
								count++;
								while (!left.isEmpty() && a[left.peek()] + t == time && count < n) {
									a[left.poll()] = time;
									count++;
								}
							}
						} else {
							time += t;
						}
						state = false;
					}
				} else {
					if (right.isEmpty()) {
						state = true;
						time = Math.max(a[left.peek()], time) + t;
					} else {
						int count = 0;
						while (!right.isEmpty() && a[right.peek()] <= time && count < n) {
							a[right.poll()] = time + t;
							count++;
						}
						if (count == 0) {
							if (!left.isEmpty() && left.peek() < right.peek()) {
								if (a[left.peek()] > time) {
									time = a[left.peek()];
								}
								time += t;
							} else {
								time = a[right.peek()] + t;
								a[right.poll()] = time;
								count++;
								while (!right.isEmpty() && a[right.peek()] + t == time && count < n) {
									a[right.poll()] = time;
									count++;
								}
							}
						} else {
							time += t;
						}
						state = true;
					}
				}
			}
			
			for (int j = 0; j < m; j++) {
				System.out.println(a[j]);
			}
			if (i != c - 1) System.out.println();
		}
	}
}
