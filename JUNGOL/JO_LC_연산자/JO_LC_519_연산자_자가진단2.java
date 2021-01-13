package JO_LC_연산자;

import java.util.Scanner;

public class JO_LC_519_연산자_자가진단2 {

	public static void main(String[] args) {
		// 정수 2개를 입력받아서 첫 번째 수에는 100을 증가시켜 저장하고 두 번째 수는 10으로 나눈 나머지를 저장한 후 두 수를 차례로 출력하는 프로그램을 작성하시오.

		Scanner scan = new Scanner(System.in);
		
		int a = scan.nextInt();
		int b = scan.nextInt();
		
		a = a + 100;
		b = b % 10;
		
		System.out.printf("%d %d", a, b);
	}

}
