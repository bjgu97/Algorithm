

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class SW_1249_보급로 {
	static class Point {
		int r;
		int c;
//		int depth;
		
		Point(int r, int c) {
			this.r = r;
			this.c = c;
//			this.depth = depth;
		}
	}
	
//	static int[][] map;
//	static int[][] dist;
//	static int N;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());
		for(int t = 0; t < T; t++) {
			int N = Integer.parseInt(br.readLine()); // 지도 크기 N
			int[][] map = new int[N][N];
			int[][] dist = new int[N][N];

			for(int n = 0; n < N; n++) {
				String s = br.readLine();
				for(int m = 0; m < N; m++) {
					map[n][m] = s.charAt(m) - '0';
					dist[n][m] = Integer.MAX_VALUE;
				}
			}
	

		bfs(N, map, dist);
		sb.append("#").append(t+1).append(" ").append(dist[N-1][N-1]).append("\n");

		}
		System.out.println(sb);
		
	}
	
	static int[][] deltas = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
	
	static int bfs(int N, int[][] map, int[][] dist) {
		PriorityQueue<Point> queue = new PriorityQueue<>();
		queue.add(new Point(0, 0)); // 시작지점 넣어주고
		dist[0][0] = 0;
		
		while(!queue.isEmpty()) {
			Point p = queue.poll();
			int r = p.r;
			int c = p.c;
			
			if(r == N-1 && c == N-1)
				return dist[N-1][N-1];
			
			for(int d = 0; d < deltas.length; d++) {
				int nr = r + deltas[d][0];
				int nc = c + deltas[d][1];
				
//				if(nr < 0 || nc < 0 || nr >= N || nc >= N)
//					continue;
//	
				if(isIn(nr, nc, N) && dist[nr][nc] == Integer.MAX_VALUE) { // 현재깊이+다음깊이가 더 작으면
					queue.add(new Point(nr, nc));
				}
				
			}
			
		}
		return -1;
	}
	
	static boolean isIn(int r, int c, int N) {
		return r >= 0 && c >= 0  && r < N && c < N;
	}
}
