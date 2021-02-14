package Study4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;


public class BJ_1431_시리얼번호 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		
		//N개 입력받기
		String [] arr = new String[N];

		for(int n = 0; n < N; n++) {
			String s = br.readLine();
			arr[n] = s;
		}
		
		// 임의 기준으로 정렬 => comparator
		Arrays.sort(arr, new Comparator<String>() {
			@Override
			public int compare(String s1, String s2) {
				// 1) 길이 다르면 짧은 것 먼저. 
				if(s1.length() < s2.length())
					return -1; //
				else if(s1.length() > s2.length()) { 
					return 1; // 
				}
				
				// 2) 길이 같으면 자리수 합 비교
				else if(s1.length() == s2.length()) {
					int sum1 = 0;
					int sum2 = 0;
					
					for(int i= 0; i < s1.length(); i++) {
						if(s1.charAt(i) >= '0' && s1.charAt(i) <= '9') //숫자인 것만 더하기. 
							sum1 += s1.charAt(i) - '0';
					}
					
					for(int i= 0; i < s2.length(); i++) {
						if(s2.charAt(i) >= '0' && s2.charAt(i) <= '9')
							sum2 += s2.charAt(i) - '0';
					}
					
					if(sum1 > sum2)
						return 1;
					else if(sum1 < sum2)
						return -1;
					
					// 3) 둘다 안되면 사전순 비교
					else
						return s1.compareTo(s2); //일반적인정렬 (s1>s2이면 1)
					}
				return 1;		
			}
		});
		
		for(int i = 0; i < arr.length; i++) {
			sb.append(arr[i]).append("\n");
		}
		System.out.println(sb);
	}
}
