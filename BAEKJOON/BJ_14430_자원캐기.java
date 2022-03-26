import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_14430_자원캐기 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st= new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int[][] map = new int[N][M];
		int[][] dp = new int[N][M];
		
		for(int n = 0; n < N; n++) {
			st = new StringTokenizer(br.readLine());
			for(int m =0; m < M; m++) {
				map[n][m] = Integer.parseInt(st.nextToken());
			}
		}
		
		dp[0][0] = map[0][0];
		for(int n = 0; n < N; n++) {
			for(int m = 0; m < M; m++) {
				// 첫째줄은 그대로
				if(n == 0) {
					if(m == 0) continue;
					dp[n][m] = map[n][m] + Math.max(dp[n][m-1], dp[n][m]);
					continue;
				}
				
				if(m == 0) {
					dp[n][m] = map[n][m] + Math.max(dp[n-1][m], dp[n][m]);
					continue;
				}
				
				dp[n][m] = map[n][m] + Math.max(dp[n-1][m], dp[n][m-1]);
			}
		}
		for(int[] a : dp)
			System.out.println(Arrays.toString(a));
		System.out.println(dp[N-1][M-1]);
		
	}
}
