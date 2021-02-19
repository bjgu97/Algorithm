import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_2798_블랙잭 {
	static int[] answer = new int[3];
	static int N;
	static int M;
	static int[] NArr;
	public static void main(String[] args) throws IOException {
		// N장의 카드 중 M을 넘지 안흔ㄴ 카드 3장
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		NArr = new int[N];
		for(int n = 0; n < N; n++) {
			NArr[n] = Integer.parseInt(st.nextToken());
		}
		
		comb(0, 0);
		
		System.out.println(answ);
	}
	
	static int sum;
	static int answ;
	public static void comb(int cnt, int start) {
		sum = 0;
		if(cnt == 3) {
			for(int i = 0; i < 3; i++) {
				sum += answer[i];
			}
			if(sum > M)
				return;
			else {
				answ = Math.max(answ, sum);
			}
			return;
		}
		
		for(int i = start; i < N; i++) {
			answer[cnt] = NArr[i];
			comb(cnt+1, i+1);
			
		}
	}
}
