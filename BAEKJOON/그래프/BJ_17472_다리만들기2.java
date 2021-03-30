package 그래프;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
// 거리의 최솟값,, 최소신장트리

// 각 섬에 번호 붙여줘서
// 섬과 섬 간 가능한 모든 다리 만들어주기(완탐)
// 
public class BJ_17472_다리만들기2 {
	static int N;
	static int M;
	static int[][] map;
	static boolean[][] visited;
	static int[][] deltas = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
	
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
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		visited = new boolean[N][M];
		
		for(int n = 0; n < N; n++) {
			st = new StringTokenizer(br.readLine());
			for(int m = 0; m < M; m++) {
				map[n][m] = Integer.parseInt(st.nextToken());
			}
		}
		
		// 1. 각 섬에 번호 붙여주기
		int num = 1;
		for(int n = 0; n < N; n++) {
			for(int m = 0; m < M; m++) {
				if(map[n][m] == 1) {
					dfs(n, m, num++);
				}
			}
		}
		
//		for(int[] a : map)
//			System.out.println(Arrays.toString(a));

		// 2. 섬과 섬간 가능한 모든 다리 만들어주기 -> 최소 길이 다리 찾기
		for(int n = 0; n < N; n++) {
			for(int m = 0; m < M; m++) {
				if(map[n][m] != 0) {
					bfs(new Point(n, m), map[n][m]); // 좌표와 섬 숫자
				}
			}
		}
		
		
		// 3. MST
		
	}
	
	static void bfs(Point p, int num) {
		int r = p.r;
		int c = p.c;
		int len = 0; // 다리 길이
		
		for(int d = 0; d < deltas.length; d++) {
			while(true) { // 한 방향으로 쭉
				int nr = r + deltas[d][0];
				int nc = c + deltas[d][1];
				
				if(nr < 0 || nc < 0 || nr >= N || nc >= M)
					continue;
				
				if(map[nr][nc] == 0) { // 바다면
					len++;
				}
				else if(map[nr][nc] != num) { // 다른 섬에 도착하면
					
				}
				
			}
		}
	}
	
	
	
	static void dfs(int n, int m, int cnt) {
		for(int d = 0; d < deltas.length; d++) {
			int nn = n + deltas[d][0];
			int mm = m + deltas[d][1];
			
			if(nn < 0 || mm < 0 || nn >= N || mm >= M)
				continue;
			
			if(visited[nn][mm] == true)
				continue;
			
			if(map[nn][mm] == 1) {
				visited[nn][mm] = true;
				map[nn][mm] = cnt;
				dfs(nn, mm, cnt);
			}
				
		}
	}
}
