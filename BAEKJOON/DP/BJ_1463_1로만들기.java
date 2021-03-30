package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BJ_1463_1로만들기 {
	static int N;
	static int[] mem;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		mem = new int[N+1];
		
		Arrays.fill(mem, Integer.MAX_VALUE);
		
		mem[1] = 0;
		
		bottomUp(N);
	}
	
	static void bottomUp(int n) {
		for(int i = 2; i <= n; i++) {
			 mem[i] = mem[i-1] + 1; // 1을 뺴주기
			 
			 if(i % 3 == 0) { // 3으로 나누어 떨어지면
				 mem[i] = Math.min(mem[i], mem[i/3] + 1);
			 }
			 
			 if(i % 2 == 0) { // 2로 나누어떨어지면
				 mem[i] = Math.min(mem[i], mem[i/2] + 1);
			 }
			 
		}
		
		System.out.println(mem[N]);
	}
}
