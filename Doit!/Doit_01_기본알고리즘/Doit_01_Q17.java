/*
 * 아래를 향한 n단의 숫자 피라미드를 출력하는 메서드를 작성하세요. 
 *               1
 *              222
 *             33333
 *            4444444
 */
package Doit_01;

public class Doit_01_Q17 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		for(int i = 1; i < 5; i++) {           // 1 2 3 4
			for(int j = 1; j <= 4 - i; j++) {   // 3 2 1 0
				System.out.print(" ");
			}
			for(int j = 1; j <= 2*i-1; j++) {   // 1 3 5 7
				System.out.print(i);
			}
			System.out.println();
		}
	}

}
