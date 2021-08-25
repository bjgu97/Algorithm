

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class BJ_2210_숫자판점프 {
	static int[][] graph;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		graph = new int[5][5];
		
		for(int i = 0; i < 5; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < 5; j++) {
				graph[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for(int i= 0; i < 5; i++) {
			for(int j = 0; j < 5; j++) {
				dfs(i, j, Integer.toString(graph[i][j]));
			}
		}
		
		System.out.println(set.size());
	}
	
	static int[][] deltas = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
	static Set<String> set = new HashSet<>();
	
	static void dfs(int r, int c, String s) {
		
		if(s.length() == 6) {
			set.add(s);
			return;
		}
		for(int d = 0; d < deltas.length; d++) {
			int nr = r + deltas[d][0];
			int nc = c + deltas[d][1];
			
			if(nr < 0 || nc < 0 || nr >= 5 || nc >= 5) {
				continue;
			}
			
			dfs(nr, nc, s + graph[nr][nc]);
		}
	}
}
