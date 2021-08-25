

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class BJ_4949_균형잡힌세상 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		Boolean check = true;
		while(true) {
			check = true;
			String sentence = br.readLine();
			if(sentence.charAt(0) == '.') {
				break;
			}
			
			Stack<Character> stack = new Stack<>();
			System.out.println(stack);
			for(int i = 0; i < sentence.length(); i++) {
					char c = sentence.charAt(i);

					if(c == '[' || c == '(')
						stack.push(c);
					
					else if(c == ']') {
						if(stack.isEmpty() || stack.peek() != '[') {
							check = false;
							break;
						}
						else //stack.peek() == '['
							stack.pop();
					
					}	
					
					else if(c == ')') {
						if(stack.isEmpty() || stack.peek()!= '(') {
							check=false;
							break;
						}
						else //stack.peek() == '('
							stack.pop();
					}
					
					//System.out.println(stack);
				}

				
			
			if(stack.isEmpty() && check != false) {
				sb.append("yes").append("\n");
			}
			else if(!stack.isEmpty() || check == false) {
				sb.append("no").append("\n");
			}
		}

		System.out.println(sb);

	}
}

