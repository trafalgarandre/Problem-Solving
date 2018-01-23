import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class UVA637 {
	public static void main(String args[]) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(reader.readLine());
		while (n != 0) {
			int count = 1;
			int pages = n;
			System.out.println("Printing order for " + n +  " pages:");
			String fls, brs, frs = "1", bls = "2";
			int fr = 1, bl = 2, fl, br;
			if (n % 4 == 0) {
				fls = Integer.toString(n);
				brs = Integer.toString(n - 1);
				fl = n;
				br = n - 1;
			} else if (n % 4 == 1) {
				fls = "Blank";
				brs = "Blank";
				br = n + 2;
			} else if (n % 4 == 2) {
				fls = "Blank";
				brs = "Blank";
				br = n + 1;
			} else {
				fls = "Blank";
				brs = Integer.toString(n);
				br = n;
			}
			
			System.out.println("Sheet " + count + ", front: " + fls + ", " + frs);
			if (n != 1) {
				System.out.println("Sheet " + count + ", back : " + bls + ", " + brs);
				if (n % 4 == 0) {
					pages -= 4;
				} else if (n % 4 == 3) {
					pages -= 3;
				} else {
					pages -= 2;
				}
				count++;
				
				while (pages != 0) {
					fl = br - 1;
					fr = bl + 1;
					bl = fr + 1;
					br = fl - 1;
					pages -= 4;
					if (fl > n) {
						fls = "Blank";
						pages ++;
					} else {
						fls = Integer.toString(fl);
					}
					frs = Integer.toString(fr);
					bls = Integer.toString(bl);
					brs = Integer.toString(br);
					System.out.println("Sheet " + count + ", front: " + fls + ", " + frs);
					System.out.println("Sheet " + count + ", back : " + bls + ", " + brs);
					count++;
				}
			}
			n = Integer.parseInt(reader.readLine());
		}
	}
}
