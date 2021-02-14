package 수학;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class BAEKJOON_6588_골드바흐의추측 {
	static boolean[] check = new boolean[1000001]; // 소수 담을 배열 생성

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N;
		
		for(int i = 2; i <= 1000000; i++) {
			for(int j = i*2; j <= 1000000; j+=i) {
				check[j] = true; // 소수 아닌 숫자는 true로. 소수는 false.
			}
		}
		
//		System.out.println(Arrays.toString(check));
		
		while(true) {
			N = Integer.parseInt(br.readLine());
			boolean a = true;
			
			if(N == 0) // 종료 조건
				break;
			
			for(int i = 2; i <= N; i++) {
				if(!check[i] && !check[N-i]) {
					System.out.println(N + " = " + i + " + " + (N-i));
					a = false;
					break;
				}
			}
			
			if(a)
				System.out.println("Goldbach's conjecture is wrong.");
			
		}
		
	}
}
