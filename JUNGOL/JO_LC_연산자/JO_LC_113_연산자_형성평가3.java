package JO_LC_연산자;

import java.util.Scanner;

public class JO_LC_113_연산자_형성평가3 {

	public static void main(String[] args) {
		/*
		 * 직사각형의 가로와 세로의 길이를 정수형 값으로 입력받은 후 가로의 길이는 5 증가시키고 세로의 길이는 2배하여 저장한 후 가로의 길이 세로의 길이 넓이를 차례로 출력하는 프로그램을 작성하시오.
		 */

		Scanner scan = new Scanner(System.in);
		
		int width = scan.nextInt();
		int height = scan.nextInt();
		
		width += 5;
		height *= 2;
		
		System.out.printf("width = %d\n", width);
		System.out.printf("length = %d\n", height);
		System.out.printf("area = %d", width * height);
	}

}
