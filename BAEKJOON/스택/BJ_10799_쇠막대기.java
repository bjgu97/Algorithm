package 스택;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class BJ_10799_쇠막대기 {
	static int N;
	static int[] arr;
	static Stack<Integer> hight = new Stack<>();
	static Stack<Integer> index = new Stack<>();

public static void main(String[] args) throws NumberFormatException, IOException {
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    Stack<Character> stack = new Stack<>();
		
		
	String s = br.readLine();
	int numLine = 0;
	int sum = 0;
	for(int i = 0; i < s.length(); i++) {
		char v = s.charAt(i);
		
		if(stack.isEmpty())
			stack.add(v);
		else if(v == ')' && stack.peek() == '(') {
			sum += numLine;
			stack.add(v);
		}
		else if(v == '(' && stack.peek() == ')') {
			stack.add(v);
		}
		else if(v == '(' && stack.peek() == '(') {
			numLine ++;
			stack.add(v);
		}
		else if(v == ')' && stack.peek() == ')') {
			sum += 1;
			numLine--;
			stack.add(v);
		}

	}
		
	System.out.println(sum);
}
}
