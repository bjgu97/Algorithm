package 골드;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BJ_1747_소수팰린드롬 {
	static class Point {
		int x;
		int y;
		
		Point(int x, int y) {
			this.x = x;
			this.y= y;
		}

		@Override
		public String toString() {
			return "Point [x=" + x + ", y=" + y + "]";
		}
		
		
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		// 소수 구하기
		boolean[] arr = new boolean[2000000];
		Arrays.fill(arr, true);
		arr[1] = false;
		for(int i = 2; i < arr.length; i++) {
			for(int j = i * 2; j < arr.length; j+=i) {
				arr[j] = false;
			}
		}
		
		
		for(int i = 1; i < arr.length; i++) {
			if(arr[i] == true && i >= N) { // 소수이면
//				System.out.println("i: " + i);
				boolean check = checkPalindrome(i);
				if(check) {
					System.out.println(i);
					break;
				}
			}
		}
	}
	
	static boolean checkPalindrome(int n) {
		String s = Integer.toString(n);
		char[] cArr = s.toCharArray();
//		System.out.println("cARr: " + Arrays.toString(cArr));
		boolean flag = true;
		for(int i = 0; i < cArr.length; i++) {
//			System.out.println("cArr[i]: " + cArr[i]);
//			System.out.println("cArr[N-1-i]: " + cArr[cArr.length-1-i]);
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
