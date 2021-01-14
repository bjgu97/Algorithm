package JO_LC_선택제어문;

import java.util.Scanner;

public class JO_LC_123_선택제어문_형성평가4 {

	public static void main(String[] args) {
		/*
		 * 1번은 개, 2번은 고양이, 3번은 병아리로 정하고 번호를 입력하면 번호에 해당하는 동물을 영어로 출력하는 프로그램을 작성하시오.
			해당 번호가 없으면 "I don't know."라고 출력한다.
			개-dog
			고양이-cat
			병아리-chick​ 
		 */

		//번호 입력받기
		Scanner scan = new Scanner(System.in);
		System.out.print("Number? ");
		int num = scan.nextInt();
		
		//출력
		switch(num) {
		case 1:
			System.out.println("dog");
			break;
		case 2:
			System.out.println("cat");
			break;
		case 3:
			System.out.println("chick");
			break;
		default:
			System.out.println("I don't know.");
		}
	}

}
