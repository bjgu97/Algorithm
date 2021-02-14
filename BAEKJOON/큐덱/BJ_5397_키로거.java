package 큐덱;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;



public class BJ_5397_키로거 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int TC = Integer.parseInt(br.readLine());
		
		for(int tc = 0; tc < TC; tc++) {
			Stack<Character> stack = new Stack<>();
			Stack<Character> tmpStack = new Stack<>();
			
			String s = br.readLine();
			
			for(int i = 0; i < s.length(); i++) { //1000000
				if(s.charAt(i) == '<') {
					if(stack.isEmpty())
						continue;
					else {
						tmpStack.push(stack.pop());
						
					}
				}
				else if(s.charAt(i) == '>') {
					if(tmpStack.isEmpty())
						continue;
					else
						stack.push(tmpStack.pop());
				}
				else if(s.charAt(i) == '-') {
					if(stack.isEmpty())
						continue;
					stack.pop();
				}
				// 문자가 나오면
				else {
					stack.push(s.charAt(i)); // 넣어준다.
				}
					
				
			}
			
			if(!tmpStack.isEmpty()) {
				int size = tmpStack.size();
				for(int i = 0; i < size; i++) {
					stack.push(tmpStack.pop());
				}
			}
			int size = stack.size();
			char[] arr = new char[size];
			for(int i= 0; i < size; i++) {
				arr[size-1-i] = stack.pop();
			}
			for(int i = 0; i < size; i++) {
				sb.append(arr[i]);
			}
			sb.append("\n");
		
		}
		System.out.println(sb);
	}
}
