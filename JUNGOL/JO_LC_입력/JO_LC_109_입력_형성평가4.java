package start_1.JO_LC_입력;

import java.util.Scanner;

public class JO_LC_109_입력_형성평가4 {

	public static void main(String[] args) {
//		세 개의 정수를 입력받아 합과 평균을 출력하는 프로그램을 작성하시오.(단 평균은 소수 이하를 버림하여 정수 부분만 출력한다.)

		Scanner scan = new Scanner(System.in);
		
		int a = scan.nextInt();
		int b = scan.nextInt();
		int c = scan.nextInt();
		
		System.out.printf("sum = %d\n", a + b + c);
		System.out.printf("avg = %d", (int)((a + b + c)/3));
	}

}
