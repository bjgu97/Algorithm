package study8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_18310_안테나 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine()); // 집의 수
		st = new StringTokenizer(br.readLine());
		int[] arr = new int[N];
		for(int n = 0; n < N; n++) {
			arr[n] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(arr);
				
		if(arr.length%2 == 0) { // 짝수개면 둘 중 작은거
			System.out.println(arr[N/2-1]);
		}
		else //홀수개면 가운데값
			System.out.println(arr[N/2]);
	}
}
