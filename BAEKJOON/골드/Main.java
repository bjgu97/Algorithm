package 골드;

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
				able[i] = new team(s, e);
			
			
		}
		Arrays.sort(able);
		
		System.out.println(Arrays.toString(able));
		 int count = 1;
		
		int min = able[0].getEnd();
		for(int i = 0; i< N; i++) {
			if(min <=able[i].getStart()) {
				visited[i] = able[i];
				min = able[i].getEnd();
				count++;
			}
		}
		
		System.out.println(count);
		//System.out.println(Arrays.toString(visited));
	}
static class team implements Comparable<team>{
		int start;
		int end;


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


		@Override
		public String toString() {
			return "team [start=" + start + ", end=" + end + "]";
		}


		public team(int start, int end) {
			super();
			this.start = start;
			this.end = end;
		}


		@Override
		public int compareTo(team o) {
			if(this.)
			return this.end - o.end;
		}
		
		
		
	}

}
