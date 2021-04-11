package 실버;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;


public class BJ_6603_로또 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while(true) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int totalNum = Integer.parseInt(st.nextToken());
			if(totalNum == 0) // while문 종료 조건
				break;
			
			int[] totalNumArr = new int[totalNum];
			int[] lottoNumbers = new int[6];
			for(int n = 0; n < totalNum; n++) {
				totalNumArr[n] = Integer.parseInt(st.nextToken());
				
			}
			comb(0, 0, totalNumArr, lottoNumbers);
			System.out.println();
//			System.out.println(Arrays.toString(totalNumArr));
		}
	}
	
	static void comb(int cnt, int start, int[] arr, int[] numbers) {
		if(cnt == 6) {
//			System.out.println(Arrays.toString(numbers));
			for(int num = 0; num < numbers.length; num++) {
				System.out.print(numbers[num] + " ");
			}
			System.out.println();
			return;
		}
		
		for(int i= start; i < arr.length; i++) {
			numbers[cnt] = arr[i];
			comb(cnt+1, i+1, arr, numbers);
		}
		
	}
}
