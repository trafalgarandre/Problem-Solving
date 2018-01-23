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
			ArrayList<Scoreboard> score = new ArrayList<Scoreboard>();
			while ((s = reader.readLine()) != null && s.length() != 0) {
				StringTokenizer tokenizer = new StringTokenizer(s);
				int id = Integer.parseInt(tokenizer.nextToken());
				int prob = Integer.parseInt(tokenizer.nextToken());
				int time = Integer.parseInt(tokenizer.nextToken());
				String status = tokenizer.nextToken();
				int j = 0;
				Scoreboard temp = null;
				while (j < score.size()) {
					if (score.get(j).id == id) {
						temp = score.get(j);
						break;
					}
					j++;
				}
				if (j == score.size()) {
					score.add(new Scoreboard(j));
					temp = score.get(j);
				}
				if (status.equals("I")) {
					temp.updateSub(new Submission(prob, time, false));
				} else if (status.equals("C")) {
					temp.updateSub(new Submission(prob, time, true));
				}
			}
			for (int j = 0; j < score.size(); j++) {
				score.get(j).updateScore();
			}
			Collections.sort(score);
			for (int j = 0; j < score.size(); j++) {
				Scoreboard temp = score.get(j);
				System.out.println(temp.id + " " + temp.probs + " " + temp.time);
			}
		}
	}
	
	static class Submission implements Comparable<Submission>{
		int id;
		int time;
		boolean status;
		
		Submission(int _id, int _time, boolean _status) {
			id = _id;
			time = _time;
			status = _status;
		}
		
		public int compareTo(Submission other) {
			return this.time - other.time;
		}
	}
	
	static class Scoreboard implements Comparable<Scoreboard>{
		boolean[] prob = new boolean[9];
		int[] incor = new int[9];
		int time = 0;
		int probs = 0;
		int id;
		ArrayList<Submission> mysubs = new ArrayList<Submission>();
		
		Scoreboard(int _id) {
			for (int i = 0; i < 9; i++) {
				prob[i] = false;
				incor[i] = 0;
			}
			id = _id;
		}
		
		public void updateScore() {
			Collections.sort(mysubs);
			for (int i = 0; i < mysubs.size(); i++) {
				Submission sub = mysubs.get(i);
				if (!prob[sub.id]) {
					if (sub.status) {
						prob[sub.id] = true;
						probs++;
						time = time + sub.time + 20 * incor[sub.id];
					} else {
						incor[sub.id]++;
					}
				}
			}
		}
		
		public void updateSub(Submission sub) {
			mysubs.add(sub);
		}
		
		public int compareTo(Scoreboard other) {
			if (this.probs < other.probs) {
				return 1;
			} else if (this.probs > other.probs) {
				return -1;
			} else {
				if (this.time < other.time) {
					return -1;
				} else if (this.time > other.time) {
					return 1;
				} else {
					return this.id - other.id;
				}
			}
		}
	}
}
