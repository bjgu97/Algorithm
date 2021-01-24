/*
 * 키뿐만 아니라 사람 수도 난수로 생성하도록 실습2-5를 수정하여 프로그램을 작성하시오.
 */
package Doit_02_기본자료구조;

import java.util.Random;
import java.util.Scanner;

public class Doit_02_Q1 {
	
	static void maxOf(int[] a) {
		int max = a[0];
		
		for(int i = 1; i < a.length; i++) {
			if(a[i] > max)
				max = a[i];
		}
		
		System.out.printf("최댓갑은 %d 입니다.", max);
	}
	public static void main(String[] args) {
		Random rand = new Random();
		Scanner scan = new Scanner(System.in);
		
		System.out.println("키의 최댓값을 구합니다.");
		System.out.print("사람 수: ");
		
		int num = rand.nextInt(10);
		
		System.out.printf("%d\n", num);

		//길이가 num인 배열 생성
		int[] height = new int[num];
		
		System.out.println("키 값은 아래와 같습니다.");
		for(int i = 0; i < num; i++) {
			height[i] = 100 + rand.nextInt(90);
			System.out.println("height[" + i + "] = " + height[i]);
		} 
		
		//최댓값 출력
		maxOf(height);
		
	}

}
