import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_12847_꿀아르바이트 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken()); // 월세 내기 전날
		int M = Integer.parseInt(st.nextToken()); // 일을 할 수 있는 날
		int[] arr = new int[N];
		
		st = new StringTokenizer(br.readLine());
		
		for(int n = 0; n < N; n++) {
			arr[n] = Integer.parseInt(st.nextToken());
		}

		long sum = 0;
		for(int m = 0; m < M; m++) {
			sum += arr[m]; // 0~M-1 합 구해놓기.
		}

		long max = sum;
		
		// 슬라이딩윈도우. 
		for(int n = M; n < N; n++) {
			sum += arr[n];
			sum -= arr[n-M];
			max = Math.max(max, sum);
		}
		
		System.out.println(max);
	}
}
