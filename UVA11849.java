import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;


public class UVA11849 {
	public static void main(String args[]) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
		int a = Integer.parseInt(tokenizer.nextToken());
		int b = Integer.parseInt(tokenizer.nextToken());
		
		while (a != 0 || b != 0) {
			
			HashSet<Integer> h = new HashSet<Integer>();
			for (int i = 0; i < a; i++) {
				h.add(Integer.parseInt(reader.readLine()));
			}
			
			int count = 0;
			for (int i = 0; i < b; i++) {
				if (h.contains(Integer.parseInt(reader.readLine()))) {
					count++;
				}
			}
			
			System.out.println(count);
			tokenizer = new StringTokenizer(reader.readLine());
			a = Integer.parseInt(tokenizer.nextToken());
			b = Integer.parseInt(tokenizer.nextToken());
		}
	}
}
