

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ_1283_단축키지정 {
	static char c;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		boolean[] count = new boolean[130]; //등록 글자 저장 배열
		
		for(int n = 0; n < N; n++) {
			boolean check = false;

			String s = br.readLine();
			char[] cArr2 = s.toCharArray(); // 문자 담는 배열
			
			s = s.toLowerCase();
			char[] cArr = s.toCharArray(); // 소문자 변환 문자 담는 배열 (대소문자 구분X)
			
			
			// string의 첫글자 살펴보기
			if(cArr[0] != ' ' && count[cArr[0]] == false) { // 첫글자 등록되어있지 않으면
				check = true;
				count[cArr[0]] = true; // 등록 하고
				
				//출력
				printWord(0, cArr2);				
				continue;
			}
			
			// 첫글자 등록되어 있으면
			else { 
				//공백 다음에 나오는 글자 살펴보기
				for(int i = 0; i < cArr.length-1; i++) {
					if(cArr[i] == ' ' && cArr[i+1] != ' ') { // 공백 다음에 글자가 나오고
						if(count[cArr[i+1]] == false) { //등록되어있지 않다면
							check = true;
							count[cArr[i+1]] = true; //등록 하고
							//출력
							printWord(i+1, cArr2);
							break;
						}
					}
				}
				
				// 나머지 글자들 살펴보기
				if(!check) {
					for(int i = 0; i < cArr.length; i++) {
						if(cArr[i] != ' ' && count[cArr[i]] == false) {
							check = true;
							count[cArr[i]] = true;
							
							//출력
							printWord(i, cArr2);
							break;
						}
					}
				}
			}
			
			// 모든 글자가 다 등록되어있으면 그냥 출력
			if(!check) {
				for(int i = 0; i < cArr2.length; i++) {
					System.out.print(cArr2[i]);
				}
				System.out.println();
			}
		}
	}
	
	static void printWord(int a, char[] cArr2) {
		for(int i = 0; i < a; i++) {
			System.out.print(cArr2[i]);
		}
		System.out.print('[');
		System.out.print(cArr2[a]);
		System.out.print(']');
		for(int i = a+1; i < cArr2.length; i++) {
			System.out.print(cArr2[i]);
		}
		System.out.println();
	}
}
