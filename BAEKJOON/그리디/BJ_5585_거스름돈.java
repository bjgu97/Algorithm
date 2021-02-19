package 그리디;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ_5585_거스름돈 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		int change = 1000 - N;
		int cnt = 0;
		while(change > 0) {
			if(change / 500 > 0) {
				cnt += (change / 500);
				change = change - 500 * (change / 500);
			}
			else if(change / 100 > 0) {
				cnt += (change / 100);
				change = change - 100 * (change / 100);
			}
			else if(change / 50 > 0) {
				cnt += (change / 50);
				change = change - 50 * (change / 50);
			}
			else if(change / 10 > 0) {
				cnt += (change / 10);
				change = change - 10 * (change / 10);
			}
			else if(change / 5 > 0) {
				cnt += (change / 5);
				change = change - 5 * (change / 5);
			}
			else if(change / 1 > 0) {
				cnt += (change / 1);
				change = change - 1 * (change / 1);
			}
			
		}
		
		System.out.println(cnt);
	}

}
