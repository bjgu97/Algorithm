

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;


public class BJ_1431_시리얼번호 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		//N개 입력받기
		String [] arr = new String[N];

		for(int n = 0; n < N; n++) {
			String s = br.readLine();
			arr[n] = s;
		}
		
		Arrays.sort(arr, (s1, s2) -> {
			if(s1.length() != s2.length()) 
				return Integer.compare(s1.length(), s2.length());
			else {
				int sum1 = 0;
				int sum2 = 0;
				
				for(int c = 0; c < s1.length(); c++) {
					if(Character.isDigit(s1.charAt(c))) {
						sum1 += s1.charAt(c) - '0';
					}
				}
				
				for(int c = 0; c < s2.length(); c++) {
					if(Character.isDigit(s2.charAt(c))) {
						sum2 += s2.charAt(c) - '0';
					}
				}
				
				if(sum1 != sum2)
					return Integer.compare(sum1, sum2);
				else
					return s1.compareTo(s2);
			}
		});
		
		
//		Arrays.sort(arr, new Comparator<String>() {
//			@Override
//			public int compare(String s1, String s2) {
//				// 조건1:  A, B 길이가 다르면 짧은것이 앞에
//				if(s1.length() != s2.length()) 
//					return Integer.compare(s1.length(), s2.length());
//				else {
//					int sum1 = 0;
//					int sum2 = 0;
//					for(int c = 0; c < s1.length(); c++) {
//						if(Character.isDigit(s1.charAt(c))) {
//							sum1 += s1.charAt(c) - '0';
//						}
//					}
//					
//					for(int c = 0; c < s2.length(); c++) {
//						if(Character.isDigit(s2.charAt(c))) {
//							sum2 += s2.charAt(c) - '0';
//						}
//					}
//					
//					if(sum1 != sum2)
//						return Integer.compare(sum1, sum2);
//					else
//						return s1.compareTo(s2);
//				}
//			
//			}
//		});
		
		for(String s:arr)
			sb.append(s).append("\n");
		System.out.println(sb);
	}
}
