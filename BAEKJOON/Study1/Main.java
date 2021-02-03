package Study1;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int N = scan.nextInt();
		
		// N 배열: 숫자 배열
		int[] NArr = new int[N];
		
		for(int i = 0; i < N; i++) {
			NArr[i] = scan.nextInt();
		}
		
		//M 배열: 찾고자하는 숫자
		int M = scan.nextInt();
		int[] MArr = new int[M];
		
		for(int i = 0; i < M; i++) {
			MArr[i] = scan.nextInt();
		}

		//탐색
		boolean flag = false;
		
		for(int i = 0; i < M; i++) {
			flag = false;
			for(int j = 0; j < N; j++) {
				if(NArr[j] == MArr[i]) {
					flag = true;
				}
			}
			if(flag)
				System.out.println("1");
			else
				System.out.println("0");
		}

		}
	}

