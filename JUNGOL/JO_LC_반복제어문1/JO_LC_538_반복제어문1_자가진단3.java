/*
 * 한 개의 정수를 입력받아 양수(positive integer)인지 음수(negative number)인지 출력하는 작업을 반복하다가 0이 입력되면 종료하는 프로그램을 작성하시오.
 */
package JO_LC_반복제어문1;

import java.util.Scanner;

public class JO_LC_538_반복제어문1_자가진단3 {

	public static void main(String[] args) {
		// 값 입력받기
		Scanner scan = new Scanner(System.in);
		int num = 1;
		
		do {
			System.out.print("number? ");
			num = scan.nextInt();
			if(num > 0)
				System.out.println("positive integer");
			else if(num < 0)
				System.out.println("negative number");
		}while (num != 0); // num에 0이 입력되면 종료 

	}

}
