package BFSDFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_2644_촌수계산 {
	static int M;
	static int N;
	static int[][] graph;
	static int[] visited;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine()); // 총 사람 수
		
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		// 촌수 계산해야하는 두 사람의 번호
		int start = Integer.parseInt(st.nextToken());
		int end = Integer.parseInt(st.nextToken());
		
		M = Integer.parseInt(br.readLine());
		
		graph = new int[N+1][N+1];
		visited = new int[N+1];
		
		for(int m = 0; m < M; m++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			graph[a][b] = 1;
			graph[b][a] = 1;
		}
		queue.offer(start); // 시작 좌표 넣어주기
		visited[start] = 0;
		
		bfs(end);
	}
	
	static Queue<Integer> queue = new LinkedList<Integer>();
	static int cnt;
	
	static void bfs(int end) {
		while(!queue.isEmpty()) {
			int n = queue.poll();
			if(n == end) {
				System.out.println(visited[n]);
				return;
			}
			
			for(int i = 1; i <=N; i++) {
				if(visited[i] == 0 && graph[n][i] == 1) {
					visited[i] = visited[n] + 1;
					queue.offer(i);
				}
			}
			cnt++;
		}
		System.out.println(-1);
	}
}
