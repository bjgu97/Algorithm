package 스택;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class BJ_1406_에디터 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		String s = br.readLine();
		Stack<Character> stack = new Stack<>();
		Stack<Character> tmpStack = new Stack<>();
		
		for(int i = 0; i < s.length(); i++) {
			stack.push(s.charAt(i));
		}
		
		
		int M = Integer.parseInt(br.readLine());
		
		for(int m = 0; m < M; m++) {
			st = new StringTokenizer(br.readLine());
			char c = st.nextToken().charAt(0);
			
			switch(c) {
			case 'P': // 값 추가
				char p = st.nextToken().charAt(0);
				stack.push(p);
				break;
			case 'L': // 왼쪽으로 하나 이동
				if(stack.isEmpty())
					continue;
				tmpStack.push(stack.pop());
				break;
			case 'D':
				if(tmpStack.isEmpty())
					continue;
				stack.push(tmpStack.pop());
				break;
			case 'B': // 왼쪽 삭제
				if(stack.isEmpty())
					continue;
				stack.pop();
				break;
			}
		}
		
		if(!tmpStack.isEmpty()) {
			int size = tmpStack.size();
			for(int i = 0; i < size; i++) {
				stack.push(tmpStack.pop());
			}
		}
		
		int stackSize = stack.size();
		char[] arr = new char[stackSize];
		
		for(int i = 0; i < stackSize; i++) {
			arr[stackSize-i-1] = stack.pop();
		}
		for(int i = 0; i < stackSize; i++) {
			sb.append(arr[i]);
		}
		
		System.out.println(sb);
	}

}
