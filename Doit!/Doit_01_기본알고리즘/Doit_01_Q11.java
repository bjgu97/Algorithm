/*
 * 양의 정수를 입력하고 자릿수를 출력하는 프로그램을 작성하세요.
 * 예를 들어 135을 입력하면 '그 수는 3자리입니다.'라고 출력하고, 1314를 출력하면 '그 수는 4자리입니다.'라고 출력하면 됩니다.
 */
package Doit_01;

import java.util.Scanner;

public class Doit_01_Q11 {

	public static void main(String[] args) {
		//양의 정수 입력받기
		Scanner scan = new Scanner(System.in);
		int num = scan.nextInt();
		int cnt = 1;
		
		for(int i = 1; ; i*=10) {
			if(num / i < 10) {  //i로 나눈 값이 10보다 작으면
				System.out.println(cnt); //cnt 값 출력
				break; //반복문 종료
			}
			else //10보다 크면
				cnt ++; //cnt 하나 증가, 그리고 i 다시 10배해서 반복문 다시 실행
		}
	}
}

