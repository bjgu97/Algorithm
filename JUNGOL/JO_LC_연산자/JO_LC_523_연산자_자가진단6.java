package JO_LC_연산자;

import java.util.Scanner;

public class JO_LC_523_연산자_자가진단6 {

	public static void main(String[] args) {
//		두 개의 정수를 입력받아서 다음과 같이 4가지 관계연산자의 결과를 출력하시오.
//
//		이때 입력받은 두 정수를 이용하여 출력하시오.
//
//		 (JAVA는 1이면 true, 0이면 false를 출력한다.)

		// 두 개의 정수 입력받는다
		Scanner scan = new Scanner(System.in);
		
		int a = scan.nextInt();
		int b = scan.nextInt();
		
		System.out.printf("%d > %d --- %s\n", a, b, a>b);
		System.out.printf("%d < %d --- %s\n", a, b, a<b);
		System.out.printf("%d >= %d --- %s\n", a, b, a>=b);
		System.out.printf("%d <= %d --- %s", a, b, a<=b);
	}

}
