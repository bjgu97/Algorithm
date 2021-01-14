package JO_LC_선택제어문;

import java.util.Scanner;

public class JO_LC_124_선택제어문_형성평가5 {

	public static void main(String[] args) {
		/*
		 * 1~12사이의 정수를 입력받아 평년의 경우 입력받은 월을 입력받아 평년의 경우 해당 월의 날수를 출력하는 프로그램을 작성하시오.
		 */

		//정수 입력
		Scanner scan = new Scanner(System.in);
		int num = scan.nextInt();
		
		switch(num) {
		case 2:
			System.out.println("28");
			break;
		case 4:
		case 6:
		case 9:
		case 11:
			System.out.println("30");
			break;
		default:
			System.out.println("31");
		}
	}

}
