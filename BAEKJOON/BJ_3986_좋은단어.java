

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class BJ_3986_좋은단어 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int TC = Integer.parseInt(br.readLine());
		int answer = 0;
		for(int t = 0; t < TC; t++) {
			String s = br.readLine();

			Stack<Character> stack = new Stack<>();
			stack.push(s.charAt(0));
			
			for(int i = 1; i < s.length(); i++) {
				if(!stack.isEmpty() && stack.peek() == s.charAt(i)) {
					stack.pop();
				}
				else if(!stack.isEmpty() && stack.peek() != s.charAt(i)){
					stack.push(s.charAt(i));
				}
				else if(stack.isEmpty()) {
					stack.push(s.charAt(i));
				}
			}
			
			if(stack.isEmpty()) {
				answer++;
			}
			
		}
		
		System.out.println(answer);
	}
}
