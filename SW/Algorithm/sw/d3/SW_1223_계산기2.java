package Algorithm.sw.d3;

import java.awt.List;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Stack;

public class SW_1223_계산기2 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		for(int t = 1; t <= 10; t++) {
			//문자열 길이
			int N = Integer.parseInt(br.readLine());
			// 문자열 : 3+4+5*6+7
			String s = br.readLine();
			
			Stack<String> number = new Stack<>();
			Stack<String> operation = new Stack<>();
			
			// 연산자 하나씩 스택에 삽입 
			int n = 0;
			while(true) {
				char c = s.charAt(n);
				// 상수이면 number 스택에 쌓고
				if(c != '+' && c != '*') {
					number.push(Character.toString(c));
					n++;
				}
				// 연산자이면 operation 스택에 쌓고
				else if(c == '+') {
					operation.push(Character.toString(c));
					n++;
				}
				else if(c == '*') {
					String a = number.pop();
//					System.out.println("a: " + a);
					char b = s.charAt(++n);
//					System.out.println("b: " + b);
					int ab = Integer.parseInt(String.valueOf(a)) * Integer.parseInt(String.valueOf(b));
					number.push(Integer.toString(ab));
					n++;
				}
				System.out.println(number);
				System.out.println(operation);
				System.out.println();
				if(n == N)
					break;
			}
			
			int sum = 0;
			System.out.println("number size: " + number.size());
			while(!number.isEmpty())
				sum += Integer.parseInt(number.pop());
			

			sb.append("#").append(t).append(" ").append(sum).append("\n");
		}
		System.out.println(sb);
	}
}
