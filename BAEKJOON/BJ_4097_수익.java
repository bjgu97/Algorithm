import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_4097_수익 {
	// 구간합 문제와 동일. 
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		while(true) {
			int N = Integer.parseInt(br.readLine());
	
			if(N == 0)
				break;
			
			int[] NArr= new int[N];
			
			for(int n = 0; n < N; n++) {
				NArr[n] = Integer.parseInt(br.readLine());
			}
				
			int[] dp = new int[N];
			
			dp[0] = NArr[0];
			int answ = Integer.MIN_VALUE;
			
			for(int n = 1; n < N; n++) {
				dp[n] = Math.max(dp[n-1] + NArr[n], NArr[n]); // arr의 값과 dp+arr 값 계속 비교. 
				answ = Math.max(answ, dp[n-1]); // 이거 안해줘서 틀림. 
			}
			
			answ = Math.max(answ, dp[N-1]); 
			System.out.println(answ);
		}
		
	}
}
