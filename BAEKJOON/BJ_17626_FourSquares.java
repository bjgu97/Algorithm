import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ_17626_FourSquares {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		// 1 : 1 (1) = dp[1]
		// 2 : 2 (1+1) = dp[1] +  1
		// 3 : 3 (1+1+1) = dp[2] + 1
		
		// 4 : 1 (4) = d[4]
		// 5 : 2 (4 + 1) = dp[4] + 1
		// 6 : 3 (4 + 1 + 1) = dp[5] + 1
		// 7 : 4 (4 + 1 + 1 + 1) = dp[6] + 1
		// 8 : 2 (4 + 4) = 
		
		// 9 : 1 (9)
		
		int[] dp = new int[50000];
		
		dp[0] = 0;
		dp[1] = 1;
		
		dp[2] = dp[1] + 1;
		dp[3] = dp[2] + 1;
		
		dp[4] = Math.min(dp[3], dp[0]) + 1;
	}
}
