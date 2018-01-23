import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class UVA10264 {
	static int[] base2 = new int[15];
	
	public static void main(String args[]) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String s;
		base2[0] = 1;
		for (int i = 1; i < 15; i++) {
			base2[i] = base2[i - 1] * 2;
		}
		while ((s = reader.readLine()) != null) {
			int n = Integer.parseInt(s);
			int[] weight = new int[base2[n]];
			int[] cost = new int[base2[n]];
			for (int i = 0; i < base2[n]; i++) {
				cost[i] = 0;
				weight[i] = Integer.parseInt(reader.readLine());
			}
			
			for (int i = 0; i < base2[n]; i++) {
				int temp = 1;
				int temp2 = i ^ temp;	
				while (temp2 < base2[n]) {
					cost[i] += weight[temp2];
					temp *= 2;
					temp2 = i ^ temp;
				}
			}
			int max = 0;
			for (int i = 0; i < base2[n]; i++) {
				int temp = 1;
				int temp2 = i ^ temp;
				while (temp2 < base2[n]) {
					if (cost[i] + cost[temp2] > max) {
						max = cost[i] + cost[temp2];
					}
					temp *= 2;
					temp2 = i ^ temp;
				}
			}
			System.out.println(max);
		}
		
	}
}
