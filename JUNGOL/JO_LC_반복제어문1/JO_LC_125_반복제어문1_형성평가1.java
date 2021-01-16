/*
 * 정수를 입력받아 1부터 입력받은 정수까지를 차례대로 출력하는 프로그램을 작성하시오.
 */
package JO_LC_반복제어문1;

import java.util.Scanner;

public class JO_LC_125_반복제어문1_형성평가1 {

	public static void main(String[] args) {
		// 정수 입력받기
		Scanner scan = new Scanner(System.in);
		int num = scan.nextInt();
		//출력
		for(int i = 0; i <num; i++)
			System.out.printf("%d ", i+1);
	}

}
