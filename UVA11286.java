import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;


public class UVA11286 {
	public static void main(String args[]) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int n;
		while ((n = Integer.parseInt(reader.readLine())) != 0) {
			HashMap<String, Integer> h = new HashMap<String, Integer>();
			for (int i = 0; i < n; i++) {
				StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
				int[] a = new int[5];
				for (int j = 0; j < 5; j++) {
					a[j] = Integer.parseInt(tokenizer.nextToken());
				}
				Arrays.sort(a);
				
				StringBuilder sb = new StringBuilder();
				for (int j = 0; j < 5; j++) {
					sb.append(Integer.toString(a[j]));
				}
				
				String key = sb.toString();
				if (!h.containsKey(key)) {
					h.put(key, 1);
				} else {
					h.put(key, h.get(key) + 1);
				}
			}
			int max = 0;
			int count = 0;
			for (Map.Entry<String, Integer> entry: h.entrySet()) {
				if (entry.getValue() > max) {
					max = entry.getValue();
					count = entry.getValue();
				} else if (entry.getValue() == max) {
					count += entry.getValue();
				}
			}
			System.out.println(count);
		}
	}
}
