import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


public class UVA11034 {
	public static void main(String args[]) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int c = Integer.parseInt(reader.readLine());
		StringTokenizer tokenizer;
		
		for (int k = 0; k < c; k++) {
			tokenizer = new StringTokenizer(reader.readLine());
			int l = Integer.parseInt(tokenizer.nextToken()) * 100;
			int m = Integer.parseInt(tokenizer.nextToken());
			Queue<Integer> lq = new LinkedList<Integer>();
			Queue<Integer> rq = new LinkedList<Integer>();
			
			for (int i = 0; i < m; i++) {
				tokenizer = new StringTokenizer(reader.readLine());
				int cl = Integer.parseInt(tokenizer.nextToken());
				boolean side = (tokenizer.nextToken().equals("left")) ? true : false;
				if (side) {
					lq.add(cl);
				} else {
					rq.add(cl);
				}
			}
			boolean side = true;
			int curl;
			int count = 0;
			while (!lq.isEmpty() || !rq.isEmpty()) {
				count++;
				curl = l;
				if (side) {
					while (!lq.isEmpty() && curl >= lq.peek()) {
						curl -= lq.poll();
					}
				} else {
					while (!rq.isEmpty() && curl >= rq.peek()) {
						curl -= rq.poll();
					}
				}
				side = !side;
			}
			System.out.println(count);
		}
	}
}
