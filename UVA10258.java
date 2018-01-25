import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;


public class UVA10258 {
	public static void main(String args[]) throws NumberFormatException, IOException{
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(reader.readLine());
		reader.readLine();
		String s;
		for (int i = 0; i < n; i++) {
			ArrayList<Contestant> contestants = new ArrayList<Contestant>();
			int[] pos = new int[100];
			for (int j = 0; j < 100; j++) {
				pos[j] = -1;
			}
			
			while ((s = reader.readLine()) != null && s.length() != 0) {
				StringTokenizer tokenizer = new StringTokenizer(s);
				int id = Integer.parseInt(tokenizer.nextToken()) - 1;
				int prob = Integer.parseInt(tokenizer.nextToken()) - 1;
				int time = Integer.parseInt(tokenizer.nextToken());
				String c = tokenizer.nextToken();
				if (pos[id] == -1) {
					pos[id] = contestants.size();
					contestants.add(new Contestant(id));
				}
				if (c.equals("C")) {
					contestants.get(pos[id]).submitCor(prob, time);
				} else if (c.equals("I")) {
					contestants.get(pos[id]).submitInc(prob);
				}
			}
			
			Collections.sort(contestants);
			for (Contestant c: contestants) {
				System.out.println((c.id + 1) + " " + c.probs + " " + c.time);
			}
			if (i != n - 1) {
				System.out.println();
			}
		}
	}
	
	static class Contestant implements Comparable<Contestant> {
		int id;
		int probs;
		int time;
		boolean[] correct = new boolean[9];
		int[] incorrect = new int[9];
		Contestant (int _id) {
			id = _id;
			probs = 0;
			time = 0;
			for (int i = 0; i < 9; i++) {
				correct[i] = true;
				incorrect[i] = 0;
			}
		}
		
		public void submitCor(int pid, int _time) {
			if (correct[pid]) {
				time = time + _time + incorrect[pid] * 20;
				probs++;
				correct[pid] = false;
			}
		}
		
		public void submitInc(int pid) {
			if (correct[pid]) {
				incorrect[pid]++;
			}
		}
		
		public int compareTo(Contestant other) {
			if (this.probs == other.probs) {
				if (other.time == this.time) {
					return this.id - other.id;
				} else {
					return this.time - other.time;
				}
			} else {
				return other.probs - this.probs;
			}
		}
	}
}
