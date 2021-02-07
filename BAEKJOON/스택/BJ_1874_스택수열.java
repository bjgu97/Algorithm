package 스택;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;

public class BJ_1874_스택수열 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine()); // 8
		//int n = 8;
		Stack<Integer> stack = new Stack<>();
		StringBuilder sb = new StringBuilder();
		int i = 0;
		int[] arr = new int[n];
		
		int num = 1;
		
		//입력받고
		for(int a = 0;a < n; a++) {
			arr[a] = Integer.parseInt(br.readLine());
		}
		
		
		//최초 1회 실행
		if(stack.isEmpty()) {
			for(int m= 1;m <= arr[i];m++) {
				stack.push(num++);
				sb.append("+").append("\n");
			}
		}
		
		boolean check = true;
		
		while(true) {

			// 스택 비울 때 까지(n까지 다 돌면)
			if(stack.isEmpty() && i == n) { 
				check = true;
				break;
			}

			}

				if(stack.peek() == arr[i]) {
					stack.pop();
					sb.append("-").append("\n");
	//				System.out.println(stack);
	//				System.out.println(sb);
					i++;
				}
				else {
	//				System.out.println("111");
	//				System.out.println(stack.peek());
	//				System.out.println(arr[i]);
					while(stack.peek() != arr[i]) {
						stack.push(num++);
						sb.append("+").append("\n");
	//					System.out.println(stack);
	//					System.out.println(sb);
						if(stack.peek() == arr[i])
							break;
					}
				}
			
//			if(stack.size() == 2) {
//				if(stack.pop() > stack.peek()) {
//					check = false;
//					break;
//				}
//			}
		
		if(check)
			System.out.println(sb);
		else
			System.out.println("NO");
		}
	}

