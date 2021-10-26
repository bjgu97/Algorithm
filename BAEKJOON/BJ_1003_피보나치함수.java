import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ_1003_피보나치함수 {
	static int zeroCnt;
	static int oneCnt;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		int[] dp1 = new int[41];
		int[] dp2 = new int[41];
		
		dp1[0] = 1;
		dp1[1] = 0;
		dp2[0] = 0;
		dp2[1] = 1;
		
		for(int n = 2; n <= 40; n++) {
			dp1[n] = dp1[n-1] + dp1[n-2];
			dp2[n] = dp2[n-1] + dp2[n-2];
		}
		
		for(int t = 0; t < T; t++) {
			int N = Integer.parseInt(br.readLine());
			sb.append(dp1[N]).append(" ").append(dp2[N]).append("\n");
		}
		System.out.println(sb);
	}

}
