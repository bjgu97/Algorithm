package 워밍업;

import java.util.Scanner;

public class BAEKJOON_2675 {

	public static void main(String[] args) {
		// 테스트케이스 개수 입력
		Scanner scan = new Scanner(System.in);
		int num = scan.nextInt();
		int[] repeatNum = new int[num];
		String[] alpha = new String[num];
		
		for(int i = 0;i < num; i++) {
			repeatNum[i] = scan.nextInt(); //3 5
			alpha[i] = scan.next(); //ABC /HTP
		}
		
		int a = repeatNum[0];
		String b = alpha[0];
		
		//출력
		for(int i = 0; i < num; i++) { // i = 0, 1
			for(int j = 0; j < alpha[i].length(); j++) {
				for(int k = 0; k < repeatNum[i]; k++)
					System.out.print(alpha[i].charAt(j));
			}
			System.out.println();
		}
	
	}
}



