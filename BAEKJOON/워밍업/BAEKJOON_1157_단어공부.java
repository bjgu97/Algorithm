package 워밍업;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BAEKJOON_1157_단어공부 {
	static int[] arr = new int[100];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s= br.readLine();
		String upperS = s.toUpperCase();
		
		
		for(int i = 0;i < upperS.length(); i++) {
//			System.out.print(upperS.charAt(i) + " ");
//			System.out.println((int)upperS.charAt(i));
//			System.out.println();
			arr[(int)upperS.charAt(i)]++;
			//arr[Integer.parseInt(String.valueOf(upperS.charAt(i)))] ++;
		}
		
		System.out.println(Arrays.toString(arr));
		
		int max = 0;
		for(int i = 0; i < arr.length; i++) {
			max = Math.max(max, arr[i]);
		}
	}
}
