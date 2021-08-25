

import java.util.Scanner;

public class BJ_2231_분해합 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		int N = sc.nextInt();
		boolean check = false;
		// n은 answ의 생성자. 
		for(int i = 0; i < 1000000; i++) {
			int answ = func(i);
			if(answ == N) {
				check = true;
				sb.append(i);
				break;
			}
		}
		
		if(check)
			System.out.println(sb);
		else
			System.out.println(0);
		
	}
	
	// 분해합 구하는 함수
	public static int func(int n) {
		int answer = n;
		while(n != 0) {
			answer += n % 10;
			n = n / 10;
		}
		return answer;
	}
}
