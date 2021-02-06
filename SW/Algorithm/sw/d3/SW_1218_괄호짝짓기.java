package Algorithm.sw.d3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;


public class SW_1218_괄호짝짓기 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		for(int i= 0; i < 10; i++) {
			int N = Integer.parseInt(br.readLine());
		    Stack<Character> stack = new Stack<>();
		    
		    String s = br.readLine();
			
			
			//리스트 여러개 생성
			List<Character> list1 = new ArrayList<>();
			List<Character> list2 = new ArrayList<>();
			List<Character> list3 = new ArrayList<>();
			List<Character> list4 = new ArrayList<>();
			
			for(int j  = 0; j < arr.length; j++) {
				char c = arr[j];
				if(c == ')')
			}
						
//			for(int j= 0; j < arr.length; j++) {
//				char c = arr[j];
//				if (c=='('||c=='['||c=='{'||c=='<') 
//                    stack.push(c);
//				else {
//					if(c == ')' && stack.peek() == '(' && !stack.isEmpty()) 
//						stack.pop();
//					else if(c == ']' && stack.peek() == '[' && !stack.isEmpty()) 
//						stack.pop();
//					else if(c == '}' && stack.peek() == '{' && !stack.isEmpty()) 
//						stack.pop();
//					else if(c == '>' && stack.peek() == '<' && !stack.isEmpty()) 
//						stack.pop();
//				}
//			}
			
			sb.append("#").append(i+1).append(" ").append(stack.size() == 0 ? 1:0).append("\n");

		}
		
		System.out.println(sb);
	}
}