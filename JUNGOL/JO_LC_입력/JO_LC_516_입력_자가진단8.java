package start_1.JO_LC_입력;

import java.util.Scanner;

public class JO_LC_516_입력_자가진단8 {
	public static void main(String[] args) {
//		실수 2개와 한 개의 문자를 입력 받아 출력하되 실수는 반올림하여 소수 둘째자리까지 출력하는 프로그램을작성하시오.
//		(C, C++, Java 의 경우 실수는 "double"로 선언하세요.)
		Scanner scan = new Scanner(System.in);
		
		double num1 = scan.nextDouble();
		double num2 = scan.nextDouble();
		char char1 = scan.next().charAt(0);
		
		System.out.printf("%.2f\n", num1);
		System.out.printf("%.2f\n", num2);
		System.out.printf("%c", char1);
		
		
		
	}
}
