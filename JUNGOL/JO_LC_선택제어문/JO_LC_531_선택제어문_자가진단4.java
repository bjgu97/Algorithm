package JO_LC_선택제어문;

import java.util.Scanner;

public class JO_LC_531_선택제어문_자가진단4 {

	public static void main(String[] args) {
		/*
		    복싱체급은 몸무게가 
			50.80kg 이하를 Flyweight, 
			61.23kg 이하를 Lightweight, 
			72.57kg 이하를 Middleweight, 
			88.45kg 이하를 Cruiserweight, 
			88.45kg 초과를 Heavyweight
			라고 하자.

 			몸무게를 입력받아 체급을 출력하는 프로그램을 작성하시오.
		 */

		//몸무게 입력받기
		Scanner scan = new Scanner(System.in);
		double weight = scan.nextDouble();
		
		//제어문
		if(weight <= 50.80) {
			System.out.println("Flyweight");
		}
		else if(weight <= 61.23) {
			System.out.println("Lightweight");
		}
		else if(weight <= 72.57) {
			System.out.println("Middleweight");
		}
		else if(weight < 88.45) {
			System.out.println("Cruiserweight");
		}
		else {
			System.out.println("Heavyweight");
		}
		
	}

}
