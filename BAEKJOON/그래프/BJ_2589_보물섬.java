package 그래프;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_2589_보물섬 {
	static char[][] map;
	static boolean[][] visited;
	
	static int R;
	static int C;
	
	static class Point {
		int r;
		int c;
		int cnt;
		
		Point(int r, int c, int cnt) {
			this.r = r;
			this.c = c;
			this.cnt = cnt;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		map = new char[R][C];
		for(int r = 0; r < R; r++) {
			String s = br.readLine();
			for(int c = 0; c < C; c++) {
				map[r][c] = s.charAt(c);
			}
		}
		
//		for(char[] a : map)
//			System.out.println(Arrays.toString(a));
		
		for(int r = 0; r < R; r++) {
			for(int c = 0; c < C; c++) {
				if(map[r][c] == 'L') {
					visited = new boolean[R][C];
					visited[r][c] = true;
					queue = new LinkedList<>();
					queue.add(new Point(r, c, 0));
					bfs();

				}
			}
		}
		
		System.out.println(max);

	}
	
	static int[][] deltas = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
	static int max;
	static Queue<Point> queue;
	
	static void bfs() {
		int r, c, cnt = 0;
		
		while(!queue.isEmpty()) {
			Point p = queue.poll();
			
			r = p.r;
			c = p.c;
			cnt = p.cnt;
			
			for(int d= 0; d < deltas.length; d++) {
				int nr = r + deltas[d][0];
				int nc = c + deltas[d][1];
				
				if(nr < 0 || nc < 0 || nr >= R || nc >= C) 
					continue;
				
				if(visited[nr][nc] == true)
					continue;
				
				if(map[nr][nc] == 'L') {
					queue.offer(new Point(nr, nc, cnt+1));
					visited[nr][nc] = true;
				}
				
			}
			max = Math.max(max, cnt);
			
//			for(boolean[] a : visited)
//				System.out.println(Arrays.toString(a));
//			System.out.println();
		}
		
	}
}
