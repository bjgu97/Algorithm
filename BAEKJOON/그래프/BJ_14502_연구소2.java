package 그래프;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_14502_연구소2 {
	static int N;
	static int M;
	static int[][] map;
	static int[][] tempMap;

	static boolean[][] visited;
	static int max;
	static int[][] deltas = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		tempMap = new int[N][M];
		for(int n = 0; n < N; n++) {
			st = new StringTokenizer(br.readLine());
			for(int m = 0; m < M; m++) {
				map[n][m] = Integer.parseInt(st.nextToken());
			}
		}
		
		for(int k = 0; k < N; k++) {
			tempMap[k] = map[k].clone();
		}
		
		// 1. 벽 세우기
		wall(0, tempMap);

		// 4. 결과 출력
		System.out.println(max);
	}
	
	
	// 벽 세우기 함수
	static void wall(int cnt, int[][] tempMap) {
		if(cnt == 3) { // 벽이 세 개 세워졌으면
			System.out.println("tempMap: ");
			for(int[] a : tempMap)
				System.out.println(Arrays.toString(a));
			System.out.println();
			
			System.out.println("map: ");
			for(int[] a : map)
				System.out.println(Arrays.toString(a));
			System.out.println();
			
			// 2. 바이러스 전파
			bfs(tempMap); 
			
			
			// tempMap 초기화
			for(int k = 0; k < N; k++) {
				tempMap[k] = map[k].clone();
			}
			return;
		}
		
		for(int n = 0; n < N; n++) {
			for(int m = 0; m < M; m++) {
				if(tempMap[n][m] == 0) { // 빈 공간이면
					tempMap[n][m] = 1; // 벽 세우고
					wall(cnt+1, tempMap);
					tempMap[n][m] = 0;
				}
			}
		}
	}
	
	
	static void  bfs(int[][] map) {
		visited = new boolean[N][M];
		Queue<Point> queue = new LinkedList<>();
		// 일단 바이러스 위치 큐에 저장
		for(int n = 0; n < N; n++) {
			for(int m = 0; m < M; m++) {
				if(map[n][m] == 2) {
					queue.offer(new Point(n, m));
				}
			}
		}
		
		while(!queue.isEmpty()) {
			Point p = queue.poll();
			int r = p.r;
			int c = p.c;
			
			for(int d = 0; d < deltas.length; d++) {
				int nr = r + deltas[d][0];
				int nc = c + deltas[d][1];
				
				if(nr < 0 || nc < 0 || nr >= N || nc >= M) //범위 벗어나면
					continue;

				if(visited[nr][nc]) // 방문 지점이면
					continue;
				
				if(map[nr][nc] == 1) // 벽 나타나면
					continue;
					
				map[nr][nc] = 2;
				visited[nr][nc] = true;
				queue.offer(new Point(nr, nc));
				
			}
		}
		
		count(map);
	}
	
	
	static void count(int[][] map) {

		int cnt = 0;
		for(int n = 0; n < N; n++) {
			for(int m = 0; m < M; m++) {
				if(map[n][m] == 0) {
					cnt++;
				}
			}
		}
		System.out.println("cnt: " + cnt);
		max = Math.max(max, cnt);
		System.out.println("max: " + max);
	}
	
	
	static class Point {
		int r;
		int c;
		Point(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}
	
}
