package Algorithm.sw.d3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class SW_1249_보급로 {
	static class Point {
		int r;
		int c;
		int depth;
		Point(int r, int c, int depth) {
			this.r = r;
			this.c = c;
			this.depth = depth;
		}

		@Override
		public String toString() {
			return "Point [r=" + r + ", c=" + c + ", depth=" + depth + "]";
		}

	}
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		for(int t = 0; t < T; t++) {
			int N = Integer.parseInt(br.readLine()); // 지도 크기 N
			int[][] map = new int[N][N];
			
			for(int n = 0; n < N; n++) {
				String s = br.readLine();
				for(int m = 0; m < N; m++) {
					map[n][m] = s.charAt(m) - '0';
				}
			}
	
		int[][] dist = new int[N][N];
		boolean[][] visited = new boolean[N][N];

		for(int n = 0; n < N; n++) {
			Arrays.fill(dist[n], Integer.MAX_VALUE);
		}
		bfs(map, dist, visited, N, t+1);
		
		}
		System.out.println(sb);
		
	}
	
	static int[][] deltas = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
	
	static void bfs(int[][] map, int[][] dist, boolean[][] visited, int N, int t) {
		Queue<Point> queue = new LinkedList<>();
		queue.add(new Point(0, 0, 0)); // 시작지점 넣어주고
		dist[0][0] = 0;
		visited[0][0] = true;
		
		while(!queue.isEmpty()) {
			Point p = queue.poll();
			int r = p.r;
			int c = p.c;
			int depth = p.depth;
			
			for(int d = 0; d < deltas.length; d++) {
				int nr = r + deltas[d][0];
				int nc = c + deltas[d][1];
				
				if(nr < 0 || nc < 0 || nr >= N || nc >= N)
					continue;
				if(visited[nr][nc])
					continue;
				
				if(depth + map[nr][nc] < dist[nr][nc]) { // 현재깊이+다음깊이가 더 작으면
					dist[nr][nc] = depth + map[nr][nc];
					queue.add(new Point(nr, nc, dist[nr][nc]));
				}
				
			}
			
		}
		sb.append("#").append(t).append(" ").append(dist[N-1][N-1]).append("\n");
	}
}
