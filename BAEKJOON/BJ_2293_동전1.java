import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_2293_동전1 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		int[] coin = new int[N+1];
		
		for(int i = 1; i <= N; i++) {
			coin[i] = Integer.parseInt(br.readLine());
		}
		
		int[] dp = new int[K+1];
		dp[0] = 1;
		
		for(int i= 1; i <= N; i++) {
			for(int j = 1; j <= K; j++) {
				if(j-coin[i] < 0) continue;
				dp[j] += dp[j-coin[i]];
			}
		}
		
		System.out.println(dp[K]);
	}
}
