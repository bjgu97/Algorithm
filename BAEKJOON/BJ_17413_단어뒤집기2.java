import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class BJ_17413_단어뒤집기2 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String S = br.readLine();
		StringBuilder sb = new StringBuilder();
		
		char[] SArr = S.toCharArray(); // 캐릭터로 구분해서 배열로 만들기
		
		Stack<Character> stack = new Stack<>();
		boolean tag = false;
		for(int i = 0; i < SArr.length; i++) {
			char c = SArr[i];
			
			// 문자 나오면 스택에 저장
			if((Character.isDigit(c) || Character.isLetter(c)) && tag == false) {
				stack.push(c);
			}
			
			// 공백 나오면 거꾸로 출력
			else if(c == ' ') {
				while(!stack.isEmpty())
					sb.append(stack.pop());
				sb.append(' ');
			}
			
			// < 나오면 그냥 출력
			else if(c == '<') {
				while(!stack.isEmpty()) {
					sb.append(stack.pop());
				}
				tag = true;
				sb.append(c);
			
			}
			
			// 태그 안에서 문자가 나오면
			else if((Character.isDigit(c) || Character.isLetter(c)) && tag == true) {
				sb.append(c);
			}
			
			// > 나오면 
			else if(c == '>') {
				tag = false;
				sb.append(c);
			}

		}
		
		while(!stack.isEmpty())
			sb.append(stack.pop());
		
		System.out.println(sb);
	}
}
