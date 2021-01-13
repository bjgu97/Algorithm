package JO_LC_연산자;

import java.util.Scanner;

public class JO_LC_112_연산자_형성평가2 {

	public static void main(String[] args) {
		/*
		 * 두 정수를 입력받아서 나눈 몫과 나머지를 다음과 같은 형식으로 출력하는 프로그램을 작성하시오.
		 */
		
		//정수 입력받기
		Scanner scan = new Scanner(System.in);
		
		int a = scan.nextInt();
		int b = scan.nextInt();
		
		System.out.printf("%d / %d = %d...%d", a, b, a/b, a%b);
	}

}
