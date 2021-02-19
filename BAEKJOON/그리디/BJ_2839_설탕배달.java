package 그리디;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ_2839_설탕배달 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		int left;
		int answ = 0;
		
		while(N > 0) { // 몇번 반복될지 모르니까 while. 			
			if(N%5 == 0) { // 처음엔 5로 나눠보기. 
				answ += N/5;
				break;
			}
			
			N -= 3;
			answ++;
		}
		
		if(N < 0)
			System.out.println(-1);
		else
			System.out.println(answ);
	}
}
