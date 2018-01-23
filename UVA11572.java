import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;


public class UVA11572 {
	public static void main(String args[]) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(reader.readLine());
		for (int i = 0; i < t; i++) {
			int n = Integer.parseInt(reader.readLine());
			HashMap<Integer, Integer> h = new HashMap<Integer, Integer>();
			int left = 0;
			int max = 0;
			for (int j = 0; j < n; j++) {
				int key = Integer.parseInt(reader.readLine());
				if (!h.containsKey(key) || h.get(key) < left) {
					h.put(key, j);
				} else {
					if (max < j - left) {
						max = j - left;
					}
					left = h.get(key) + 1;
					h.put(key, j);
				}
			}
			if (n - left > max) {
				max = n - left;
			}
			System.out.println(max);
		}
	}
}
