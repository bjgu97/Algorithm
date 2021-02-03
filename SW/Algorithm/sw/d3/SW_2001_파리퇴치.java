package Algorithm.sw.d3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SW_2001_파리퇴치 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		// 테스트케이스 T
		int T = Integer.parseInt(br.readLine());
		
		for(int t = 0; t < T; t++) {
			// N과 M / N*N배열, 파리채사이즈 M*M
			st = new StringTokenizer(br.readLine(), " ");
			int M = Integer.parseInt(st.nextToken());
			int N = Integer.parseInt(st.nextToken());
			
			// N * N 배열 만들기
			int[][] arr = new int[M][M];
			
			for(int i = 0; i < M; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				for(int j = 0; j < M; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
//			for(int i = 0; i < M; i++) {
//				for(int j = 0; j < M; j++) {
//					System.out.print(arr[i][j] + " ");
//				}
//				System.out.println();
//			}
			
			int sum = 0;
			int maxSum = 0;
			
//			System.out.println("M: " + M + " N: " + N);
			for(int i = 0; i <= M-N; i++) { //0 `1 
				for(int j = 0; j <= M-N; j++) { //0 1 
					for(int m = 0; m < N; m++) { //0 1
						for(int n = 0; n < N; n++) { //0 1
//							System.out.println("i: " + i + " m: " + m + " j: " + j + " n: " + n);
//							System.out.println("i+m: " + (i+m) + " j+n: " + (j+n));
							sum += arr[i+m][j+n];
//							System.out.println("sum: " + sum);
						}
					}
//					System.out.println("sum: " + sum);
					maxSum = Math.max(sum, maxSum);
					sum = 0;
				}
			}
			sb.append("#").append(t+1).append(" ").append(maxSum).append("\n");			
		}
		System.out.println(sb);
	}
}
