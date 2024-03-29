

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_11055_가장큰증가부분수열 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		int[] dp = new int[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for(int n = 0; n < N; n++) {
			int num = Integer.parseInt(st.nextToken());
			arr[n] = num;
			dp[n] = num;
		}
		
		for(int i = 1; i < N; i++) {
			int max = 0;
			for(int j = 0; j < i; j++) {
				if(arr[j] < arr[i]) {
					max = Math.max(max, dp[j]);
				}
			}
			dp[i] += max;
		}
		
		Arrays.sort(dp);
		System.out.println(dp[N-1]);
	}
}
