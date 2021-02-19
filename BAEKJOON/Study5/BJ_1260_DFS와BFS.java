/**
* @since 2021. 2. 19.
* @author bjgu9
* @see https://www.acmicpc.net/problem/1260
* @mem 10536
* @time 236
* @caution BFS, DFS 기본 구현하기? 공식처럼 외워서
*/
package Study5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_1260_DFS와BFS {
	static int[][] graph;
	static boolean[] visited;
	
	static int N;
	static int M;
	static int V;
	
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken()); // 정점의 개수 (1번 ~ N번)
		M = Integer.parseInt(st.nextToken()); // 간선의 개수 
		V = Integer.parseInt(st.nextToken()); // 시작 정점의 번호
		
		graph = new int[N+1][N+1]; // 1부터 시작하므로 N+1
		// 인접리스트로 풀어보기!
		
		
		// 입력받기
		for(int i = 0; i < M; i++) { 
			st = new StringTokenizer(br.readLine());
			
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			graph[a][b] = 1;
			graph[b][a] = 1;
		}
		
		
		visited = new boolean[N+1]; 
		dfs(V);
		sb.append("\n");
		
		visited = new boolean[N+1];
		bfs(V);
		
		System.out.println(sb);
	}
	
	//dfs
	public static void dfs(int start) {
		visited[start] = true; 
		sb.append(start).append(" "); 
		
		for(int j = 1; j <= N; j++) {
			if(graph[start][j] == 1 && visited[j] == false) { 
				dfs(j);
			}
		}
	}
	
	
	//bfs
	public static void bfs(int start) {
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.offer(start); 
		visited[start] = true; 
		sb.append(start).append(" ");
		
		while(!queue.isEmpty()) {
			int tmp = queue.poll(); 
		
			for(int j = 1; j <= N; j++) { 
				if(graph[tmp][j] == 1 && visited[j] == false) {
					queue.offer(j); 
					visited[j] = true; 
					sb.append(j).append(" ");
				}
			}
		}
	}
}
