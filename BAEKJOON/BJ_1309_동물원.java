/**
n = 1부터 4까지 다 세어본 후 규칙 찾기
*/


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ_1309_동물원 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine()); // 우리의 크기
		long[] dp = new long[100001];
		dp[0] = 1;
		dp[1] = 3;
		
		for(int n = 2; n <= N; n++) 
			dp[n] = (dp[n-1] * 2 + dp[n-2]) % 9901;
		
		System.out.println(dp[N]);
	}
}
