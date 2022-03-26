import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_11052_카드구매하기 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		int[] arr = new int[N+1];
		int[] dp = new int[N+1];
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for(int n = 1; n <= N; n++) {
			arr[n] = Integer.parseInt(st.nextToken());
			dp[n] = arr[n];
		}
		
		for(int n = 1; n <= N; n++) {
			for(int m = 1; m <= N; m++) {
				if(n-m < 0) continue;
				dp[n] = Math.max(dp[n], dp[n-m] + arr[m]);
			}
		}
		
		System.out.println(dp[N]);
	}
}
