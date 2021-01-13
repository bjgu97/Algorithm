package JO_LC_연산자;

import java.util.Scanner;

public class JO_LC_111_연산자_형성평가1 {
	public static void main(String[] args) {
		
		/*
		 국어 영어 수학 컴퓨터 과목의 점수를 정수로 입력받아서 총점과 평균을 구하는 프로그램을 작성하시오. (단 평균의 소수점 이하는 버림 한다.)
		 */
		
		//점수 입력받는다
		Scanner scan = new Scanner(System.in);
		int kor = scan.nextInt();
		int eng = scan.nextInt();
		int mat = scan.nextInt();
		int com = scan.nextInt();
		
		int sum = kor + eng + mat + com;
		int avg = (int)(sum / 4);
		
		System.out.printf("sum %d\n", sum);
		System.out.printf("avg %d", avg);
	}
}
