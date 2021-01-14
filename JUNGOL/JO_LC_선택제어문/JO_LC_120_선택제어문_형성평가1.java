package JO_LC_선택제어문;

import java.util.Scanner;

public class JO_LC_120_선택제어문_형성평가1 {
	public static void main(String[] args) {
		/*
		 * 두 개의 정수를 입력받아 큰 수에서 작은 수를 뺀 차를 출력하는 프로그램을 작성하시오.
		 */
		
		// 두 개의 정수 입력받기
		Scanner scan = new Scanner(System.in);
		int a = scan.nextInt();
		int b = scan.nextInt();
		
		//출력
		if(a > b) {
			System.out.println(a-b);
		}
		else {
			System.out.println(b-a);
		}
	}
}
