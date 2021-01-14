package JO_LC_선택제어문;

import java.util.Scanner;

public class JO_LC_530_선택제어문_자가진단3 {

	public static void main(String[] args) {
		/*
		 * 나이를 입력받아 20살 이상이면 "adult"라고 출력하고 그렇지 않으면 몇 년후에 성인이 되는지를 "○ years later"라는 메시지를 출력하는 프로그램을 작성하시오.
		 */

		//나이 입력받기
		Scanner scan = new Scanner(System.in);
		int age = scan.nextInt();
		
		//출력
		if(age >= 20) {
			System.out.println("adult");
		}
		else if(age < 20) {
			System.out.printf("%d years later", 20-age);
		}
	}

}
