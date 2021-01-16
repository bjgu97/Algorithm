/*
 * Q4. 세 값의 대소 관계 13종류의 모든 조합에 대해 중앙값을 구하여 출력하느 프로그램을 작성하세요 .
 */
package Doit_01;

import java.util.Scanner;

public class Doit_01_Q4 {
	
	// Median 구하는 함수
	static int med(int a, int b, int c) {
		if(a > b) 
			if(b > c) 
				return b;
			else if(c > a) 
				return a;
			else
				return c;
		else if(a > c) 
			return a;
		else if(b > c) 
			return c;
		else
			return b;
	}
	
	public static void main(String[] args) {
		
		// 세 숫자 입력받기
		Scanner scan = new Scanner(System.in);
		int num1 = scan.nextInt();
		int num2 = scan.nextInt();
		int num3 = scan.nextInt();
		
		//결과 출력
		int numMed = med(num1, num2, num3);
		System.out.println(numMed);
	}

}
