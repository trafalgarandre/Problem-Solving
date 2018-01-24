import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.TreeSet;


public class UVA11136 {
	public static void main(String args[]) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int t;
		while ((t = Integer.parseInt(reader.readLine())) != 0) {
			long count = 0;
			TreeSet<MyInteger> ts = new TreeSet<MyInteger>();
			int id = 0;
			for (int i = 0; i < t; i++) {
				StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
				int n = Integer.parseInt(tokenizer.nextToken());
				for (int j = 0; j < n; j++) {
					ts.add(new MyInteger(Integer.parseInt(tokenizer.nextToken()), id));
					id++;
				}
				if (ts.size() > 1) {
					count = count + ts.last().val - ts.first().val;
					ts.remove(ts.last());
					ts.remove(ts.first());
				} else {
					if (!ts.isEmpty()) {
						count += ts.first().val;
						ts.remove(ts.first());
					}
				}
			}
			System.out.println(count);
		}
	}
	
	static class MyInteger implements Comparable<MyInteger> {
		int id;
		int val;
		
		MyInteger(int _val, int _id) {
			id = _id;
			val = _val;
		}
		
		public int compareTo(MyInteger other) {
			if (this.val == other.val) {
				return this.id - other.id;
			} else {
				return this.val - other.val;
			}
		}
	}
}
