package BFSDFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_16956_늑대와양 {
	static int R;
	static int C;
	static char[][] graph;
	static boolean[][] visited;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		graph = new char[R][C];
		visited = new boolean[R][C];
		for(int r = 0; r < R; r++) {
			String s = br.readLine();
			for(int c = 0; c < C; c++) {
				graph[r][c] = s.charAt(c);
			}
		}
		
		for(int r = 0; r < R; r++) {
			for(int c = 0; c < C; c++) {
				if(graph[r][c] == 'W') {
					bfs(r, c);
				}
			}
		}
		if(check) {
			System.out.println(1);
			for(int r = 0; r < R; r++) {
				for(int c = 0; c < C; c++) {
					System.out.print(graph[r][c]);
				}
				System.out.println();
			}
		}
		else
			System.out.println(0);
		
	}
	
	static int[][] deltas = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
	static boolean check = true;
	static void bfs(int r, int c) {
		visited[r][c] = true;
		
		for(int d = 0; d < deltas.length; d++) {
			int nr = r + deltas[d][0];
			int nc = c + deltas[d][1];
			
			if(nr < 0 || nc < 0 || nr >= R || nc >= C)
				continue;
			
			if(graph[nr][nc] == 'S') {
				check = false;
			}
			
			if(graph[nr][nc] == '.') {
				graph[nr][nc] = 'D';

				
			}
		}
	}
}
