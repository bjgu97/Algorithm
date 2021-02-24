

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BAEKJOON_2839_설탕배달 {
public static void main(String[] args) throws NumberFormatException, IOException {
	// 설탕 N킬로그램 배달
	//봉지: 3킬로, 5킬로
	//최대한 적은 봉지
	//ex) 18 -> 5킬로 3개, 3킬로 1개
	// 봉지 몇개?
	
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	int N = Integer.parseInt(br.readLine());
	int y = -1;
	int x = 0;
	
	while(true) {
		if(N%5 == 0) {
			y = N / 5; // y는 5킬로 봉지 개수  
			System.out.println(x + y);
			break;
		}
		else {
			N = N - 3;
			x++; // x는 3킬로 봉지 개수 
		}
		
		if(N < 0) {
			System.out.println(-1);
			break;
		}
	}

	/*
	int change;
	int cnt = 0;
	
	while(true) { // N = 18
		change = N % 5; //3
		if(change == 0) {
			cnt += N/5;
			System.out.println(cnt);
			break; //
		}
		else {
			N-=3;
			cnt++; //
		}
		
		if(N < 0) {
			System.out.println(-1);
			break;
		}}
		
		*/
}
}
