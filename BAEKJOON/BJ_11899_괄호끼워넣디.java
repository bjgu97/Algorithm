import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class BJ_11899_괄호끼워넣디 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String S = br.readLine();
		int L = S.length(); 
		
		Stack<Character> stack = new Stack<>();
		int answer = 0;
		for(int s = 0; s < L; s++) {
			char c = S.charAt(s);
			// 비어있고 ) 들어오면 ++
			if(stack.isEmpty() && c == ')') {
				answer++;
				continue;
			}
			else if(stack.isEmpty() && c == '(') {
				stack.push(c);
			}
			else if(stack.peek() == '(' && c == ')') {
				stack.pop();
			}
			else {
				stack.push(c);
			}
			
		}
		
		while(!stack.isEmpty()) {
			stack.pop();
			answer++;
		}
		
		System.out.println(answer);
	}
}
