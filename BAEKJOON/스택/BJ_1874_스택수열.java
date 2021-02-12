package 스택;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class BJ_1874_스택수열 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine()); // 8
		Stack<Integer> stack = new Stack<>();
		StringBuilder sb = new StringBuilder();
		int i = 0;
		int[] arr = new int[n];
		int num = 1;
		
		for(int a = 0;a < n; a++) {
			arr[a] = Integer.parseInt(br.readLine());
		}
		
		//최초 1회 실행
		for(int m= 1;m <= arr[i];m++) {
			stack.push(num++);
			sb.append("+").append("\n");
		}
		
		
		boolean check = true;
		
		//반복
		int cnt = 0;
		while(true) {
			cnt++;
			
			System.out.println(cnt);
			System.out.println(stack);
			if(stack.isEmpty() && i == n) {
				check = true;
				break;
			}
//			else if(stack.isEmpty()) {
//				check = false;
//				break;
//			}

			if(stack.isEmpty() && cnt == n) {
				check = true;
				break;
			}
			
			// 스택 비어있는지 먼저 확인. 
			if(stack.isEmpty())
				continue;
			

			
			if(stack.peek() == arr[i]) {
				stack.pop();
				sb.append("-").append("\n");
				i++;
			}
			
			else {
				while(stack.peek() != arr[i]) {
					stack.push(num++);
					sb.append("+").append("\n");
					if(stack.peek() == arr[i])
						break;
				}
			}
		}
		
		
		if(check)
			System.out.println(sb);
		else
			System.out.println("NO");
		}
	}