

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_2294_동전2 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int L = Integer.parseInt(st.nextToken());
		
		int[] arr = new int[N+1];
		for(int n = 0; n < N; n++) {
			arr[n] = Integer.parseInt(br.readLine()); // 동전
		}
		
		int[] dp = new int[L+1];
		
		for(int i = 0; i < dp.length; i++) {
			dp[i] = Integer.MAX_VALUE;
		}
		
		Arrays.fill(dp, Integer.MAX_VALUE);
		dp[0] = 0;
		
		for(int i= 1; i <= L; i++) {
			for(int j = 0; j < N; j++) {
				if(i - arr[j] < 0) continue;
				if(dp[i-arr[j]] == Integer.MAX_VALUE)
					dp[i] = Math.min(dp[i], dp[i-arr[j]]);
				else
					dp[i] = Math.min(dp[i], dp[i-arr[j]]+1);
			}
		}
		
//		System.out.println(Arrays.toString(dp));
		if(dp[L] == Integer.MAX_VALUE)
			System.out.println(-1);
		else
			System.out.println(dp[L]);
			
	}
}
