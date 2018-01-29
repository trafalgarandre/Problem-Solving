import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Stack;


public class UVA1062 {
	public static void main(String args[]) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		String s;
		int case_num = 1;
		while (!(s = reader.readLine()).equals("end")) {
			ArrayList<Stack<Character>> stacks = new ArrayList<Stack<Character>>(); 
			HashSet<Character> difCharacters = new HashSet<Character>();
			for (int i = 0; i < s.length(); i++) {
				char cur = s.charAt(i);
				if (!difCharacters.contains(cur)) {
					difCharacters.add(cur);
				}
				if (stacks.size() == 0) {
					stacks.add(new Stack<Character>());
					stacks.get(0).add(cur);
				} else {
					int min = 1000;
					int minS = -1;
					for (int j = 0; j < stacks.size(); j++) {
						int dif = stacks.get(j).peek() - cur;
						if (dif >= 0 && dif < min) {
							min = dif;
							minS = j; 
						}
					}
					if (minS == -1) {
						minS = stacks.size();
						stacks.add(new Stack<Character>());
					}
					stacks.get(minS).add(cur);
				}
			}
			
			int result = stacks.size();
			if (stacks.size() > difCharacters.size()) {
				result = difCharacters.size();
			}
			System.out.println("Case " + case_num + ": " + result);
			case_num++;
		}
	}
}
