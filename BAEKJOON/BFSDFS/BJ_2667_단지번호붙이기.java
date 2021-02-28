package BFSDFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BJ_2667_단지번호붙이기 {
	static int N;
	static int[][] graph;
	static boolean[][] visited;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		N = Integer.parseInt(br.readLine());
		
		graph = new int[N][N];
		
		for(int n = 0; n < N; n++) {
			String s = br.readLine();
			for(int m = 0; m < N; m++) {
				graph[n][m] = s.charAt(m) - '0';
			}
		}
		
		visited = new boolean[N][N];
		List<Integer> list = new ArrayList<Integer>();
		
		int cnt = 0;
		for(int i= 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				if(graph[i][j] == 1 && visited[i][j] == false) {
					visited[i][j] = true;
					num = 0;
					int numHouse = dfs(i, j);
					list.add(numHouse);
					cnt++; // 총 단지 수 출력
				}
			}
		}
			System.out.println(cnt);
			Collections.sort(list);
			
			for(int a : list)
				System.out.println(a);
	}
	
	static int[][] deltas = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
	static int num;
	
	static int dfs(int r, int c) {		
		for(int d = 0; d < deltas.length; d++) {
			int nr = r + deltas[d][0];
			int nc = c + deltas[d][1];
			
			if(nr < 0 || nc < 0 || nr >= N || nc >= N)
				continue;
			
			if(graph[nr][nc] == 1 && visited[nr][nc] == false) {
				visited[nr][nc] = true;
				num++;
				dfs(nr, nc);
			}
		}
		return (num+1);
	}
}
