package JO_LC_선택제어문;

import java.util.Scanner;

public class JO_LC_122_선택제어문_형성평가3 {

	public static void main(String[] args) {
		/*
		 * 년도를 입력받아 윤년(leap year)인지 평년(common year)인지 판단하는 프로그램을 작성하시오.
		 */

		//년도 입력받기
		Scanner scan = new Scanner(System.in);
		int year = scan.nextInt();
		
		//출력
		if(year%400 == 0 || year % 4 == 0 && year%100 != 0) {
			System.out.println("leap year");
		}
		else {
			System.out.println("common year");
		}
	}

}
