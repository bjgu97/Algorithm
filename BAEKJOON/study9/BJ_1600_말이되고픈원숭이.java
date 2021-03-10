package study9;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_1600_말이되고픈원숭이 {
	static int K;
	static int W;
	static int H;
	
	static int[][] graph;
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
	
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		K = Integer.parseInt(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		W = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());
		
		graph = new int[H][W];
		visited = new boolean[H][W];
		
		for(int h = 0; h < H; h++) {
			st = new StringTokenizer(br.readLine());
			for(int w = 0; w < W; w++) {
				graph[h][w] = Integer.parseInt(st.nextToken());
			}
		}
		
//		for(int[] a : graph)
//			System.out.println(Arrays.toString(a));
		
		bfs(new Point(0, 0, 0)); // (0, 0) -> (H-1, W-1)
	}
	
	static int[][] deltas1 = {{-2, 1}, {-1, 2}, {1, 2}, {2, 1}, {1, -2}, {2, -1}, {-1, -2}, {-2, -1}};
	static int[][] deltas2 = {{1, 0}, {0, -1}, {0, 1}, {-1, 0}};
	
	static Queue<Point> queue = new LinkedList<>();
	static void bfs(Point p) {
		int r = p.r;
		int c = p.c;
		int cnt = p.cnt;
		
		while(!q)
	}
}
