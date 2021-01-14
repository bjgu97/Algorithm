package JO_LC_선택제어문;

import java.util.Scanner;

public class JO_LC_534_선택제어문_자가진단7 {

	public static void main(String[] args) {
		/*
		    영문 대문자를 입력받아 
			'A'이면 “Excellent”, 
			'B'이면 “Good”, 
			'C'이면 “Usually”, 
			'D'이면 “Effort”, 
			'F'이면 “Failure”, 
			그 외 문자이면 “error” 라고 출력하는 프로그램을 작성하시오.
		 */

		//영문 대문자 입력받기
		Scanner scan = new Scanner(System.in);
		char alpha = scan.next().charAt(0);
		
		//출력
		if(alpha == 'A') {
			System.out.println("Excellent");
		}
		else if(alpha == 'B') {
			System.out.println("Good");
		}
		else if(alpha == 'C') {
			System.out.println("Usually");
		}
		else if(alpha == 'D') {
			System.out.println("Effort");
		}
		else if(alpha == 'F') {
			System.out.println("Failure");
		}
		else {
			System.out.println("error");
		}
	}

}
