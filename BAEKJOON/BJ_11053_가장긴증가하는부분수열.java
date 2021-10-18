

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_11053_가장긴증가하는부분수열 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int A = Integer.parseInt(br.readLine()); // 수열의 크기(1000)
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int[] arr = new int[A];
		for(int a = 0; a < A; a++) {
			arr[a] = Integer.parseInt(st.nextToken());
		}
		
		int[] dp = new int[A];
		Arrays.fill(dp, 1);
		for(int a = 1; a < A; a++) {
			int max = 0;
			for(int d = 0; d < a; d++) {
				if(arr[a] > arr[d]) {
					max = Math.max(max,dp[d]);
				}
				
			}
			dp[a] += max;
		}
		
		Arrays.sort(dp);
		System.out.println(dp[A-1]);
	}
}
