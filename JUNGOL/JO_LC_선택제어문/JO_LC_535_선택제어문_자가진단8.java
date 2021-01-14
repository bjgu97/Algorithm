package JO_LC_선택제어문;

import java.util.Scanner;

public class JO_LC_535_선택제어문_자가진단8 {

	public static void main(String[] args) {
		/*
		    4.5 이하의 평점을 입력받아 그 값에 따라 다음과 같이 출력하는 프로그램을 작성하시오.
			(C, C++, Java는 switch ~ case문 사용)
			단 입력는 0이상 4.5 이하이다.
			4.0 이상 : "scholarship"
			3.0 이상 : "next semester"
			2.0 이상 : "seasonal semester"
			2.0 미만 : "retake"​
		 */

		//평점 입력받기
		Scanner scan = new Scanner(System.in);
		double level = scan.nextDouble();
		
		//출력
		switch((int)level) {
		case 4: 
			System.out.println("scholarship");
			break;
		case 3:
			System.out.println("next semester");
			break;
		case 2:
			System.out.println("seasonal semester");
			break;
		default:
			System.out.println("retake");
		}
	}

}
