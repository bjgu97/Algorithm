

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_1806_부분합 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken()); // 수열 길이
		int S = Integer.parseInt(st.nextToken()); // 구하고자 하는 합
		int[] arr = new int[N];
		
		st= new StringTokenizer(br.readLine());
		for(int n = 0; n < N; n++) {
			arr[n] = Integer.parseInt(st.nextToken());
		}
		
		
		int start = 0;
		int end = 0;
		int sum = 0;
		
		int len = Integer.MAX_VALUE;
		while(true) {
			if(sum >= S) {
				len = Math.min(len, end - start);
				sum -= arr[start++];
			}
			else if(end == arr.length)
				break;
			else
				sum += arr[end++];
		}
		
		if(len == Integer.MAX_VALUE)
			System.out.println(0);
		else
			System.out.println(len);
		
		
}

}
