package JO_LC_선택제어문;

import java.util.Scanner;

public class JO_LC_632_선택제어문_자가진단9 {

	public static void main(String[] args) {
		/*
		 * 3개의 정수를 입력받아 조건연산자를 이용하여 입력받은 수들 중 최소값을 출력하는 프로그램을 작성하시오.
		 */

		//3개 정수 입력받기
		Scanner scan = new Scanner(System.in);
		int a = scan.nextInt();
		int b = scan.nextInt();
		int c = scan.nextInt();
		
		//최소값 출력
		if(a < b) {
			if(a < c) {
				System.out.println(a);
			}
			else {
				System.out.println(c);
			}
		}
		else if(b < a) {
			if(b < c) {
				System.out.println(b);
			}
			else {
				System.out.println(c);
			}
		}
	}

}
