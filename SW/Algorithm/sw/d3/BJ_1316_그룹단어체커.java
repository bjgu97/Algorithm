package Algorithm.sw.d3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class BJ_1316_그룹단어체커 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		int answer = 0;
		
		for(int n = 0; n < N; n++) {
			String s = br.readLine(); // aabbbccb
			List<Character> list = new ArrayList<>();

//			System.out.println(s);
			boolean check = true;
			for(int i = 0; i < s.length(); i++) {
				char c = s.charAt(i); // a , b, c, ..
				//System.out.println(list.get(i-1));
//				System.out.println(c);
//				System.out.println(i);
				
				if(list.isEmpty()) { // 리스트 비어있으면 추가하기
					list.add(c);
				}
				else if(list.get(i-1) == c) { // 이전 같은 문자면 추가하기 
					list.add(c);
				}
				else if(list.get(i-1) != c && !list.contains(c)) {// 이전에 같은 문자 없으면 추가하기 
					list.add(c); 
				}
				else if(list.get(i-1) != c && list.contains(c)) { // 이전에 같은 문자 있으면 탈락
					check = false;
					break;
				}
					
			}
			if(check == true)
				answer ++;

		}
		
		System.out.println(answer);
	}
}
