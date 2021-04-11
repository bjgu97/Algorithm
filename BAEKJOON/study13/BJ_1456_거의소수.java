package study13;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_1456_거의소수 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		long A = Long.parseLong(st.nextToken());
		long B = Long.parseLong(st.nextToken());
		
		boolean[] arr = new boolean[10000001]; // A 범위 최대 10^14 이니까
		
		Arrays.fill(arr, true);
		
		for(int i = 2; i < arr.length; i++) {
			for(int j = i*2; j < arr.length; j += i) {
				arr[j] = false; 
			}
		}
		
		long num = 1;
		long numSquare = 1;
		
		int cnt = 0;
		for(int i = 2; i < arr.length; i++) {
			if(i > B)
				break;
			
			if(arr[i] == true) { // 소수이면
				num = i;
				numSquare = num;
				while(numSquare <= B/num) {
					numSquare = numSquare * num;
					if(numSquare >= A && numSquare <= B) {
						cnt++;
					}
				}
			}
		}
		System.out.println(cnt);
	}
}
