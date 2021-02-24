/*
 * 입력은 여러 개의 테스트 케이스로 이루어져 있다.
 * 각 테스트 케이스는 한 줄로 이루어져 있으며, 각 줄에 A와 B가 주어진다. (0 < A, B < 10)
 */


import java.util.Scanner;

public class BAEKJOON_10951 {


	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
//		int a = scan.nextInt();
//		int b = scan.nextInt();
	
		while(scan.hasNextInt()) {
			int a = scan.nextInt();
			int b = scan.nextInt();

			System.out.println(a + b);
		
		}
		
		
	}
}
