/*
 * 배열 b의 모든 요소를 배열 a에 복사하는 메서드 copy 작성
 */
package Doit_02_기본자료구조;

import java.util.Random;

public class Doit_02_Q4 {
	static void copy(int[] a, int[] b) {
		for(int i = 0; i < b.length; i++) {
			a[i] = b[i];
			System.out.printf("%d ", a[i]);
		}
	}
	public static void main(String[] args) {
		//배열 b 생성
		int b_size = 5;
		int[] b = new int[b_size];
		Random rand = new Random();
		for(int i = 0; i < b_size; i++) {
			b[i] = rand.nextInt(100);
			System.out.printf("%d ", b[i]);
		}
		
		System.out.println();
		//배열 a 선언
		int[] a = new int[b_size];
		
		//copy 메소드 호출
		copy(a, b);
	}
}
