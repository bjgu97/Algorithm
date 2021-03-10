package study9;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_5567_결혼식 {
	static int N;
	static int M;
	static int[][] graph;
	static boolean[] visited;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine()); // 동기 수
		M = Integer.parseInt(br.readLine()); // 리스트 길이
		graph = new int[N+1][N+1];
		
		for(int m = 0; m < M; m++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			graph[a][b] = 1;
			graph[b][a] = 1;
		}

		visited = new boolean[N+1];
		
		dfs(1, 0); // 상근이 학번은 1
		
		int a = 0;
		for(int i = 0; i < visited.length; i++) {
			if(visited[i] == true)
				a++;
		}
		System.out.println(a-1);

	}

	static int depth;
	static boolean flag;
	static int answ;
	static void dfs(int n, int depth) { // 1
		if(depth == 2) { // 친구:1, 친구의 친구:2
			return;
		}
		
		for(int i = 1; i <= N; i++) { // 1 2 3 4 5
			if(graph[n][i] == 1) {
				visited[i] = true;
				dfs(i, depth + 1);
			}
		}
	}
}



