package JO_LC_입력;

import java.util.Scanner;

public class JO_LC_517_입력_자가진단9 {

	public static void main(String[] args) {
//		세 개의 실수를 입력 받아 반올림하여 소수 셋째 자리까지 출력하는 프로그램을 작성하시오.
		
		Scanner scan = new Scanner(System.in);
		
		double num1 = scan.nextDouble();
		double num2 = scan.nextDouble();
		double num3 = scan.nextDouble();
		
		System.out.printf("%.3f\n%.3f\n%.3f", num1, num2, num3);
	}

}
