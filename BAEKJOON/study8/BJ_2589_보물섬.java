package study8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_2589_보물섬 {
	static int L;
	static int W;
	static char[][] graph;
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
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		L = Integer.parseInt(st.nextToken());
		W = Integer.parseInt(st.nextToken());
		
		graph = new char[L][W];
		visited = new boolean[L][W];
		
		for(int l = 0; l < L; l++) {
			String s = br.readLine();
			for(int w = 0; w < W; w++) {
				graph[l][w] = s.charAt(w);
			}
		}
		
//		for(char[] a : graph)
//			System.out.println(Arrays.toString(a));
		
		for(int l = 0; l < L; l++) {
			for(int w = 0; w < W; w++) {
				if(graph[l][w] == 'L') {
					visited[l][w] = true;
					queue.offer(new Point(l, w, 0));
					bfs();
					System.out.println("=========");
					visited = new boolean[L][W];
				}
			}
		}
		System.out.println(answ);
	}
	
	static Queue<Point> queue = new LinkedList<>();
	static int[][] deltas = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
	static int answ;
	
	static void bfs() {
		while(!queue.isEmpty()) {
			Point p = queue.poll();
			int r = p.r;
			int c = p.c;
			int cnt = p.cnt;
			
			for(int d =0; d < deltas.length; d++) {
				int nr = r + deltas[d][0];
				int nc = c + deltas[d][1];
				
				if(nr < 0 || nc < 0 || nr >= L || nc >= W) {
					continue;
				}
				
				if(graph[nr][nc] == 'L' && visited[nr][nc] == false) {
					queue.offer(new Point(nr, nc, cnt+1));
					visited[nr][nc] = true;
				}
			}
			
			for(boolean[] a : visited) {
				System.out.println(Arrays.toString(a));
			}
			System.out.println(cnt);
			System.out.println();
			
			answ = Math.max(answ, cnt);
			
		}
	}
}
