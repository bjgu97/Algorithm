package 브론즈;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BJ_10808_알파벳개수 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		char[] sArr = s.toCharArray();
		
		
		int[] arr = new int[26];
		for(int c = 0; c < s.length(); c++) {
			arr[sArr[c] - 97]++;
		}
		
		
		for(int i= 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
//		System.out.println((int)'a');
	}
}
