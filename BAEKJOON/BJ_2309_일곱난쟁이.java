

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BJ_2309_일곱난쟁이 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// 돌아온 일곱 난쟁이가 아홉명
		// 일곱 난쟁이 키 합이 100
		
		int[] arr = new int[9];
		for(int i = 0; i < 9; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		
		int sum = 0;
		for(int i =0; i < 9; i++) {
			sum += arr[i];
		}
		
		Arrays.sort(arr);
		int a = 0;
		int b = 0;
		for(int i = 0; i < 9; i++) {
			for(int j = i+1; j < 9; j++) {
				if(sum - arr[i] - arr[j] == 100) {
					a= i;
					b = j;
					break;
				}
			}
		}
		
		for(int i =0;i < 9; i++) {
			if(i == a || i == b)
				continue;
			System.out.println(arr[i]);
		}
	}
}
