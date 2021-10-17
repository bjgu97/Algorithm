import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_15486_퇴사2 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[][] arr = new int[N][2];
		
		for(int n = 0; n < N; n++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			arr[n][0] = Integer.parseInt(st.nextToken()); // 일
			arr[n][1] = Integer.parseInt(st.nextToken()); // 금액
		}
		
		int[] dp = new int[N];
		int max = 0;
		
		for(int i = 0; i < N; i++) {
			max = Math.max(max, dp[i]);
			if(i + arr[i][0] <= N) { // 날짜 범위 안넘어 갈 때
				dp[i + arr[i][0]] = Math.max(dp[i + arr[i][0]],max + arr[i][1]);
			}
		}
		
		System.out.println(dp[N]);
	}
}
