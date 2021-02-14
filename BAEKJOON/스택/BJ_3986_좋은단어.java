package 스택;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class BJ_3986_좋은단어 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int TC = Integer.parseInt(br.readLine());
		int answer = 0;
		
		for(int tc = 0; tc < TC; tc++) {
			Stack<Character> stack = new Stack<>();
			
			String s = br.readLine(); //ABAB
			stack.push(s.charAt(0));
			
			for(int i = 1; i < s.length(); i++) {
				char c = s.charAt(i);
				if(!stack.isEmpty()) {
					if(stack.peek() == c) // 같으면 pop
						stack.pop();
					else
						stack.push(c);
				}
				else
					stack.push(c);
			}
			
			if(stack.isEmpty())
				answer++;
		
		}
		System.out.println(answer);
	}
}
