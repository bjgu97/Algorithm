import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;
	static int N;
	static team [] able;
	static team [] visited;
	public static void main(String[] args) throws NumberFormatException, IOException {
		//input = new BufferedReader(new StringReader(src));
		N = Integer.parseInt(input.readLine());
		able = new team[N];
		visited = new team[N];
		for(int i = 0; i < N; i++) {
			tokens = new StringTokenizer(input.readLine());
			int s = Integer.parseInt(tokens.nextToken());
			int e = Integer.parseInt(tokens.nextToken());
			int m = e-s;
			if(m !=0) {
				able[i] = new team(s, e, m);
			}
			
			
		}
		Arrays.sort(able);
		
	    if(able == null) {
			System.out.println("0");
            return;
		}
	    System.out.println(able);
		//System.out.println(Arrays.toString(able));
		visited[0] = able[0];
		int min = able[0].getEnd();
		for(int i = 1; i< N; i++) {
			if(min <=able[i].getStart()) {
				visited[i] = able[i];
				min = able[i].getEnd();
			}
		}
		int count = 0;
		for(int i = 0; i< N; i++) {
			if(visited[i] != null) {
				count++;
			}
		}
		
		System.out.println(count);
		//System.out.println(Arrays.toString(visited));
	}
	static class team implements Comparable<team>{
		int start;
		int end;
		int range;
		public team(int start, int end, int range) {
			super();
			this.start = start;
			this.end = end;
			this.range = range;
		}
		public int getStart() {
			return start;
		}
		public void setStart(int start) {
			this.start = start;
		}
		public int getEnd() {
			return end;
		}
		public void setEnd(int end) {
			this.end = end;
		}
		public int getRange() {
			return range;
		}
		public void setRange(int range) {
			this.range = range;
		}
		@Override
		public String toString() {
			return "team [start=" + start + ", end=" + end + ", range=" + range + "]";
		}
		@Override
		public int compareTo(team o) {
			return this.end - o.end;
		}
		
		
		
	}

}