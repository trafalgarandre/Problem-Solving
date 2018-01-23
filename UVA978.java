import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.StringTokenizer;
import java.util.TreeSet;


class Main {
	public static void main(String args[]) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(reader.readLine());
		
		for (int i = 0; i < t; i++) {
			StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
			int b = Integer.parseInt(tokenizer.nextToken());
			int sg = Integer.parseInt(tokenizer.nextToken());
			int sb = Integer.parseInt(tokenizer.nextToken());
			TreeSet<myInteger> gs = new TreeSet<myInteger>();
			TreeSet<myInteger> bs = new TreeSet<myInteger>();
			for (int j = 0; j < sg; j++) {
				gs.add(new myInteger(Integer.parseInt(reader.readLine()), j));
			}
			for (int j = 0; j < sb; j++) {
				bs.add(new myInteger(Integer.parseInt(reader.readLine()), j));
			}
			while (!gs.isEmpty() && !bs.isEmpty()) {
				ArrayList<myInteger> tempg = new ArrayList<myInteger>();
				ArrayList<myInteger> tempb = new ArrayList<myInteger>();
				for (int j = 0; j < b; j++) {
					if (gs.isEmpty() || bs.isEmpty()) {
						break;
					} else {
						myInteger gi = gs.first();
						myInteger bi = bs.first();
						if (gi.val > bi.val) {
							tempg.add(new myInteger(gi.val - bi.val, gi.id));
						} else if (gi.val < bi.val) {
							tempb.add(new myInteger(bi.val - gi.val, bi.id));
						}
						gs.remove(gi);
						bs.remove(bi);
					}
				}
				gs.addAll(tempg);
				bs.addAll(tempb);
			}
			if (!gs.isEmpty()) {
				System.out.println("green wins");
				Iterator<myInteger> iter = gs.iterator();
				while(iter.hasNext()) {
					System.out.println(iter.next().val);
				}
			} else if (!bs.isEmpty()) {
				System.out.println("blue wins");
				Iterator<myInteger> iter = bs.iterator();
				while(iter.hasNext()) {
					System.out.println(iter.next().val);
				}
			} else {
				System.out.println("green and blue died");
			}
			if (i != t - 1) {
				System.out.println();
			}
		}
	}
	
	static class myInteger implements Comparable<myInteger> {
		int val;
		int id;
		myInteger(int _val, int _id) {
			val = _val;
			id = _id;
		}
		
		public int compareTo(myInteger other) {
			if (this.val == other.val) {
				return this.id - other.id;
			} else {
				return other.val - this.val;
			}
		}
	}
}
