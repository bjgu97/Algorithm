/*
 * 정수를 계속 입력받다가 100 이상의 수가 입력이 되면 마지막 입력된 수를 포함하여 합계와 평균을 출력하는 프로그램을 작성하시오.
 * (평균은 반올림하여 소수 첫째자리까지 출력한다.)
 */
package JO_LC_반복제어문1;

import java.util.Scanner;

public class JO_LC_539_반복제어문1_자가진단4 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int sum = 0;
		double avg = 0;
		int cnt = 0;
		
		while(true) {
			int num = scan.nextInt();
			
			sum += num;
			cnt ++;
			if(num >= 100) {
				avg = sum / (double)cnt; //avg가 double이 되기 위해서는 cnt 형변환 필요!!
				System.out.println(sum);
				System.out.printf("%.1f", avg);
				break;
			}
		}
		
		
		

	}

}
