

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_1932_정수삼각형 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[][] dp = new int[N][N];
		int[][] arr = new int[N][N];
		
		for(int n = 0; n < N; n++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int m = 0; m < n+1; m++) {
				arr[n][m] = Integer.parseInt(st.nextToken());				
			}
		}
		
//		for(int[] a : arr)
//			System.out.println(Arrays.toString(a));
		
		dp[0][0] = arr[0][0];
		
	for(int n = 1; n < N; n++) {
		for(int m = 0; m < n+1; m++) {
			if(m == 0)
				dp[n][m] = dp[n-1][0] + arr[n][m];
			else if(m == n) 
				dp[n][m] = dp[n-1][n-1] + arr[n][m];
			else
				dp[n][m] = Math.max(dp[n-1][m-1], dp[n-1][m]) + arr[n][m];
		}
	}
	
//	for(int[] a : dp)
//		System.out.println(Arrays.toString(a));
	int max = 0;
	for(int a : dp[N-1])
		max = Math.max(max, a);
	
	System.out.println(max);
	}
}
