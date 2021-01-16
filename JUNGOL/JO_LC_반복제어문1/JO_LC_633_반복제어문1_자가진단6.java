/*
 * 아래와 같이 나라 이름을 출력하고 숫자를 입력받아 해당하는 나라의 수도를 출력하는 작업을 반복하다가 해당하는 번호 이외의 숫자가 입력되면 "none"라고 출력한 후 종료하는 프로그램을 작성하시오.
 * 각 나라의 수도 : 
 * 대한민국 = 서울(Seoul)
 * 미국 = 워싱턴(Washington)
 * 일본 = 동경(Tokyo)
 * 중국 = 북경(Beijing)
 */
package JO_LC_반복제어문1;

import java.util.Scanner;

public class JO_LC_633_반복제어문1_자가진단6 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int num;
		
		while(true) {
			// 나라 이름 출력
			System.out.println("1. Korea");
			System.out.println("2. USA");
			System.out.println("3. Japan");
			System.out.println("4. China");
			System.out.print("number? ");
			
			//번호 입력받기
			num = scan.nextInt();
			
			//경우에 따라 출력
			if(num == 1)
				System.out.println("\nSeoul\n");
			else if(num == 2)
				System.out.println("\nWashington\n");
			else if(num == 3)
				System.out.println("\nTokyo\n");
			else if(num == 4)
				System.out.println("\nBeijing\n");
			else { 
				System.out.println("\nnone\n");
				break; //1, 2, 3, 4 이외의 숫자 입력하면 반복문 빠져나가기
			} 
		}
	}

}
