package 워밍업;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BJ_1157_단어공부 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		
		String sCapital = s.toUpperCase();
		// 각 캐릭터 숫자로 변환 후 배열 저장
		int[] arr = new int[100];
		
		for(int i = 0; i < sCapital.length(); i++) {
			arr[sCapital.charAt(i)-65]++;
		}
		
		int max = 0;
		char c = ' ';
		for(int i = 0;i < arr.length; i++) {
			if(arr[i] > max) {
				max = arr[i];
				c = (char)(i + 65);
			}
			else if(arr[i] == max)
				c = '?';
		}
		System.out.println(c);
	}
}
