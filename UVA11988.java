import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;


public class UVA11988 {
	public static void main(String args[]) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String s;
		while ((s = reader.readLine()) != null) {
			LinkedList<Character> l = new LinkedList<Character>();
			int pos = 0;
			for (int i = 0; i < s.length(); i++) {
				char temp = s.charAt(i);
				if (temp == '[') {
					pos = 0;
				} else if (temp == ']') {
					pos = -1;
				} else {
					if (pos == -1) {
						l.add(temp);
					} else {
						l.add(pos, temp);
						pos++;
					}
				}
			}
			StringBuilder sb = new StringBuilder();
			for(char c : l) sb.append(c);
			System.out.println(sb.toString());
		}
	}
}
