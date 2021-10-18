import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_11722_가장긴감소하는부분수열 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		int[] arr = new int[N];
		int[] dp = new int[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int n = 0; n < N; n++) {
			arr[n] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.fill(dp, 1);
		for(int n = 1; n < N; n++) {
			int max = 0;
			for(int m = 0; m < n; m++) {
				if(arr[n] < arr[m]) {
					max = Math.max(max, dp[m]);
				}
			}
			dp[n] += max;
		}
		
		Arrays.sort(dp);
		System.out.println(dp[N-1]);
	}
}
