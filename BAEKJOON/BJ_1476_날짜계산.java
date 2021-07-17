import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class BJ_1476_날짜계산 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int E = Integer.parseInt(st.nextToken());
		int S = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		while(true) {
			if(E == S && S == M) {
				System.out.println(E);
				break;
			}
			else {
				if(E <= S && E <= M) {
					E += 15;
				}
				else if(S <= E && S <= M) {
					S += 28;
				}
				else if(M <= E && M <= S) {
					M += 19;
				}
			}
		}
	}
}
