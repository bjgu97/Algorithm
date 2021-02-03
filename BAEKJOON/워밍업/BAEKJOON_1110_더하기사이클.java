package 워밍업;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BAEKJOON_1110_더하기사이클 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int M = N;
		int cnt = 0;
		while(true) {
			int a = N/10;
			int b = N%10;
			int newN = 10*b + (a+b)%10;
			N = newN;
			
			cnt++;
			if(N == M)
				break;
		}
		
		System.out.println(cnt);
	}
}
