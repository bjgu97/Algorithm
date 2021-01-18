package JO_LC_입력;

import java.util.Scanner;

public class JO_LC_515_입력_자가진단7 {
	public static void main(String[] args) {
//		두 개의 정수를 입력 받아 곱과 몫을 출력하시오.
//
//		(먼저 입력 받는 수가 항상 크며 입력되는 두 정수는 1이상 500이하이다.)
	
		Scanner scan = new Scanner(System.in);
		
		int num1 = scan.nextInt();
		int num2 = scan.nextInt();
		
		System.out.printf("%d * %d = %d\n", num1, num2, num1 * num2);
		System.out.printf("%d / %d = %d", num1, num2, num1 / num2);
	}
}
