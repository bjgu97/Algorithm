package 스택;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.StringTokenizer;

public class BJ_12789_도키도키간식드리미 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine()); // 학생들의 수
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		Stack<Integer> stack = new Stack<>();
		
		int num = 1;
		for(int n = 1; n <= N; n++) {
			int m = Integer.parseInt(st.nextToken());
//			System.out.println(stack);
			stack.push(m);
			while(!stack.isEmpty()) {
				if(stack.peek() == num) {
					num++;
					stack.pop();
				}
				else 
					break;
			}
		}			
		if(stack.isEmpty())
			System.out.println("Nice");
		else
			System.out.println("Sad");
	}
}
