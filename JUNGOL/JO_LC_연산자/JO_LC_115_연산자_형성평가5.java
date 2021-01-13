package JO_LC_연산자;

import java.util.Scanner;

public class JO_LC_115_연산자_형성평가5 {

	public static void main(String[] args) {
		/*
		 * 민수와 기영이의 키와 몸무게를 입력받아 민수가 키도 크고 몸무게도 크면 1 그렇지 않으면 0을 출력하는 프로그램을 작성하시오.
		 * (JAVA는 1 이면 true, 0 이면 false를 출력한다.)
		 */

		Scanner scan = new Scanner(System.in);
		int height1 = scan.nextInt();
		int weight1 = scan.nextInt();
		
		int heigh2 = scan.nextInt();
		int weight2 = scan.nextInt();
		
		System.out.println((height1 > heigh2) && (weight1 > weight2));
	}

}
