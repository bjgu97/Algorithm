

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BJ_2577_숫자의개수 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int A = Integer.parseInt(br.readLine());
		int B = Integer.parseInt(br.readLine());
		int C = Integer.parseInt(br.readLine());
		
		long num = A * B * C;
		
		
		String numString = Long.toString(num);
		
		int[] arr = new int[10];
		for(int i = 0; i < numString.length(); i++) {
			arr[numString.charAt(i) - '0']++;
		}
		
		for(int i : arr)
			System.out.println(i);
		
	}
}
