/*
 * 배열 요소를 역순으로 정렬하는 과정을 하나하나 나타내는 프로그램을 작성하세요. 
 */
package Doit_02_기본자료구조;

import java.util.Random;
import java.util.Scanner;

public class Doit_02_Q2 {
	public static void reverse(int[] array) {
		for(int i = 0; i < array.length/2; i++) {
			System.out.printf("a[%d]과(와) a[%d]를 교환합니다.\n", i, array.length-i);
			int temp;
			temp = array[i];
			array[i] = array[array.length-1-i];
			array[array.length-i-1] = temp;
			for(int j = 0; j < array.length; j++)
				System.out.printf("%d ", array[j]);
			System.out.println();
		}
	}
	public static void main(String[] args) {
		// 배열 크기 지정 (사용자 지정)
		Scanner scan = new Scanner(System.in);
		int num = scan.nextInt();
		
		//지정한 크기의 배열 생성
		Random rand = new Random();
		int[] array = new int[num];
		for(int i = 0; i < num; i++)
			array[i] = rand.nextInt(100);
		
		//배열 출력해보기
		for(int i = 0; i < array.length; i++)
			System.out.printf("%d ", array[i]);
		//배열 역순으로 정렬
		System.out.println();
		reverse(array);
	}

}
