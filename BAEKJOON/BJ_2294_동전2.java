

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_2294_동전2 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int L = Integer.parseInt(st.nextToken());
		
		int[] arr = new int[N+1];
		for(int n = 0; n < N; n++) {
			arr[n] = Integer.parseInt(br.readLine());
		}
		
		int[] dp = new int[L+1];
		
		for(int i = 0; i < dp.length; i++) {
			dp[i] = Integer.MAX_VALUE;
		}
		
		dp[0] = 0;
		
		for(int i= 1; i < N; i++) {
			
		}
	}
}
