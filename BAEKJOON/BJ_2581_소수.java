

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BJ_2581_소수 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int M = Integer.parseInt(br.readLine());
		int N = Integer.parseInt(br.readLine());
		
		boolean[] check = new boolean[51];
		check[1] = true;
		for(int i= 2; i <= 50; i++) {
			for(int j = i * 2; j <= 50; j+=i) {
				check[j] = true;
			}
		}
		
		
		int min = N;
		int sum = 0;
		for(int i = M; i <= N; i++) {
			if(check[i] != true) {
				sum += i;
				min = Math.min(min, i);
			}
		}
		
		if(sum != 0) {
			System.out.println(sum);
			System.out.println(min);
		}
		else
			System.out.println(-1);
		}
	
}
