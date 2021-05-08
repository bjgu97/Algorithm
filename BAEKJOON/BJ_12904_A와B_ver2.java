import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ_12904_A와B_ver2 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String S = br.readLine();
		String T = br.readLine();
		
		System.out.println(func(S, T));
		
	}
	
	static int func(String S, String T) {
		// S -> T
		// 1. 문자열 뒤에 A 추가
		// 2. 문자열 뒤집고 B 추가
		
		// T -> S
		// 1. 문자열 뒤 A 빼기
		// 2. 문자열 뒤 B 빼고 문자열 뒤집기
		
		
		// 문자열 뒤가 A이면 A 빼기
		// 문자열 뒤가 B이면 B 뺴고 문자열 뒤집기
		
		char[] TArr = T.toCharArray();
		
		boolean flag = false;
		while(true) {

			// 문자열이 S가 되면
			if(T.equals(S)) {
				flag = true;
				break;
			}
			else if(T.length() <= S.length()) {
				flag = false;
				break;
			}
			
			
			// 문자열 뒤가 A이면
			if(T.charAt(T.length()-1) == 'A') {
				// A 빼기
				T = T.substring(0, T.length()-1);
			}
			// 문자열 뒤가 B이면
			else if(T.charAt(T.length()-1)  == 'B') {
				// B 빼고
				T = T.substring(0,T.length()-1);
				//문자열 뒤집기
				char[] tempT = new char[T.length()];
				for(int i = 0; i < T.length(); i++) {
					tempT[i] = T.charAt(T.length()-1-i);
				}
				String newT = "";
				for(int i = 0; i < T.length(); i++) {
					newT = newT + tempT[i];
				}
				T = newT;
			}
						
		}
		if(flag)
			return 1;
		else
			return 0;
		
	}
}
