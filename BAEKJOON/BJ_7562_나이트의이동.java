

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_7562_나이트의이동 {
	
	static int L;
	static int[][] graph;
	static int[][] now;
	static int[][] move;
	static boolean[][] visited;
	
	static class Point {
		int r;
		int c;
		int cnt;
		
		Point(int r, int c, int cnt) {
			this.r = r;
			this.c = c;
			this.cnt = cnt;
		}

		@Override
		public String toString() {
			return "Point [r=" + r + ", c=" + c + ", cnt=" + cnt + "]";
		}
		
		
	}
	static Point toP;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for(int t = 0; t < T; t++) {
			L = Integer.parseInt(br.readLine()); // 체스판 한변의 길이
			graph = new int[L][L];
			visited = new boolean[L][L];
			now = new int[1][2];
			StringTokenizer st = new StringTokenizer(br.readLine());
			Point initP = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), 0);
			
			st = new StringTokenizer(br.readLine());
			toP = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), 0);
			
			queue = new LinkedList<Point>();
			cnt = 0;
			queue.offer(initP);
			bfs();
		}
	}
	
	static int[][] deltas = {{-2, 1}, {-1, 2}, {1, 2}, {2, 1}, {2, -1}, {1, -2}, {-2, -1}, {-1, -2}};
	static Queue<Point> queue;
	static int cnt;
	
	static void bfs() {		
		while(!queue.isEmpty()) {
			Point p = queue.poll();
			
			int r = p.r;
			int c = p.c;
			int cnt = p.cnt;
			
			if(r == toP.r && c == toP.c) {
				System.out.println(cnt);
				return;
			}
			
			for(int d = 0; d < deltas.length; d++) {
				int nr = r + deltas[d][0];
				int nc = c + deltas[d][1];
				
				if(nr < 0 || nc < 0 || nr >= L || nc >= L)
					continue;
				
				if(visited[nr][nc] == false ) {
					visited[nr][nc] = true;
					queue.offer(new Point(nr, nc, cnt+1));
				}
			}
		}
	}
}
