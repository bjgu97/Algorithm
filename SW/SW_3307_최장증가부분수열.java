

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class SW_3307_최장증가부분수열 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int TC = Integer.parseInt(br.readLine());
		
		for(int tc = 0; tc < TC; tc++) {
			int A = Integer.parseInt(br.readLine());
			int[] arr = new int[A];
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int a = 0; a < A; a++) {
				arr[a] = Integer.parseInt(st.nextToken());
			}
			int[] dp = new int[A];
			Arrays.fill(dp, 1);
			
			int max = 0;
			for(int i = 1; i < A; i++) {
				for(int j = 0; j < i; j++) {
					if(arr[i] > arr[j] && dp[i] < 1 + dp[j]) {
						dp[i] = dp[j] + 1;
					}
				}
				max = Math.max(max, dp[i]);
			}
			
			sb.append("#").append(tc+1).append(" ");
			if(A == 1)
				sb.append(1).append("\n");
//				System.out.println(1);
			else
				sb.append(max).append("\n");
//				System.out.println(max);
		}
		System.out.println(sb);
	}
		
		
		
}
