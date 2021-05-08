package 골드;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BJ_1747_소수팰린드롬 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		// 1. 소수 구하기 - 에라토스테네스의 체
		boolean[] arr = new boolean[1003002]; // 배열 크기: (1000000 넣었을때 나오는 값 + 1)
		Arrays.fill(arr, true);
		arr[1] = false;
		for(int i = 2; i < arr.length; i++) {
			for(int j = i * 2; j < arr.length; j+=i) {
				arr[j] = false;
			}
		}
		
		// 2. 소수 중 팰린드롬 구하기
		for(int i = N; i < arr.length; i++) {
			if(arr[i] == true) { // 소수이면
				boolean check = checkPalindrome(i); // 팰린드롬 검사
				if(check) {
					System.out.println(i);
					break;
				}
			}
		}
	}
	
	// 3. 팰린드롬 검사
	static boolean checkPalindrome(int n) {
		String s = Integer.toString(n);
		char[] cArr = s.toCharArray();
		boolean flag = true;
		
		// 문자열로 변환 후 앞뒤 동일 여부 검사
		for(int i = 0; i < cArr.length; i++) {
			if(cArr[i] != cArr[cArr.length-1-i]) {
				flag = false;
			}
		}
		
		if(flag)
			return true;
		else
			return false;
	}
}
