import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class UVA403 {
	static String s;
	static char[][] a;
	public static void main(String args[]) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String line;
		while ((line = reader.readLine()) != null) {
			a = new char[60][60];
			for (int i = 0; i < 60; i++) {
				for (int j = 0; j < 60; j++) {
					a[i][j] = '.';
				}
			}
			while (!line.equals(".EOP")) {
				StringTokenizer tokenizer = new StringTokenizer(line);
				String pos = tokenizer.nextToken();
				String type = tokenizer.nextToken();
				int r = Integer.parseInt(tokenizer.nextToken()) - 1;
				int c = 0;
				if (pos.equals(".P")) {
					c = Integer.parseInt(tokenizer.nextToken()) - 1;
				}
				s = tokenizer.nextToken("|");
				s = tokenizer.nextToken("|");
				System.out.println(pos + " " + type + " " + r + " " + s);
				
				if (type.equals("C1")) {
					if (pos.equals(".L")) {
						for (int i = 0; i < s.length(); i++) {
							a[r][i] = s.charAt(i);
						}
					} else if (pos.equals(".C")) {
						for (int i = 30 - s.length() / 2; i < 30 - s.length() / 2 + s.length(); i++) {
							a[r][i] = s.charAt(i - 30 + s.length() / 2);
						}
					} else if (pos.equals(".R")) {
						for (int i = 60 - s.length(); i < 60; i++) {
							a[r][i] = s.charAt(i - 60 + s.length());
						}
					} else {
						for (int i = c; i < Math.min(60, c + s.length()); i++) {
							a[r][i] = s.charAt(i - c);
						}
					}
				} else {
					int start = 0;
					if (pos.equals(".R")) {
						c = 60 - 6 * s.length();
						if (c < 0) {
							start = s.length() - 10;
							c = 0;
						}
					} else if (pos.equals(".C")) {
						c = 30 - s.length() / 2 * 6;
						if (c < 0) {
							c = 0;
							start = s.length() / 2 - 5;
						}
					}
					while (c < 60 && start != s.length()) {
						draw(r, c, start);
					}
				}
				line = reader.readLine();
			}
			for (int i = 0; i < 60; i++) {
				for (int j = 0; j < 60; j++) {
					System.out.print(a[i][j]);
				}
				System.out.println();
			}
		}
	}
	
	static boolean check(int r, int c) {
		return c < 60 && r < 60;
	}
	static void draw(int r, int c, int start) {
		char chr = s.charAt(start);
		if (chr == 'A') {
			if (check(r, c + 1)) {
				a[r][c + 1] = '*';
			}
			if (check(r, c + 2)) {
				a[r][c + 2] = '*';
			}
			if (check(r, c + 3)) {
				a[r][c + 3] = '*';
			}
			if (check(r + 1, c)) {
				a[r + 1][c] = '*';
			}
			if (check(r + 1, c + 4)) {
				a[r + 1][c + 4] = '*';
			}
			for (int i = 0; i < 5; i++) {
				if (check(r + 2, c + i)) {
					a[r + 2][c + i] = '*';
				}
			}
			if (check(r + 3, c)) {
				a[r + 3][c] = '*';
			}
			if (check(r + 3, c + 4)) {
				a[r + 3][c + 4] = '*';
			}
			if (check (r + 4, c)) {
				a[r + 4][c] = '*';
			}
			if (check(r + 4, c + 4)) {
				a[r + 4][c + 4] = '*';
			}
		} else if (chr == 'B') {
			for (int i = 0; i < 2; i++) {
				if (check(r + i * 2 + 1, c)) {
					a[r + i * 2 + 1][c] = '*';
				}
				if (check(r + 1 * 2 + 1, c + 4)) {
					a[r + i * 2 + 1][c] = '*';
				}
			}
			for (int i = 0; i < 3; i++) {
				for (int j = 0; j < 4; j++) {
					if (check(r + i * 2, c + j)) {
						a[r + i * 2][c + j] = '*';
					}
				}
			}
		}
	}
}
