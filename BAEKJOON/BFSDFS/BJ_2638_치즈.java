package BFSDFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_2638_치즈 {
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
	}
	
	static Queue<Point> queue = new LinkedList<>();
	static int[][] deltas = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
	static int outCnt = 0;
	static int numCheese;
	
	static void bfs() {
		queue.add(new Point(0, 0)); // 첫 좌표 넣고
		visited = new boolean[R][C];
		visited[0][0] =  true; // 첫 좌표(공기) 방문 처리 하고

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
				
				if(visited[nr][nc] ==true) //방문한 곳이면
					continue;
				
				
				// 겉 치즈 만나면 (외부와 한 면 접촉)
				if(graph[nr][nc] != 0 && graph[nr][nc] <=2) {
					graph[nr][nc] += 1;
				}
				
				//외부와 두면 이상 접촉하면
				else if(graph[nr][nc] >=3) {
					outCnt++; // 겉 치즈 개수 증가
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
		
		System.out.println("graph: ");
		for(int[] a : graph)
			System.out.println(Arrays.toString(a));
		System.out.println(cnt);
		System.out.println();
	}
	
}

/*
8 9
0 0 0 0 0 0 0 0 0
0 0 0 0 0 0 0 0 0
0 1 1 0 0 0 1 1 0
0 1 0 1 1 1 0 1 0
0 1 0 0 1 0 0 1 0
0 1 0 1 1 1 0 1 0
0 1 1 0 0 0 1 1 0
0 0 0 0 0 0 0 0 0
*/
