import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class UVA146 {
	public static void main(String args[]) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String s = reader.readLine();
		while (!s.equals("#")) {
			if (s.length() == 0) {
				System.out.println("No Successor");
				s = reader.readLine();
				continue;
			}
			char[] a = s.toCharArray();
			int pos = s.length() - 1;
			while (pos > 0 && a[pos] <= a[pos - 1]) {
				pos--;
			}
			if (pos == 0) {
				System.out.println("No Successor");
			} else {
				int temp = pos - 1;
				pos = s.length() - 1;
				while (a[temp] >= a[pos]) {
					pos--;
				}
				char temp2 = a[temp];
				a[temp] = a[pos];
				a[pos] = temp2;
				int left = temp + 1;
				int right = s.length() - 1;
				while (left < right) {
					temp2 = a[left];
					a[left] = a[right];
					a[right] = temp2;
					left++;
					right--;
				}
				System.out.println(String.valueOf(a));
			}
			s = reader.readLine();
		}
	}
}
