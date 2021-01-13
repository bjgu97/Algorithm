package JO_LC_연산자;

import java.util.Scanner;

public class JO_LC_521_연산자_자가진단4 {

	public static void main(String[] args) {
		// 두 개의 정수를 입력받아서  첫 번째수는 후치 증가 연산자를 사용하고 두 번째 수는 전치 감소 연산자를 사용하여 두 수의 곱을 구한 후 각각의 값을 출력하는 프로그램을 작성하시오.

		// 두 개의 정수 입력받기
		Scanner scan = new Scanner(System.in);
		int a = scan.nextInt();
		int b = scan.nextInt();
		

		//두 수의 곱
		int ab = a++ * --b;
		
		System.out.printf("%d %d %d", a, b, ab);

}
}
