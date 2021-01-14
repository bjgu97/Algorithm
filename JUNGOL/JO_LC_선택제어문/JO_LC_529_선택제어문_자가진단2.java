package JO_LC_선택제어문;

import java.util.Scanner;

public class JO_LC_529_선택제어문_자가진단2 {

	public static void main(String[] args) {
		/*
		 * “몸무게+100-키”를 비만수치 공식이라고 하자.
		 * 키와 몸무게를 자연수로 입력받아 첫 번째 줄에 비만수치를 출력하고, 비만수치가 0보다 크면 다음줄에 비만("Obesity")이라는 메시지를 출력하는 프로그램을 작성하시오. 
		 */

		//키와 몸무게 자연수로 입력받기
		Scanner scan = new Scanner(System.in);
		int height = scan.nextInt();
		int weight = scan.nextInt();
		
		//비만수치 출력
		int val = weight + 100 - height;
		System.out.println(val);
		
		//비만수치 0보다 크면 Obesity 출력
		if(val > 0) {
			System.out.println("Obesity");
		}
	}
}
