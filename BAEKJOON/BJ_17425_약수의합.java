import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BJ_17425_약수의합 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		// f(A) : A의 모든 약수 더한 값
		// g(x): x보다 작은 모든 자연수 y의 f(y) 더한 값
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		long[] dp = new long[1000001];
		
		Arrays.fill(dp, 1);
		
		for(int i = 2; i <= 1000000; i++) {
			for(int j = 1; i*j <= 1000000; j++) {
				
				dp[i*j] += i;
			}
		}
		// 1 2 3 4 5
		// 1 3 6 10 15
		long[] dpSum = new long[1000001];
		
		for(int i= 1; i <= 1000000; i++) {
			dpSum[i] = dpSum[i-1] + dp[i];
		}
		
		for(int t = 0; t < T; t++) {
			int N = Integer.parseInt(br.readLine());
			sb.append(dpSum[N]).append("\n");
		}
		System.out.println(sb);
	}
}
