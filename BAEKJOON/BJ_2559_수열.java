

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 이게 왜 됐지...?

public class BJ_2559_수열 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken()); // 전체 날짜 수
		int K = Integer.parseInt(st.nextToken()); // 연속적인 날짜 수
		
		st = new StringTokenizer(br.readLine());
		int[] NArr = new int[N];
		for(int n = 0; n < N; n++) {
			NArr[n] = Integer.parseInt(st.nextToken());
		}
		int sum = 0;
		int maxSum = Integer.MIN_VALUE;
		for(int n = 0; n < N-K+1; n++) {
			sum = 0;
			for(int k = n; k < n+K; k++) {
				sum += NArr[k];
			}
			maxSum = Math.max(sum, maxSum);
			
		}
		
		System.out.println(maxSum);
	}
}
