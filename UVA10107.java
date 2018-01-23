import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;


public class UVA10107 {
	public static void main(String args[]) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String s;
		ArrayList<Integer> a = new ArrayList<Integer>();
		while((s = reader.readLine()) != null) {
			StringTokenizer tokenizer = new StringTokenizer(s);
			a.add(Integer.parseInt(tokenizer.nextToken()));
			Collections.sort(a);
			if (a.size() % 2 == 0) {
				System.out.println((int)Math.floor((a.get(a.size() / 2) + a.get(a.size() / 2 - 1)) / 2));
			} else {
				System.out.println(a.get(a.size() / 2));
			}
		}
	}
}
