import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_11051_이항계수2 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		int[][] dp = new int[N+1][K+1];
		
		System.out.println(BC(N, K, dp) % 10007);
	}
	
	static int BC(int N, int K, int[][] dp) {
		if(dp[N][K] > 0)
			return dp[N][K];
		
		if(N == K || K == 0)
			return 1;
		
		return BC(N-1, K-1, dp) + BC(N-1, K, dp);
		
	}
}
