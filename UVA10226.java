import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.TreeMap;


public class UVA10226 {
	public static void main(String args[]) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(reader.readLine());
		reader.readLine();
		for (int i = 0; i < t; i++) {
			String s;
			TreeMap<String, Integer> tm = new TreeMap<String, Integer>();
			int count = 0;
			while ((s = reader.readLine()) != null && s.length() != 0) {
				if (!tm.containsKey(s)) {
					tm.put(s, 1);
				} else {
					tm.put(s, tm.get(s) + 1);
				}
				count++;
			}
			
			for (Map.Entry<String, Integer> entry: tm.entrySet()) {
				String key = entry.getKey();
				Integer value = entry.getValue();
				System.out.printf("%s %.4f\n", key, (float)value * 100 / (float)count);
			}
			if (i < t - 1) System.out.println();
		}
	}
}

