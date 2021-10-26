

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_1654_랜선자르기 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int K = Integer.parseInt(st.nextToken()); // 10000
		int N = Integer.parseInt(st.nextToken()); // 1000000
		
		// N개 이상의 같은 길이의 랜선 만들어야함.
		// K개 랜선 갖고있음
		// 만들 수 있는 최대 랜선의 길이??
		
		int[] KArr = new int[K];
		for(int k = 0; k < K; k++) {
			KArr[k] = Integer.parseInt(br.readLine());
		}
		
		long start = 0;
		long end = Integer.MAX_VALUE;
//		Arrays.sort(KArr);
		while(start <= end) {
			long mid = (start + end) / 2;
			long cnt = 0;
			for(int k = 0; k < K; k++) {
				cnt += KArr[k] / mid;
			}
			if(cnt >=  N) {
				start = mid + 1;
			}
			else {
				end = mid - 1;
			};

		}
		System.out.println(end);
	}
}
