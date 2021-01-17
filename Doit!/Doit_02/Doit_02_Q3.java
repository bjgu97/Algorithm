/*
 * 배열 a의 모든 요소의 합계를 구하여 반환하는 메서드를 작성하세요. 
 */
package Doit_02;

import java.util.Random;
import java.util.Scanner;

public class Doit_02_Q3 {
	// 배열의 모든 요소의 합계 구하는 메서드 
	static int sumOf(int[] a) {
		int sum = 0;
		for(int i = 0; i < a.length; i++) {
			sum += a[i];
		}
		
		return sum;
	}
	public static void main(String[] args) {
		// 랜덤 크기의 배열 생성
		Random rand = new Random();
		
		int size = 5 + rand.nextInt(5);
		System.out.printf("array size : %d\n", size);
		int[] array = new int[size];
		
		for(int i = 0; i < size; i++)  {
			array[i] =  rand.nextInt(100);
			System.out.printf("%d ", array[i]);
		}
		System.out.println();
		int arraySum = sumOf(array);
		System.out.println(arraySum);
	}

}
