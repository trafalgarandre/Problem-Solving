import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;


public class UVA10954 {
	public static void main(String args[]) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int n;
		while((n = Integer.parseInt(reader.readLine())) != 0) {
			PriorityQueue<Long> p = new PriorityQueue<Long>();
			StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
			for (int i = 0; i < n; i++) {
				p.add((long)Integer.parseInt(tokenizer.nextToken()));
			}
			long sum = 0;
			while (p.size() != 1) {
				Long first = p.poll();
				Long second = p.poll();
				sum = sum + first + second;
				p.add(first + second);
			}
			System.out.println(sum);
		}
	}
}
