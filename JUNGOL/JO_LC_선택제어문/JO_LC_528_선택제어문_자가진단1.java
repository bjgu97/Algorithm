package JO_LC_선택제어문;

import java.util.Scanner;

public class JO_LC_528_선택제어문_자가진단1 {
	public static void main(String[] args) {
	/*
	 * 정수를 입력받아 첫 줄에 입력 받은 숫자를 출력하고 둘째 줄에 음수이면 “minus” 라고 출력하는 프로그램을 작성하시오.
	 */
	
	// 정수 입력받기
	Scanner scan = new Scanner(System.in);
	int num = scan.nextInt();
	
	//입력받은 숫자 출력
	System.out.println(num);
	
	//음수이면 둘째 줄에 minus 출력
	if(num < 0) {
		System.out.println("minus");
	}
	}
}
