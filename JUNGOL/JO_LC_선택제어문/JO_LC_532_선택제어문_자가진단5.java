package JO_LC_선택제어문;

import java.util.Scanner;

public class JO_LC_532_선택제어문_자가진단5 {

	public static void main(String[] args) {
		/*
		 * 두 개의 실수를 입력받아 모두 4.0 이상이면 "A", 모두 3.0 이상이면 "B", 아니면 "C" 라고 출력하는 프로그램을 작성하시오.
		 */

		//두 개의 실수 입력받기
		Scanner scan = new Scanner(System.in);
		double num1 = scan.nextDouble();
		double num2 = scan.nextDouble();
		
		if(num1 >= 4.0 && num2 >= 4.0) {
			System.out.println("A");
		}
		else if(num1 >= 3.0 && num2 >= 3.0) {
			System.out.println("B");
		}
		else {
			System.out.println("C");
		}
	}

}
