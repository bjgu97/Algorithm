/*
 * 100 이하의 양의 정수만 입력된다.
 * while 문을 이용하여 1부터 입력받은 정수까지의 합을 구하여 출력하는 프로그램을 작성하시오.
 */
package JO_LC_반복제어문1;

import java.util.Scanner;

public class JO_LC_537_반복제어문1_자가진단2 {

	public static void main(String[] args) {
		// 정수 입력받기
		Scanner scan = new Scanner(System.in);
		int num = scan.nextInt();
		
		int sum  = 0; //합 0으로 초기화
		
		//while문
		while(num != 0) { //num의 값이 0이 될 때까지 sum에 더해준다. 
			sum += num; 
			num --;        // ex) 10 + 9 + ... + 1 
		}
		
		//출력
		System.out.println(sum); 
	}

}
