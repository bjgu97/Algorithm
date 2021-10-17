

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class BJ_1283_단축키지정 {
	static char c;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		List<Character> registeredChar = new ArrayList<>();

		for(int n = 0; n < N; n++) {
			boolean check = false;
			String s = br.readLine();
			
			// 1단계: 첫 글자 등록
			if(s.charAt(0) != ' ' && !registeredChar.contains(Character.toLowerCase(s.charAt(0)))) {
				check = true;
				registeredChar.add(Character.toLowerCase(s.charAt(0))); // 첫글자 등록
				print(0, s);
			}
			else {
				// 2단계: 공백 다음 글자 등록
				for(int i = 0; i < s.length(); i++) {
					if(s.charAt(i) == ' ' && s.charAt(i+1) != ' ') {
						if(!registeredChar.contains(Character.toLowerCase(s.charAt(i+1)))) {
							check = true;
							registeredChar.add(Character.toLowerCase(s.charAt(i+1)));
							print(i+1, s);
							break;
						}
					}
				}
				
				// 3단계: 차례대로 알파벳을 보면서 등록 안된 문자 등록
				if(!check) {
					for(int i = 0; i < s.length(); i++) {
						if(s.charAt(i) != ' ' && !registeredChar.contains(Character.toLowerCase(s.charAt(i)))) {
							check = true;
							registeredChar.add(Character.toLowerCase(s.charAt(i)));
							print(i, s);
							break;
						}
					}
				}
	
			}
			
			// 4단계: 어떠한 것도 단축키로 지정할 수 없다면 그냥 놔두기
			if(!check) {
				for(int i = 0; i < s.length(); i++) {
					System.out.print(s.charAt(i));
				}
				System.out.println();
			}
			
		}
	}
	
	static void print(int a, String s) {
		for(int i = 0; i < a; i++) {
			System.out.print(s.charAt(i));
		}
		System.out.print('[');
		System.out.print(s.charAt(a));
		System.out.print(']');
		for(int i = a+1; i < s.length(); i++) {
			System.out.print(s.charAt(i));
		}
		System.out.println();
	}
}


