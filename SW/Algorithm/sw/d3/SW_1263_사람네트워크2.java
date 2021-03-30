package Algorithm.sw.d3;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class SW_1263_사람네트워크2 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\bjgu9\\OneDrive\\바탕 화면\\input.txt"));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		for(int tc = 0; tc < T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken()); // 사람 수
			int[][] dist = new int[N][N];
			
			final int INF = (int)1e9;
			  
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < N; j++) {
					dist[i][j] = Integer.parseInt(st.nextToken());
					if(i != j && dist[i][j] == 0)
						dist[i][j] = INF;
				}
			}
			
//			for(int[] a : map)
//				System.out.println(Arrays.toString(a));
//			System.out.println();
			
			for(int k = 0; k < N; k++) {
				for(int i = 0; i < N; i++) {
					if(i == k)
						continue;
					for(int j = 0; j < N; j++) {
						if(i == j && k == j)
							continue;
//						if(dist[i][k] != Integer.MAX_VALUE && dist[k][j] != Integer.MAX_VALUE && dist[i][j] > dist[i][j] + dist[k][j]) {
//							dist[i][j] = dist[i][k] + dist[k][j];
//						}
						dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
					}
				}
			}
			
//			for(int[] a : dist)
//				System.out.println(Arrays.toString(a));
//			System.out.println();
			
			int min = INF;
			for(int i = 0; i < N; i++) {
				int sum = 0;
				for(int j = 0; j < N; j++) {
					sum += dist[i][j];
				}
				min = Math.min(min, sum);
				}
			
			sb.append("#").append(tc+1).append(" ").append(min).append("\n");
			}
			
		System.out.println(sb);
		}
	}

