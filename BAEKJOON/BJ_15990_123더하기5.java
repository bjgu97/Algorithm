// int 반례: 1 99991 => 252719674 
import java.io.*;
import java.util.*;

public class BJ_15990_123더하기5 {
	// 1부터 7까지 구한다음에 규칙 찾음. 
   public static void main(String[] args) throws IOException {
	   BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	   int T = Integer.parseInt(br.readLine()); // 테케 수
	   long[][] dp = new long[100001][4];
	   dp[1][1] = 1;
	   dp[1][2] = 0;
	   dp[1][3] = 0;
	   
	   dp[2][1] = 0;
	   dp[2][2] = 1;
	   dp[2][3] = 0;
	   
	   dp[3][1] = 1;
	   dp[3][2] = 1;
	   dp[3][3] = 1;
	   
	   for(int i = 4; i <= 100000; i++) { // 94퍼
		   dp[i][1] = (dp[i-1][2] + dp[i-1][3]) % 1000000009;
		   dp[i][2] = dp[i-2][1] + dp[i-2][3]% 1000000009;
		   dp[i][3] =  dp[i-3][1] + dp[i-3][2]% 1000000009;
	   }
	   
	   for(int t = 0; t < T; t++) {
		   int num = Integer.parseInt(br.readLine());
		   System.out.println((dp[num][1] + dp[num][2] + dp[num][3]) % 1000000009);
	   }
   }

}