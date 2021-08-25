

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ_2748_피보나치수2 {
	static long[] arr;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine()); // N번째 피보나치 수
		
		arr = new long[N+1];
		
		for(int i = 0; i < arr.length; i++) {
			arr[i] = -1;
		}
		arr[0] = 0;
		arr[1] = 1;
		
		System.out.println(fibo(N));
	}
	
	static long fibo(int n) {
		if(arr[n] == -1) // 비어있으면
			arr[n] = fibo(n-1) + fibo(n-2);
		
		return arr[n];
	}
}
