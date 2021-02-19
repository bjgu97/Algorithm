package 완전탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BJ_1436_영화감독숌 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		int num = 666;
		int cnt = 1;
		while(N != cnt) {
			num++;
			String s = Integer.toString(num);
			if(s.contains("666"))
				cnt++;
		}
		
		System.out.println(num);
//		if(N == 1)
//			System.out.println(666);
//		else {
//			for(int a = 667; a < Integer.MAX_VALUE; a++) {
//				String s = Integer.toString(a);
//				char[] arr = s.toCharArray();
//				for(int i = 0; i <= arr.length-3; i++) {
//					if(arr[i] == '6' && arr[i+1] == '6' && arr[i+2] == '6') {
//						cnt++;
//						if(cnt == N)
//							System.out.println(s);
//					}
//				}
//				
//			}
//		}
		
	}
}

