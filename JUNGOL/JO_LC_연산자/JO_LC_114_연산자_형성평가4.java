package JO_LC_연산자;

import java.util.Scanner;

public class JO_LC_114_연산자_형성평가4 {

	public static void main(String[] args) {
		/*
		 * 두 정수를 입력받아 첫 번째 수는 전치증가연산자를 사용하고 두 번째 수는 후치감소연산자를 사용하여 출력하고 바뀐 값을 다시 출력하는 프로그램을 작성하시오.
		 */

		Scanner scan = new Scanner(System.in);
		int a = scan.nextInt();
		int b = scan.nextInt();
		
		System.out.printf("%d %d\n", ++a, b--);
		System.out.printf("%d %d", a, b);
	}

}
