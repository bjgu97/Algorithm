/*
 * 정수 a, b를 포함하여 그 사이의 모든 정수의 합을 구하여 반환하는 아래 메서드를 작성하세요.
 * static int sumof(int a, int b)
 */

package Doit_01;

import java.util.Scanner;

public class Doit_01_Q9 {
	static int sumof(int a, int b) {
		int sum = 0;
		if(a>b) {
			for(int i = b; i <= a; i++)
				sum += i;
		}
		else {
			for(int i = a; i <= b; i++) 
				sum += i;
		}
		return sum;
	}
	
	public static void main(String[] args) {
		
		//정수 입력받기
		Scanner scan = new Scanner(System.in);
		int a = scan.nextInt();
		int b = scan.nextInt();
		
		int abSum = sumof(a, b);
		
		//출력
		System.out.println(abSum);

	}

}
