

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_2636_치즈 {
	static int R;
	static int C;
	static int[][] graph;
	static boolean[][] visited;
	static int cnt;
	static class Point {
		int r;
		int c;
		
		Point(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		graph = new int[R][C];
		
		cnt = 0; // 전체 치즈 개수
		
		for(int r = 0; r < R; r++) {
			st = new StringTokenizer(br.readLine());
			for(int c = 0; c < C; c++) {
				graph[r][c] = Integer.parseInt(st.nextToken());
				if(graph[r][c] == 1) { // 치즈 이면
					cnt+= 1; // 치즈 개수 증가 
				}
			}
		}

		int time = 0; // 치즈 다 녹기까지 걸리는 시간
		while(cnt > 0) {// 치즈가 다 녹을때까지
			time++;
			bfs();
		}
		
		System.out.println(time);
		System.out.println(numCheese);
	}
	
	static Queue<Point> queue = new LinkedList<>();
	static int[][] deltas = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
	static int outCnt = 0;
	static int numCheese;
	
	static void bfs() {
		queue.add(new Point(0, 0)); // 첫 좌표 넣고
		visited = new boolean[R][C];
		visited[0][0] =  true; // 첫 좌표 방문 처리 하고

		// 한번 다 돌면서
		while(!queue.isEmpty()) {
			Point p = queue.poll();
			int r = p.r;
			int c = p.c;
			
			for(int d = 0; d < deltas.length; d++) {
				int nr = r + deltas[d][0];
				int nc = c + deltas[d][1];
				
				if(nr < 0 || nc < 0 || nr >= R || nc >= C)
					continue;
				
				if(visited[nr][nc] == true)
					continue;
				
				// 겉 치즈 만나면 녹이기
				if(graph[nr][nc] == 1) {
					graph[nr][nc] = 3; // 표시 해주고
					outCnt++; // 겉 치즈 개수
				}
				
				// 공기 만나면
				else if(graph[nr][nc] == 0) {
					queue.add(new Point(nr, nc));
				}
				
				visited[nr][nc] = true;
			}
		}
		
		for(int[] a : graph)
			System.out.println(Arrays.toString(a));
		System.out.println(cnt);
		System.out.println();
		
		// 치즈 녹이기
		numCheese = 0;
		for(int r = 0; r < R; r++) {
			for(int c = 0; c < C; c++) {
				if(graph[r][c] == 3) {
					graph[r][c] = 0;
					numCheese++;
				}
			}
		}
		
		cnt -= numCheese;
		
		for(int[] a : graph)
			System.out.println(Arrays.toString(a));
		System.out.println(cnt);
		System.out.println();
	}
	
}
