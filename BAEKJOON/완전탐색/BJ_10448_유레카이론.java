package 완전탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ_10448_유레카이론 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int TC = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for(int tc = 0; tc < TC; tc++) {
			int K = Integer.parseInt(br.readLine());
			boolean check = false;
			
			for(int i = 1; i < 50; i++) {
				for(int j = 1; j < 50; j++) {
					for(int k =1; k < 50; k++) {
						if(func(i) + func(j) + func(k) == K) {
							check = true;	
						}
					}
				}
			}
			
			if(check)
				sb.append(1).append("\n");
			else
				sb.append(0).append("\n");
		}
		System.out.println(sb);
		

	}
	
	public static int func(int n) {
		return n * (n+1) / 2;
	}
}
