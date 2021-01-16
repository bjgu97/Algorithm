/*
 * 삼각형의 밑변의 길이와 높이를 입력받아 넓이를 출력하고, "Continue? "에서 하나의 문자를 입력받아 그 문자가 'Y' 나 'y' 이면 작업을 반복하고 다른 문자이면 종료하는 프로그램을 작성하시오.
 * (넓이는 반올림하여 소수 첫째자리까지 출력한다.)​
 */
package JO_LC_반복제어문1;

import java.util.Scanner;

public class JO_LC_129_반복제어문1_형성평가5 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		while(true) {
			// 삼각형의 밑변의 길이와 높이 입력받아
			System.out.print("Base = ");
			int base = scan.nextInt();
			System.out.print("Height = ");
			int height = scan.nextInt();
			
			//넓이 출력
			double area = (double)(base * height) / 2;
			System.out.printf("Triangle width = %.1f\n", area);
			
			//Continue에서 문자 입력받아
			System.out.print("Continue? ");
			char answ = scan.next().charAt(0);
			
			// Y나 y면 작업 반복
			if(answ == 'Y') 
				continue;
			else if(answ == 'y')
				continue;
			//다른 문자면 종료
			else
				break;
		}

	}

}
