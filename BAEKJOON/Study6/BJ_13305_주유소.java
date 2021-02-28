package Study6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_13305_주유소 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine()); // 도시의 개수
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		long[] len = new long[N-1];
		for(int n = 0; n < N-1; n++) {
			len[n] = Long.parseLong(st.nextToken()); // 도로의 길이
		}
		long[] price = new long[N];
		st = new StringTokenizer(br.readLine());
		for(int n = 0; n < N; n++) {
			price[n] = Long.parseLong(st.nextToken()); // 리터당 가격
		}
		
		/*
		 4
 		 2 3 1
		 5 2 4 1
		 */
		
		// 초기 가격
		long minP = price[0];
		long answ = minP * len[0]; // 초기값
		
		for(int i = 1; i < N-1; i++) {
			if(minP > price[i])  { // 더 싼 가격이 나오면
				minP = price[i]; // 가격 업데이트
			}
			// 업데이트 전까지의 비용 계산
			answ += len[i] * minP;
		}
			System.out.println(answ);
		
		
	}
}
