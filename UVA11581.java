import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class UVA11581 {
	public static void main(String args[]) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(reader.readLine());
		int[][][] a = new int[3][3][2];
		StringTokenizer tokenizer = null;
		for (int i = 0; i < n; i++) {
			String s = new String();
			reader.readLine();
			int x = 0;
			for (int j = 0; j < 3; j++) {
				String temp = reader.readLine();
				s = s.concat(temp);
				for (int k = 0; k < 3; k++) {
					a[j][k][x] = temp.charAt(k) - '0';
				}
			}
			
			boolean[] check = new boolean[1024];
			int[] pos = new int[1024];
			for (int j = 0; j < 1024; j++) {
				check[j] = false;
			}
			int prev = -1;
			int index = toDecimal(s);
			while (!check[index]) {
				pos[index] = prev;
				check[index] = true;
				prev++;
				for (int j = 0; j < 3; j++) {
					for (int k = 0; k < 3; k++) {
						int temp2 = 0;
						if (k > 0) {
							temp2 += a[j][k - 1][x];
						}
						if (k < 2) {
							temp2 += a[j][k + 1][x];
						}
						if (j > 0) {
							temp2 += a[j - 1][k][x];
						}
						if (j < 2) {
							temp2 += a[j + 1][k][x];
						}
						a[j][k][(x + 1) % 2] = temp2 % 2;
					}
				}
				x = (x + 1) % 2;
				index = 0;
				for (int j = 0; j < 3; j++) {
					for (int k = 0; k < 3; k++) {
						index = index * 2 + a[j][k][x];
					}
				}
			}
			System.out.println(pos[index]);
		}
	}
	
	public static int toDecimal(String s) {
		int temp = 0;
		for (int i = 0; i < s.length(); i++) {
			temp *= 2;
			temp = temp + s.charAt(i) - '0';
		}
		return temp;
	}
}
