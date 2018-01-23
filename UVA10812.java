import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class UVA10812 {
	public static void main(String args[]) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tokenizer;
		int n = Integer.parseInt(reader.readLine());
		for (int i = 0; i < n; i++) {
			tokenizer = new StringTokenizer(reader.readLine());
			long s = Integer.parseInt(tokenizer.nextToken());
			long d = Integer.parseInt(tokenizer.nextToken());
			boolean check = true;
			if ((s + d) % 2 == 1) {
				check = false;
			}
			long a = (s + d) / 2;
			long b = s - a;
			if (b < 0) {
				check = false;
			}
			if (check) {
				System.out.println(a + " " + b);
			} else {
				System.out.println("impossible");
			}
		}
	}
}
