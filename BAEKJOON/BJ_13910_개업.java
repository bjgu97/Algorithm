import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.StringTokenizer;

public class BJ_13910_개업 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int[] MArr = new int[101];
		st = new StringTokenizer(br.readLine());
		for(int m = 1; m <= M; m++) {
			MArr[m] = Integer.parseInt(st.nextToken());
		}

		int[] dp = new int[10001];
		Arrays.fill(dp, Integer.MAX_VALUE);
		dp[0] = 0;

		
		for(int m = 1; m <= M; m++) {
			for(int n = m+1; n <= M; n++) {
				dp[MArr[m]] = 1;
				dp[MArr[n]] = 1;
				dp[MArr[m]+MArr[n]] = 1;
			}
		}
		
		for(int m = 1; m <= N; m++) {
			for(int n = m+1; n <= N; n++) {
				if(dp[n] == 1)
					continue;
//				System.out.println("m, n, n-m: " + m + "," + n + "," + (n-m));
				dp[n] = Math.min(dp[n], dp[n-m] + 1);
//				System.out.println(Arrays.toString(dp));
			}
		}
//		System.out.println(Arrays.toString(dp));
		
		System.out.println((dp[N] == Integer.MAX_VALUE) ? -1 : dp[N]);
	}
}
