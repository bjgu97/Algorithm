package JO_LC_선택제어문;

import java.util.Scanner;

public class JO_LC_121_선택제어문_형성평가2 {

	public static void main(String[] args) {
		/*
		 * 정수를 입력받아 0 이면 "zero" 양수이면 "plus" 음수이면 "minus" 라고 출력하는 프로그램을 작성하시오.
		 */
		
		//정수 입력받기
		Scanner scan = new Scanner(System.in);
		int num = scan.nextInt();
		
		//출력
		if(num == 0) {
			System.out.println("zero");
		}
		else if(num > 0) {
			System.out.println("plus");
		}
		else {
			System.out.println("minus");
		}
	}

}
