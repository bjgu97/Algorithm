package 그리디;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_11047_동전 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken()); // 가지고있는 동전 종류
		int K = Integer.parseInt(st.nextToken()); // 가치의 합
		
		int[] NArr = new int[N];
		for(int n = 0; n < N; n++) {
			NArr[N-n-1] = Integer.parseInt(br.readLine());
		}
		
		int sum = 0;
		int cnt = 0;
		
		for(int n = 0; n < N; n++) {
			if(NArr[n] > K)
				continue;
			else {
				cnt += K/NArr[n];
				K = K % NArr[n];
			}
		}
		
		System.out.println(cnt);
		/*
		for(int n = 0; n < N; n++) {
			// K보다 크면 continue
			// K 보다 작으면 K 안넘을때까지 ++
			if(NArr[n] > K)
				continue;
			else {
				while(true) {
					sum += NArr[n];
					cnt++;
					if(sum > K) {
						sum = sum - NArr[n];
						cnt--;
						break;
					}
				}
			}
		}
		*/
	}
}
