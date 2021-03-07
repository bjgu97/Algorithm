package 실버;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ_4948_베르트랑공존 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		boolean[] check = new boolean[300001];
		
		check[1] = true;
		for(int i = 2; i <= 300000; i++) {
			for(int j = i * 2; j <= 300000; j += i) {
				check[j] = true;
			}
		}

		while(true) {
			int cnt = 0;
			int n = Integer.parseInt(br.readLine());
			
			if(n == 0)
				break;
			
			for(int i = n+1; i <= 2*n; i++) {
				if(check[i] == false) {
					cnt++;
				}
			}
			
			System.out.println(cnt);
		}
	}
}
