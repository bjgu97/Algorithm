/*
 * 정수를 입력받아서 3의 배수가 아닌 경우에는 아무 작업도 하지 않고 
 * 3의 배수인 경우에는 3으로 나눈몫을 출력하는 작업을 반복하다가
 * -1이 입력되면 종료하는 프로그램을 작성하시오.
 */
package JO_LC_반복제어문1;

import java.util.Scanner;

public class JO_LC_540_반복제어문1_자가진단5 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int num = 0;
		
		do {
			// 정수 입력받기
			num = scan.nextInt(); 
			//3의 배수가 아니면 반복
			if(num % 3 != 0)
				continue;
			//3의 배수면 몫 출력
			else if(num % 3 == 0)
				System.out.println(num/3);
		} while(num != -1); // do문 반복하길 윈하는 조건(빠져나가기 위한 조건의 반대)

	}

}
