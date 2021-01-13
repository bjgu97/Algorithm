package JO_LC_연산자;

import java.util.Scanner;

public class JO_LC_525_연산자_자가진단8 {

	public static void main(String[] args) {
		/*
		 3개의 정수를 입력 받아 첫 번째 수가 가장 크면 1 아니면 0을 출력하고 세 개의 수가 모두 같으면 1 아니면 0을 출력하는 프로그램을 작성하시오.

(JAVA는 1이면 true, 0이면 false를 출력한다.)
		 */
		
		Scanner scan = new Scanner(System.in);
		int a = scan.nextInt();
		int b = scan.nextInt();
		int c = scan.nextInt();
		
		boolean d = (a > b) && (a > c);
		boolean e = (a == b) && (b == c);
		
		System.out.printf("%s %s", d, e);
	}

}
