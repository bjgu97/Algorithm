import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BJ_10026_적록색약 {
	static int N;
	static char[][] graph;
	static boolean[][] visited;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine()); 
		
		graph = new char[N][N];
		visited = new boolean[N][N];
		
		for(int n = 0; n < N; n++) {
			String s = br.readLine();
			for(int m = 0; m < N; m++) {
				graph[n][m] = s.charAt(m);
			}
		}
		int answ = 0;
		
		for(int n = 0; n < N; n++) {
			for(int m = 0; m < N; m++) {
				char c = graph[n][m];
				if((c == 'R' || c == 'G' || c == 'B') && visited[n][m] == false) {
					dfs1(n, m, c);
					answ++;
				}
			}
		}
		
		System.out.print(answ + " ");
		
		visited = new boolean[N][N];
		
		int answ2 = 0;
		for(int n = 0; n < N; n++) {
			for(int m = 0; m < N; m++) {
				char c = graph[n][m];
				if((c == 'R' || c == 'G' || c == 'B') && visited[n][m] == false) {
					dfs2(n, m, c); 
					answ2++;
				}
			}
		}
		
		System.out.println(answ2);
	}
	
	static int[][] deltas = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
	
	public static void dfs1(int r, int c, char ch) {
		visited[r][c] = true; // 방문처리 해주고
		
		for(int d = 0; d < deltas.length; d++) {
			int nr = r + deltas[d][0];
			int nc = c + deltas[d][1];
			
			if(nr < 0 || nc < 0 || nr >= N || nc >= N) {
				continue;
			}
			
			if(graph[nr][nc] == ch && visited[nr][nc] == false) {
				visited[nr][nc] = true;
				dfs1(nr, nc, ch);
			}
		}
	}
	
	public static void dfs2(int r, int c, char ch) {
		if(ch == 'R' || ch == 'G') {
			visited[r][c] = true; // 방문처리 해주고
			
			for(int d = 0; d < deltas.length; d++) {
				int nr = r + deltas[d][0];
				int nc = c + deltas[d][1];
				
				if(nr < 0 || nc < 0 || nr >= N || nc >= N) {
					continue;
				}
				
				if((graph[nr][nc] == 'R' || graph[nr][nc] == 'G') && visited[nr][nc] == false) {
					visited[nr][nc] = true;
					dfs2(nr, nc, ch);
				}
			}
		}
		
		if(ch == 'B') {
			visited[r][c] = true; // 방문처리 해주고
			
			for(int d = 0; d < deltas.length; d++) {
				int nr = r + deltas[d][0];
				int nc = c + deltas[d][1];
				
				if(nr < 0 || nc < 0 || nr >= N || nc >= N) {
					continue;
				}
				
				if(graph[nr][nc] == ch && visited[nr][nc] == false) {
					visited[nr][nc] = true;
					dfs2(nr, nc, ch);
				}
			}
		}

	}
}
