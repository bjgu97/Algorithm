

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BJ_1919_애너그램만들기 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s1 = br.readLine();
		String s2 = br.readLine();
		
		int[] arr1 = new int[26];
		int[] arr2 = new int[26];
		
		for(int i = 0; i < s1.length(); i++) {
			arr1[s1.charAt(i) - 97]++;
		}
		
		for(int i = 0; i < s2.length(); i++) {
			arr2[s2.charAt(i)-97]++;
		}
		
		int answ = 0;
		for(int i = 0; i < arr1.length; i++) {
			answ += Math.abs(arr1[i] - arr2[i]);
		}
		
		System.out.println(answ);
	}
}
