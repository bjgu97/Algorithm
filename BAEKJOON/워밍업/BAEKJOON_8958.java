package 워밍업;

import java.util.Scanner;

public class BAEKJOON_8958 {
	public static void main(String[] args) {
	    
		Scanner scan = new Scanner(System.in);
		int T = scan.nextInt();
	
		String[] oxStr = new String[T];
		
		for(int i = 0; i < T; i++) {
			oxStr[i] = scan.next();
		}
		
		for(int j = 0; j < oxStr.length; j++) { //5
			int score = 0;
			int sum = 0;
			for(int k = 0; k < oxStr[j].length(); k++) {
				char idx = oxStr[j].charAt(k);
				if(idx == 'O') {
					score++;
					sum += score;
				}
				else if(idx == 'X') {
					score = 0;
				}
			}
			System.out.println(sum);

		}
		}
}
