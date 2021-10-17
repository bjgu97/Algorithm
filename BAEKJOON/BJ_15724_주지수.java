import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_15724_주지수 {
	public static void main(String[] args) throws IOException {
		
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	StringTokenizer st = new StringTokenizer(br.readLine());
	StringBuilder sb = new StringBuilder();
	
	int N = Integer.parseInt(st.nextToken());
	int M = Integer.parseInt(st.nextToken());
	
	int[][] arr = new int[N][M];
	int[][] dp = new int[N+1][M+1];
	
	for(int n = 0; n < N; n++) {
		st = new StringTokenizer(br.readLine());
		for(int m = 0; m < M; m++) {
			arr[n][m] = Integer.parseInt(st.nextToken());
		}
	}
	
	for(int n = 1; n <= N; n++) {
		for(int m = 1; m <= M; m++) {
			dp[n][m] = arr[n-1][m-1] + dp[n-1][m] + dp[n][m-1] - dp[n-1][m-1];
		}
	}
	
	int K = Integer.parseInt(br.readLine());
	
	for(int k = 0; k < K; k++) {
		st = new StringTokenizer(br.readLine());
		int x1 = Integer.parseInt(st.nextToken());
		int y1 = Integer.parseInt(st.nextToken());
		int x2 = Integer.parseInt(st.nextToken());
		int y2 = Integer.parseInt(st.nextToken());

		sb.append(dp[x2][y2] - dp[x2][y1-1] - dp[x1-1][y2] + dp[x1-1][y1-1]).append("\n");
	}
	
	System.out.println(sb);
	}
}