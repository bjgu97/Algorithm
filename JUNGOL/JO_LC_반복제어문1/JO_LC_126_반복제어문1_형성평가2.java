/*
 * 0 이상의 정수들이 공백으로 구분되어 반복적으로 주어진다.
 * 0이 입력되면 반복문을 멈추고 그 전까지 입력받은 수들에 대하여
 * 홀수의 개수와 짝수의 개수를 출력하는 프로그램을 작성하시오.
 */
package JO_LC_반복제어문1;

import java.util.Scanner;

public class JO_LC_126_반복제어문1_형성평가2 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int num = 0;
		int even = 0;
		int odd = 0;
		
		do{
			// 정수 주어진다
			num = scan.nextInt();
		
			//홀수의 개수와 짝수의 개수
			if(num %2 == 0)
				even ++;
			else if(num % 2 != 0)
				odd++;
			
		} while(num != 0); //0 입력되면 반복문 멈추기
	
		System.out.printf("odd : %d\n", odd);
		System.out.printf("even : %d", even-1); // 0%2도 0이니까 0 하나 빼주기
	}

}
