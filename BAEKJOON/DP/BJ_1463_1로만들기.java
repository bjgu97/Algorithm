package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ_1463_1로만들기 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int cnt = 0;
		while(true) {
			if(N % 3 == 0) {
				N = N / 3;
				
			}
			else if(N % 2 == 0) {
				N = N / 2;
			}
			else {
				N = N -1;
			}
		}
	}
}
