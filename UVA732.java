import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;


public class UVA732 {
	static String s1, s2;
	static Stack<Character> stack = new Stack<Character>();
	static boolean[] b; 
	public static void main(String args[]) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		while ((s1 = reader.readLine()) != null) {
			if (s1.length() == 0) {
				continue;
			}
			while ((s2 = reader.readLine()).length() == 0) {
			}
			System.out.println('[');
			if (s1.length() == s2.length()) {
				b = new boolean[s1.length() * 2];
				generate(0, 0);
			}
			System.out.println(']');
		}
	}
	
	static void generate(int a1, int a2) {
		if (a1 == s1.length() && a2 == s2.length()) {
			StringBuilder s = new StringBuilder();
			if (b[0]) {
				s.append('i');
			} else {
				s.append('o');
			}
			for (int i = 1; i < s1.length() * 2; i++) {
				if (b[i]) {
					s.append(" i");
				} else {
					s.append(" o");
				}
			}
			System.out.println(s.toString());
		} else if (a1 == s1.length()) {
			if (a2 != s2.length()) {
				if (stack.peek() == s2.charAt(a2)) {
					char temp = stack.pop();
					b[a1 + a2] = false;
					a2++;
					generate(a1, a2);
					a2--;
					b[a1 + a2] = true;
					stack.push(temp);
				}
			}
		} else {
			b[a1 + a2] = true;
			stack.push(s1.charAt(a1));
			a1++;
			generate(a1, a2);
			a1--;
			stack.pop();
			if (!stack.isEmpty() && stack.peek() == s2.charAt(a2)) {
				char temp = stack.pop();
				b[a1 + a2] = false;
				a2++;
				generate(a1, a2);
				a2--;
				stack.push(temp);
			}
		}
	}
}
