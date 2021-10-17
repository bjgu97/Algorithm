import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_11060_점프점프 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int[] dp = new int[N];
		int[] arr = new int[N];
		
		for(int n = 0; n < N; n++) {
			arr[n] = Integer.parseInt(st.nextToken());
			dp[n] = -1; // dp 초기화
		}
		
		dp[0] = 0;
		
		for(int n = 1; n < N; n++) {
			for(int m = 0; m < n; m++) {
//				System.out.println("n, m: " + n + "," + m);
				if(dp[m] != -1 && n-m <= arr[m]) {
					if(dp[n] == -1 || dp[n] > dp[n] + 1) {
						dp[n] = dp[m] + 1;
					}
				}
//				System.out.println(Arrays.toString(dp));
//				System.out.println();
			}
		}
		
		System.out.println(dp[N-1]);
	}
}
