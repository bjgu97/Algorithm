package Study4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class BJ_8595_히든넘버 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine()); // 단어의 길이
		String s = br.readLine(); // 단어
		String temp = "";
		long sum = 0l;
		long num = 0l;
		int k = 1;
		List<Integer> list = new ArrayList<Integer>();
		Stack<Integer> stack = new Stack<Integer>();
		
		for(int i = 0; i <n; i++ ) {
			if(s.charAt(i) >= '0' && s.charAt(i) <= '9') {// 숫자 나오면
				int digit = s.charAt(i) - '0';
				num = 10 * num + digit;
//				System.out.println("num: " + num);
				//stack.push(s.charAt(i) - '0');
			}
			
			else { // 문자 나오면 스택에 있는 숫자들 더해준다.
				sum += num;
				num = 0l;
//				k = 1;
//				while(!stack.isEmpty()) {
//					num = num + k * stack.pop();
//					k = k * 10;
//				}
////				System.out.println("num: " + num);
//				sum += num;
//				num = 0;
////				System.out.println("sum: " + sum);
//				stack.clear();
			}
			
			
			
//			System.out.println(stack);
		}
		if(num!= 0) sum += num;
		System.out.println(sum);
	}
}
