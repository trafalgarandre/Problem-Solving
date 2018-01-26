import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class UVA11933 {
	public static void main(String args[]) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int n;
		while ((n = Integer.parseInt(reader.readLine())) != 0) {
			int temp = n;
			int multiply = 1;
			int a = 0, b = 0;
			int count = 0;
			while (temp > 0) {
				if (temp % 2 != 0) {
					if (count % 2 == 0) {
						a += multiply;
					}
					count++;
				}
				temp = temp>>1;
				multiply *= 2;
			}
			b = n - a;
			System.out.println(a + " " + b);
		}
	}
}
