

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class BJ_16432_떡장수와호랑이 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine()); // 떡 팔아야하는 날의 수
		
//		ArrayList<ArrayList<Integer>> map = new ArrayList<>();
//		
//		for(int n = 0; n < N; n++) {
//			map.add(new ArrayList<>());
//		}
//		
//		for(int n = 0; n < N; n++) {
//			StringTokenizer st = new StringTokenizer(br.readLine());
//			int M = Integer.parseInt(st.nextToken());
//			for(int m = 0; m < M; m++) {
//				map.get(n).add(Integer.parseInt(st.nextToken()));
//			}
//		}
		
		int[][] map = new int[N][10];
		boolean[][] visited = new boolean[N][10];
		
		for(int n = 0; n < N; n++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int M = Integer.parseInt(st.nextToken());
			for(int m = 0; m < M; m++) {
				map[n][m+1] = Integer.parseInt(st.nextToken());
			}
		}
		dfs(0, 0, visited, map, sb, N);
	}
	
	static void dfs(int cnt, int start, boolean[][] visited, int[][] map, StringBuilder sb, int N) {
		if(cnt == N) {
			System.out.println(Arrays.toString(numbers));
			return;
		}
		
		for(int i = 0; i < 10; i++) {
			if(visited[cnt+1][i])
				continue;
			if(i == start)
				continue;
			if(map[cnt][i] == 1) {
				visited[cnt+1][i] = true;
				numbers[cnt] = i;
				dfs(cnt+1, i, visited, map, numbers, N);
			}
			
		}
	}
}
