/*
 * 두 변수 a, b에 정수를 입력하고 b-a를 출력하는 프로그램을 작성하세요.
 * 단, 변수 b에 입력한 값이 a 이하면 변수 b의 값을 다시 입력하세요.
 */
package Doit_01_기본알고리즘;

import java.util.Scanner;

public class Doit_01_Q10 {

	public static void main(String[] args) {
		// 두 변수 a, b 입력받기
		Scanner scan = new Scanner(System.in);
		int a, b;
		
		//while문
		System.out.printf("a의 값 : ");
		a = scan.nextInt();
		
		do {
			System.out.printf("b의 값 : ");
			b = scan.nextInt();
			
			if(b <= a)
				System.out.println("a보다 큰 값을 입력하세요!");
			
		} while(b <= a); //원하는 조건의 반대 입력
		
		System.out.printf("b-a는 %d입니다.", b-a);
		
	}

}
