package 실버;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ_11653_소인수분해 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		// 일단 소수부터 찾기
//		boolean[] check = new boolean[10000001];
//		for(int i = 2; i <= 10000000; i++) {
//			for(int j = i * 2; j <= 10000000; j+= i) {
//				check[j] = true;
//			}
//		}
				
//		int cnt = 2;
//		while(true) {
//			// cnt가 소수이고 나누어 쩔어지면
//			if(check[cnt] == false && N%cnt == 0) {// 소수이면 
//				System.out.println(cnt);
//				N = N / cnt;
//				continue;
//			}
//			else if(N == 1) {
//				break;
//			}
//			cnt++;
//		}

		for(int i = 2; i <= Math.sqrt(N); i++) {
			// N이 i로 나누어 떨어지면
			if(N%i == 0) {
				while(N%i == 0) {
					System.out.println(i);
					N = N / i;
				}
			}
		}
		
		if(N != 1)
			System.out.println(N);
	}
}
