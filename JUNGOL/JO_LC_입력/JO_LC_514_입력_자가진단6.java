package JO_LC_입력;

import java.util.Scanner;

public class JO_LC_514_입력_자가진단6 {

	public static void main(String[] args) {
//		키를 입력받아 출력하는 프로그램을 작성하라.
//		(입력할때 "height = " 문장을 먼저 출력하고 키를 입력 받아야 합니다.)
//		height = 170
//		Your height is 170cm.
		
		System.out.printf("height = ");
		Scanner scan = new Scanner(System.in);
		int height = scan.nextInt();
		System.out.printf("Your height is %dcm.", height);
	}

}
