/*
 * 1부터 10까지의 합은 (1+10)*5와 같은 방법으로 구할 수 있습니다. 
 * 가우스의 덧셈이라는 방법을 이용하여 1부터 n까지의 정수 합을 구하는 프로그램을 작성하세요. 
 */

package Doit_01_기본알고리즘;

import java.util.Scanner;

public class Doit_01_Q8 {

	public static void main(String[] args) {
		
		// 정수 입력받기
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
			
		// 가우스의 덧셈 방법
		int nSum;

//		if(n%2 == 0) 
//			nSum = (1 + n) * (n/2);
//		else
//			nSum = (1 + n) * (n/2) + ((n+1)/2);

		nSum = (1 + n) * (n / 2) + (n % 2 == 0 ? 0 : ((n+1)/2));
		
		// 출력
		System.out.println(nSum);
	}

}
