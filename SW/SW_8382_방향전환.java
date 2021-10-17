

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class SW_8382_방향전환 {
	static int x1;
	static int y1;
	static int x2;
	static int y2;
	
	static int[][] board;
	static boolean[][][] visited;
	
	static StringBuilder sb = new StringBuilder();

	static class Point {
		int r;
		int c;
		int cnt;
		int dir; // 1: 세로 , 0 : 가로
		
		Point(int r, int c, int cnt, int dir) {
			this.r = r;
			this.c = c;
			this.cnt = cnt;
			this.dir = dir;
		}
	}
	
	static int[][] deltas = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}}; // 세로, 가로 이동
	static Queue<Point> queue = new LinkedList<>();
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		for(int t = 0; t < T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			x1 = Integer.parseInt(st.nextToken()) + 100; // 시작 좌표
			y1 = Integer.parseInt(st.nextToken()) + 100;
			x2 = Integer.parseInt(st.nextToken()) + 100; // 끝 좌표
			y2 = Integer.parseInt(st.nextToken()) + 100;
			
			board = new int[201][201];
			visited = new boolean[201][201][2]; // 가로/세로 이동
			
			// 첫 이동
			for(int d = 0; d < deltas.length; d++) {
				int nr = x1 + deltas[d][0];
				int nc = y1 + deltas[d][1];
				
				if(!isIn(nr, nc))
					continue;
				
				// 첫 이동이 세로 이동이면
				if(d == 0 || d == 1) {
					visited[nr][nc][1] = true; // 세로 방문처리
					queue.add(new Point(nr, nc, 1, 1)); // x 좌표, y 좌표, cnt, dir 
				}
				// 첫 이동이 가로 이동이면
				else if(d == 2 || d == 3) {
					visited[nr][nc][0] = true; // 가로 방문처리
					queue.add(new Point(nr, nc, 1, 0));
				}
			}
			
			sb.append("#").append(t+1).append(" ");
			bfs();
		}
		System.out.println(sb);
	}
	static void bfs() {
		while(!queue.isEmpty()) {
			Point p = queue.poll();
			
			int r = p.r;
			int c = p.c;
			int cnt = p.cnt;
			int dir = p.dir;
			
			// 도착점 도달 하면
			if(r == x2 && c == y2) {
				sb.append(cnt).append("\n");
				return;
			}
			
			// 첫 번째로 세로 이동했다면
			if(dir == 1) {
				// 가로로 이동
				for(int d = 2; d < 4; d++) {
					int nr = r + deltas[d][0];
					int nc = c + deltas[d][1];
					
					if(!isIn(nr, nc))
						continue;
					
					if(visited[nr][nc][1]) // (세로) 방문 했으면
						continue;
					
					queue.add(new Point(nr, nc, cnt+1, 0)); // 다음번엔 가로 이동
				}
			}
			
			// 가로로 이동했다면
			if(dir == 0) {
				// 세로로 이동
				for(int d = 0; d < 2; d++) {
					int nr = r + deltas[d][0];
					int nc = c + deltas[d][1];
					
					if(!isIn(nr, nc))
						continue;
					
					if(visited[nr][nc][0]) // 방문했으면
						continue;
					
					queue.add(new Point(nr, nc, cnt+1, 1)); // 다음번엔 세로 이동
				}
			}
			
		}
	}
	
	static boolean isIn(int r, int c) {
		return r >= 0 && c >= 0 && r <201 && c < 201;
	}
}
