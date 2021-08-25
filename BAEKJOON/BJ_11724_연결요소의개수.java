

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_11724_연결요소의개수 {
	static int N;
	static int M;
	static int[][] graph;
	static boolean[] visited;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken()); // 정점의 개수
		M = Integer.parseInt(st.nextToken()); // 간선의 개수
		
		graph = new int[N+1][N+1];
		visited = new boolean[N+1];
		for(int m = 0; m < M; m++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			graph[a][b] = 1;
			graph[b][a] = 1;
		}
		int cnt = 0;
		
		for(int i = 1; i <= N; i++) {
			if(visited[i]== false) {
				dfs(i);
				cnt++;
			}
			
		}
		
		System.out.println(cnt);
	}
	
	static void dfs(int idx) {
		visited[idx] = true;
		
		for(int m = 1; m <= N; m++) {
			if(graph[idx][m] == 1 && visited[m] == false) {
				dfs(m);
			}
		}
	}
}
