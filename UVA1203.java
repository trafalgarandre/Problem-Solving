import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;


public class UVA1203 {
	public static void main(String args[]) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
		String s;
		PriorityQueue<Query>  pq = new PriorityQueue<Query>();
		while (!(s = tokenizer.nextToken()).equals("#")) {
			pq.add(new Query(Integer.parseInt(tokenizer.nextToken()), Integer.parseInt(tokenizer.nextToken())));
			tokenizer = new StringTokenizer(reader.readLine());
		}
		int k = Integer.parseInt(reader.readLine());
		while (k != 0) {
			Query temp = pq.poll();
			System.out.println(temp.id);
			temp.update();
			pq.add(temp);
			k--;
		}
	}
	
	static class Query implements Comparable<Query> {
		int id;
		int period;
		int time;
		Query(int _id, int _period) {
			id = _id;
			period = _period;
			time = _period;
		}
		
		public void update() {
			time += period;
		}
		
		public int compareTo(Query other) {
			if (this.time == other.time) {
				return this.id - other.id;
			} else {
				return this.time - other.time;
			}
		}
	}
}
