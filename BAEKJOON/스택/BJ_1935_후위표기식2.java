/**
* @since 2021. 2. 9.
* @author bjgu9
* @see https://www.acmicpc.net/submit/1935
* @mem
* @time
* @caution 꼭 다시 풀어보기. 스택 말고 다른부분(형변환, etc)에서 오래걸림. 
*/
package 스택;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;


public class BJ_1935_후위표기식2 {
	static int[] arr = new int[255];
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// 피연산자 개수 N
		int N = Integer.parseInt(br.readLine());
		
		//후위표기식 (문자열)
		String s = br.readLine();
		
		// 피연산자 (double)
		double[] nArr = new double[N];
		for(int n = 0; n < N; n++) {
			nArr[n] = Integer.parseInt(br.readLine());  // 10 2 3
		}
		
		// [10 2 3]
		
		// 스택
		Stack<Double> stack = new Stack<>();
		double op = 0;
		
		for(int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if(c == '*' || c == '/' || c == '-' || c == '+') {
				double op1 = stack.pop(); // A, B, ...
				double op2 = stack.pop();
				
				if(c == '*') 
					op = op1 * op2;
				else if(c == '/') 
					op = op2 / op1;
				else if(c == '-') 
					op = op2 - op1;
				else if(c == '+') {
					op = op1 + op2;
				}
				stack.push(op);
			}
			else {
				//System.out.println("c: " + c);
				//System.out.println(nArr[c-'A']);
				stack.push(nArr[c-'A']);
			}
			
		}
		
		System.out.printf("%.2f", stack.pop()); // char to int
	}
}
