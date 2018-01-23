import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.BitSet;
import java.util.StringTokenizer;


public class UVA11926 {
	public static void main(String args[]) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
		int n = Integer.parseInt(tokenizer.nextToken());
		int m = Integer.parseInt(tokenizer.nextToken());
		BitSet a = new BitSet(1000001);
		while (n != 0 || m != 0) {
			boolean result = true;
			for (int i = 0; i < n; i++) {
				tokenizer = new StringTokenizer(reader.readLine());
				int start = Integer.parseInt(tokenizer.nextToken());
				int end = Integer.parseInt(tokenizer.nextToken());
				if (a.get(start, end).cardinality() != 0) {
					result = false;
				}
				if (result) {
					a.set(start, end);
				}
			}
			
			for (int i = 0; i < m; i++) {
				tokenizer = new StringTokenizer(reader.readLine());
				int start = Integer.parseInt(tokenizer.nextToken());
				int end = Integer.parseInt(tokenizer.nextToken());
				int cycle = Integer.parseInt(tokenizer.nextToken());
				boolean out = false;
				while (result && !out) {
					if (start > 1000000) {
						out = true;
					} else {
						if (end > 1000000) {
							end = 1000000;
							out = true;
						}
						if (a.get(start, end).cardinality() != 0) {
							result = false;
						}
						if (result) {
							a.set(start, end);
							start += cycle;
							end += cycle;
						}
					}
				}
			}
			
			if (result) {
				System.out.println("NO CONFLICT");
			} else {
				System.out.println("CONFLICT");
			}
			
			a.clear();
			tokenizer = new StringTokenizer(reader.readLine());
			n = Integer.parseInt(tokenizer.nextToken());
			m = Integer.parseInt(tokenizer.nextToken());
		}
	}
}
