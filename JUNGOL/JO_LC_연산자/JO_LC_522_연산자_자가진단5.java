package JO_LC_연산자;

import java.util.Scanner;

public class JO_LC_522_연산자_자가진단5 {

	public static void main(String[] args) {
//		두 개의 정수를 입력받아서, 
//
//		첫 번째 줄에는 두 정수의 값이 같으면 1 아니면 0을 출력하고, 
//
//		두 번째 줄에는 같지 않으면 1 같으면 0을 출력하는 프로그램을 작성하시오.
//
//		 
//
//		(JAVA는 1이면 true, 0이면 false를 출력한다.)
		
		//두개 의 정수 입력받는다
		Scanner scan = new Scanner(System.in);
		int a = scan.nextInt();
		int b = scan.nextInt();
		
		System.out.println(a == b);
		System.out.println(a != b);

	}

}
