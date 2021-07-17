import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;



public class BJ_20300_서강근육맨 {
	public static void main(String[] args) throws IOException {
		// N개의 운동기구, 한번에 2개까지 선택 가능
		// 근손실 정도 M 넘지 않도록
		// M 최소값
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		long[] arr = new long[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int n = 0; n < N; n++) {
			arr[n] = Long.parseLong(st.nextToken());
		}
		
		Arrays.sort(arr);
		
		long max = 0;
		if(N % 2 == 0) {
			for(int i = 0; i < N/2; i++) {
				max = Math.max(max, arr[i] + arr[N-1-i]);
			}
		}
		else {
			if(N == 1) {
				max = arr[0];
			}
			else {
				for(int i = 0; i < (N-1); i++) {
					max = Math.max(max,  arr[i] + arr[N-2-i]);
				}
			}
		}
		
		System.out.println(max);
	}
}
