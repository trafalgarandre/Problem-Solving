import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class UVA10855 {
	public static char[][] large = null;
	public static char[][] small = null;
	public static int[] count = new int[4];
	public static void main(String args[]) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
		int a = Integer.parseInt(tokenizer.nextToken());
		int b = Integer.parseInt(tokenizer.nextToken());
		while (a != 0 && b != 0) {
			for (int i = 0; i < 4; i++) {
				count[i] = 0;
			}
			large = new char[a][a];
			small = new char[b][b];
			for (int i = 0; i < a; i++) {
				String s = reader.readLine();
				for (int j = 0; j < a; j++) {
					large[i][j] = s.charAt(j);
				}
			}
			
			for (int i = 0; i < b; i++) {
				String s = reader.readLine();
				for (int j = 0; j < b; j++) {
					small[i][j] = s.charAt(j);
				}
			}
			
			for (int i = 0; i < a - b + 1; i++) {
				for (int j = 0; j < a - b + 1; j++) {
					check0(i, j);
					check1(i, j);
					check2(i, j);
					check3(i, j);
				}
			}
			
			for (int i = 0; i < 3; i++) {
				System.out.print(count[i] + " ");
			}
			System.out.println(count[3]);
			tokenizer = new StringTokenizer(reader.readLine());
			a = Integer.parseInt(tokenizer.nextToken());
			b = Integer.parseInt(tokenizer.nextToken());
		}
	}
	
	public static void check0(int y, int x) {
		boolean check = true;
		for (int i = y; i < y + small[0].length; i++) {
			for (int j = x; j < x + small[0].length; j++) {
				if (large[i][j] != small[i - y][j - x]) {
					check = false;
					break;
				}
			}
		}
		if (check) count[0]++;
	}
	
	public static void check1(int y, int x) {
		boolean check = true;
		int size = small[0].length;
		for (int i = y; i < y + size; i++) {
			for (int j = x; j < x + size; j++) {
				if (large[i][j] != small[size - 1 - j + x][i - y]) {
					check = false;
					break;
				}
			}
		}
		if (check) count[1]++;
	}
	
	public static void check2(int y, int x) {
		boolean check = true;
		int size = small[0].length;
		for (int i = y; i < y + size; i++) {
			for (int j = x; j < x + size; j++) {
				if (large[i][j] != small[size - 1 - i + y][size - 1 - j + x]) {
					check = false;
					break;
				}
			}
		}
		if (check) count[2]++;
	}
	
	public static void check3(int y, int x) {
		boolean check = true;
		int size = small[0].length;
		for (int i = y; i < y + size; i++) {
			for (int j = x; j < x + size; j++) {
				if (large[i][j] != small[j - x][size - 1 - i + y]) {
					check = false;
					break;
				}
			}
		}
		if (check) count[3]++;
	}
}
