
package Study_day01;

import java.util.Scanner;

public class BAEKJOON_1978_소수찾기 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int cnt = 0;
		int N = scan.nextInt();
		boolean var;
		
		for(int i = 0; i < N; i++) {
			var = true;

			int num = scan.nextInt();
			
			//1이면 소수 아님!
			if(num == 1) {
				var = false;
			}
			
			//2 이외 다른 숫자들이면
			for(int k = 2; k < num; k++) {
				if(num % k == 0) {
					var = false; // 소수가 아니다!
					break;
				}
			}
			if(var == true)
				cnt++;
		}
		System.out.println(cnt);

	}

}
