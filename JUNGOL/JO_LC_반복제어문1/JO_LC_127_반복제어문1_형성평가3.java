/*
 * 0 부터 100 까지의 점수를 계속 입력받다가 범위를 벗어나는 수가 입력되면 그 이전까지 입력된 자료의 합계와 평균을 출력하는 프로그램을 작성하시오.
 * (평균은 반올림하여 소수 첫째자리까지 출력한다.)
 */
package JO_LC_반복제어문1;

import java.util.Scanner;

public class JO_LC_127_반복제어문1_형성평가3 {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		
		int sum = 0;
		int avg = 0;
		int cnt = 0;
		
		while(true) {
			// 점수 계속 입력받기
			int num = scan.nextInt();
			
			// 범위 벗어나면 반복문 빠져나가기
			if(num  < 0 || num > 100)
				break;
			else {
				//점수 합계
				sum += num;
				cnt ++;
			}
			
		}
		
		System.out.printf("sum : %d\n", sum);
		System.out.printf("avg : %.1f", sum / (double)cnt);

	}

}
