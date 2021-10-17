import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_16401_과자나눠주기 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int M = Integer.parseInt(st.nextToken()); // 조카 수
		int N = Integer.parseInt(st.nextToken()); // 과자 수
		
		st = new StringTokenizer(br.readLine());
		
		int[] arr = new int[N]; // 각 과자 길이
		for(int n = 0; n < N; n++) {
			arr[n] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(arr);
		
		long low = 1; // 예외처리
//		int high = arr[N-1] + 1;
		long high = Integer.MAX_VALUE;
		long answer = 0;
		
		while(low <= high) {
			// mid : 나눠줄 수 있는 과자의 길이 <- 최대값 구해야함.
			// (low + high) / 2 , 즉 중간값부터 시작해서 과자 길이를 늘리거나 줄여간다.
			long mid = (low + high) / 2; 
			
			System.out.println("mid: " + mid);
			// cnt : 나눠줄 수 있는 과자의 개수
			// 문제 조건에서 "과자는 길이와 상관 없이 여러 조각으로 나눠줄 수 있다고" 했으므로,
			// 과자 길이(arr[n]) / mid(변하는(?)과자 길이) 값 만큼 나눠줄 수 있는 과자가 생기는 것이다.
			int cnt = 0;
			for(int n = 0; n < N; n++) {
				cnt += arr[n] / mid; 
			}
			
			if(cnt >= M) {
				low = mid + 1;
				answer = mid;
			}
			
			else {
				high = mid - 1;
			}
		}
		
		System.out.println(answer);
	}
}
