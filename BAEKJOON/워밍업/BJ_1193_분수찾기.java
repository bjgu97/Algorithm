package 워밍업;

import java.util.Scanner;

public class BJ_1193_분수찾기 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		
		int X = scan.nextInt();
		
		int sum = 0;
		int ii = 0;
		int jj = 0;
		int cnt= 0;
		outer:for(int i = 1; i <= X; i++) {
			for(int j = 1; j <= i; j++) {
				cnt++;
				System.out.println("i: " + i + ", j: " + j);
				sum += j;
				System.out.println(sum);
				if(cnt == X) {
					ii = i;
					jj = j;
					break outer;
				}
			}
		}
		
		if(ii%2 == 0)
			sb.append(jj).append("/").append(ii+1-jj);
		else
			sb.append(ii+1-jj).append("/").append(jj);
		System.out.println(sb);
	}

}
