package Algorithm.sw.d3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class SW_1219_길찾기2 {
	static int[][] graph;
	static boolean check;
	static boolean[][] visited;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		for(int tc = 0; tc < 10; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int T = Integer.parseInt(st.nextToken()); // 테케 번호
			int L = Integer.parseInt(st.nextToken()); // 길의 총 개수
			
			visited = new boolean[100][2];
			graph = new int[100][2];

			st = new StringTokenizer(br.readLine());
			for(int l = 0; l < L; l++) {
				int start = Integer.parseInt(st.nextToken());
				int end = Integer.parseInt(st.nextToken());
				
				if(graph[start][0] == 0)
					graph[start][0] = end;
				else
					graph[start][1] = end;
			}
			
//			System.out.println(graph);
			check = false;
			bfs(0);
			sb.append("#").append(T).append(" ");
			if(check) 
				sb.append(1).append("\n");
			else
				sb.append(0).append("\n");
		}
		
		System.out.println(sb);
	}
	
	static void bfs(int start) {
		Queue<Integer> queue = new LinkedList<>();
		queue.offer(start);
		visited[0][0] = true;
		
		while(!queue.isEmpty()) {
			int p = queue.poll();
			for(int i= 0; i < graph[p].length; i++) {
				int np = graph[p][i];
				
				if(np == 99)
					check = true;
				
				if(visited[np][i] == true)
					continue;
				
				queue.offer(np);
				visited[np][i] = true;
			}
		}
	}
}



// 구본정 - bfs + 행렬
