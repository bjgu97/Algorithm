

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;

public class BJ_1874_스택수열 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());

		int[] arr = new int[N];
		for(int n = 0; n < N; n++) {
			arr[n] = Integer.parseInt(br.readLine());
		}
				
		Stack<Integer> stack = new Stack<>();
	
		int idx = 0;
		for(int i = 1; i <= N; i++) {
			stack.push(i);
			sb.append("+").append("\n");
			
			while(!stack.isEmpty() && stack.peek() == arr[idx]) {
				stack.pop();
				sb.append("-").append("\n");
				idx++;
			}
			
		}
		
		if(stack.isEmpty()) {
			System.out.println(sb);
		}
		else
			System.out.println("NO");
	
	}
}