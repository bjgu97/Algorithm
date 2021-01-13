package JO_LC_연산자;

import java.util.Scanner;

public class JO_LC_518_연산자_자가진단1 {

	public static void main(String[] args) {
//		세 개의 정수를 입력 받아서 합계와 평균을 출력하시오. (단 평균은 소수 이하를 버리고 정수부분만 출력한다.)

		Scanner scan = new Scanner(System.in);
		int a = scan.nextInt();
		int b = scan.nextInt();
		int c = scan.nextInt();
		
		System.out.printf("sum : %d\n", a + b + c);
		System.out.printf("avg : %d", (int)((a + b + c)/3));
	}

}
