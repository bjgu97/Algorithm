import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_11659_구간합구하기4 {
	public static void main(String[] args) throws IOException {
		// i부터 j번째 수까지 합?
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(st.nextToken()); // 수 개수
		int M = Integer.parseInt(st.nextToken()); // 합 구해야하는 횟수
		
		int[] arr = new int[N];
		int[] dp = new int[N+1];
		st = new StringTokenizer(br.readLine());
		for(int n = 0; n < N; n++) {
			arr[n] = Integer.parseInt(st.nextToken());
		}
		
		for(int n = 0; n < N; n++) {
			dp[n+1] = dp[n] + arr[n];
		}
//		System.out.println(Arrays.toString(dp));
		for(int m = 0; m < M; m++) {
			st = new StringTokenizer(br.readLine());
			int i = Integer.parseInt(st.nextToken());
			int j = Integer.parseInt(st.nextToken());
			
			sb.append(dp[j] - dp[i-1]).append("\n");
		}
		
		System.out.println(sb);
	}
}
