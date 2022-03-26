import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_11047_동전0 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		int[] Coins = new int[N];
		for(int n = 0; n < N; n++) {
			Coins[n] = Integer.parseInt(br.readLine());
		}
		int answer = 0;
		for(int c = N-1; c >= 0; c--) {
			if(K / Coins[c] != 0) { // 동전 사용 가능하면
				answer += K / Coins[c];
				K = K % Coins[c];
			}
		}
		
		System.out.println(answer);
	}
}
