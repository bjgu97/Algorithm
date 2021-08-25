

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class BJ_4889_안정적인문자열 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		

		int t = 0; //test case
		
		while(true) {
			int cnt = 0;
			t++;
			String s = br.readLine();
			
			//while문 종료 조건
			if(s.charAt(0) == '-')
				break;
			
			Stack<Character> stack =  new Stack<>();

			for(int i= 0; i < s.length(); i++) {
				if(s.charAt(i) == '{') { // 여는 괄호 들어오면 그냥 삽입
					stack.push('{');
				}
				else {
					if(stack.isEmpty()) { // 첫 번째로 }가 들어오면
						stack.push('{');
						cnt++; // { 를 }로 바꿔줬으니,,
					}
					else { //  }가 들어오면
						stack.pop(); 
					}
				}
			}
//			System.out.println(cnt);
			cnt += stack.size()/2;
			
//			System.out.println(stack);
			sb.append(t).append(".").append(" ").append(cnt).append("\n");
			//stack.clear();
		}
		System.out.println(sb);
	}
}
