package study12;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_6087_레이저통신 {
	static int W;
	static int H;
	static char[][] map;
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
	
	static int[][] deltas = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
	
	static Queue<Point> queue = new LinkedList<>();
	static StringBuilder sb;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		sb = new StringBuilder();
		
		W = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());
		
		map = new char[H][W];
		visited = new boolean[H][W];
		
		for(int h = 0; h < H; h++) {
			String s = br.readLine();
			for(int w = 0; w < W; w++) {
				map[h][w] = s.charAt(w);
			}
		}
		
		outer:for(int h = 0; h < H; h++) {
			for(int w = 0; w < W; w++) {
				if(map[h][w] == 'C') {
					queue.add(new Point(h, w, 0));
					visited[h][w] = true;
					bfs();
					break outer;
				}
			}
		}
	}
	
	static void bfs() {
		System.out.println(queue);
		while(!queue.isEmpty()) {
			Point p = queue.poll();
			int r = p.r;
			int c = p.c;
			int cnt = p.cnt;

			for(int d = 0; d < deltas.length; d++) {
				int nr = r + deltas[d][0];
				int nc = c + deltas[d][1];
				
			
				if(nr < 0 || nc < 0 || nr >= H || nc >= W)
					continue;
				
				if(map[nr][nc] == '*')
					continue;
				
				if(visited[nr][nc] == true)
					continue;
				
				if(map[nr][nc] == 'C') {
					System.out.println(cnt);
				}
				queue.offer(new Point(nr, nc, cnt+1));
				visited[nr][nc] = true;
			}
		}
	}
}
