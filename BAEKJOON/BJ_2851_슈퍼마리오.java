

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ_2851_슈퍼마리오 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[] arr = new int[10];
		for(int i = 0; i < 10; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		int sum = 0;
		int a = 0;
		for(int i = 0; i < 10; i++) {
			sum += arr[i]; // 계속 더해 나가다가
			if(sum > 100) { // 100 넘으면 그 때의 i 값 기억.
				a = i;
				break;
			}
		}
		// 100 넘어갔을 때의 합과 100 넘어가지 않았을때의 합 비교
		int sum2 = 0;
		for(int i = 0; i < a; i++) { // a 직전까지의 합
			sum2 += arr[i];
		}
		
		System.out.println(Math.abs(100 - sum) > Math.abs(100 - sum2) ? sum2:sum);
		
	}
}
