import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_11050_이항계수1 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		System.out.println(func(N, K));
	}
	
	static int func(int N, int K) {
		// N C K
		
		int chi = N;
		int chiTemp = chi;
		
		if(K == 0)
			return 1;
		else {
			for(int k = 0; k < K-1; k++) {
				chiTemp -= 1;
				chi = chi * chiTemp;
				
			}
			
			int par = 1;
			while(true) {
				par = par * K;
				K = K-1;
				
				if(K == 0)
					break;
			}
			return chi / par;

		}
	}
}
