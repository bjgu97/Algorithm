import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_11660_구간합구하기5 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(st.nextToken()); // 1024
		int M = Integer.parseInt(st.nextToken()); // 100000
		
		int[][] map = new int[N+1][N+1];
		int[][] dp = new int[N+1][N+1];
		
		for(int n = 0; n < N; n++) {
			st = new StringTokenizer(br.readLine());
			for(int m = 0; m < N; m++) {
				map[n][m] = Integer.parseInt(st.nextToken());
			}
		}
		
		for(int n = 0; n <= N; n++) {
			for(int m = 0; m <= N; m++) {
				if(n == 0 || m == 0) dp[n][m] = 0;
				else {
				dp[n][m] = map[n-1][m-1] + (dp[n-1][m] + dp[n][m-1] - dp[n-1][m-1]);

				}
			}
		}
		
//		for(int[] a : dp)
//			System.out.println(Arrays.toString(a));
		for(int m = 0; m < M; m++) {
			st = new StringTokenizer(br.readLine());
			int x1 = Integer.parseInt(st.nextToken());
			int y1 = Integer.parseInt(st.nextToken());
			int x2 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());
			
//			System.out.println(dp[x2][y2] + "," + dp[0][y1-1] + "," + dp[x1-1][0] + "," + dp[x1-1][y1-1]);
			sb.append(dp[x2][y2] - (dp[x2][y1-1] + dp[x1-1][y2]) + dp[x1-1][y1-1]).append("\n");
//			System.out.println(dp[x2][y2] - (dp[x2][y1-1] + dp[x1-1][y2]) + dp[x1-1][y1-1]);
		}
		
		System.out.println(sb);
	}
}
