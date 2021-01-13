package JO_LC_연산자;

import java.util.Scanner;

public class JO_LC_520_연산자_자가진단3 {

	public static void main(String[] args) {
		// 한 개의 정수를 입력 받아서 후치증가 연산자를 사용하여 출력한 후 전치 증가 연산자를 사용하여 출력하는프로그램을 작성하시오.

		//정수 입력받기
		Scanner scan = new Scanner(System.in);
		int a = scan.nextInt();
		
		//후치증가 연산자
		System.out.println(a++);
		
		//전치증가 연산자
		System.out.println(++a);
	}

}
