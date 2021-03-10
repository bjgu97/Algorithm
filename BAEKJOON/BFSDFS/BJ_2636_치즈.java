package BFSDFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_2636_치즈 {
	static int R;
	static int C;
	static int[][] graph;
	static int[][] visited;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int R = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		
		graph = new int[R][C];
		for(int r = 0; r < R; r++) {
			st = new StringTokenizer(br.readLine());
			for(int c = 0; c < C; c++) {
				graph[r][c] = Integer.parseInt(st.nextToken());
			}
		}
		
//		for(int[] a : graph)
//			System.out.println(Arrays.toString(a));
		
		bfs();
	}
	
	static void bfs() {
		
	}
}
