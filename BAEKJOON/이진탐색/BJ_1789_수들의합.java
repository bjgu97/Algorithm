package 이진탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ_1789_수들의합 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		long S = Long.parseLong(br.readLine());
		
		// 서로 다른 N개 자연수의 합 = S
		// N의 최댓값?
		
		// 1 -> 200
		// 2 -> 1 199
		// 3 -> 1 2 197
		// 4 -> 1 2 3 194
		// 5 -> 1 2 3 4 190
		long down = 0L;
		long top = S;
		long sum = 0L;
		while(true) {
			down = down + 1;
			sum += down;
			top = top-down;
			if(top <= down)
				break;
//			System.out.println("down: " + down);
//			System.out.println("sum: " + sum);
//			System.out.println("top: " + top);
//			System.out.println();
		}
		System.out.println(down);
	}
}
