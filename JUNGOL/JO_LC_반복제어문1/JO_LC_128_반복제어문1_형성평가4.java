/*
 * 0 이 입력될 때까지 정수를 계속 입력받아 3의 배수와 5의 배수를 제외한 수들의 개수를 출력하는 프로그램을 작성하시오.
 */
package JO_LC_반복제어문1;

import java.util.Scanner;

public class JO_LC_128_반복제어문1_형성평가4 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int num = 0;
		int cnt = 0;
		
		do {
			// 0이 될 때까지 계속 입력받기	
			num = scan.nextInt();
			
			//3의 배수와 5의 배수 제외한 수들의 개수
			if(num % 3 != 0) {
				if(num % 5 != 0) 
					cnt ++; //3의 배수, 5이 배수가 아니면 cnt 증가
			}
			
		}while(num != 0); //0이 아닌 동안 do문 반복
		
		//출력
		System.out.println(cnt);
	}

}
