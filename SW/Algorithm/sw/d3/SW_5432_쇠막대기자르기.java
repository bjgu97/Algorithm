package Algorithm.sw.d3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;
import java.util.StringTokenizer;

public class SW_5432_쇠막대기자르기 {
	static int N;
	static int[] arr;
	static Stack<Integer> hight = new Stack<>();
	static Stack<Integer> index = new Stack<>();
//	public static void main(String[] args) throws IOException {
//
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
//
//		//int N = Integer.parseInt(br.readLine());
//		//arr = new int[N + 1];
//		String str = br.readLine();
//		StringTokenizer st = new StringTokenizer(str, " ");
//
//		for (int i = 1; N >= i; ++i) {
//			arr[i] = Integer.parseInt(st.nextToken());
//		}
//
//		hight.push(arr[1]);
//		index.push(1);
//		bw.write(""+0);
//
//		for (int i = 2; N >= i; ++i) {
//			while (true) {
//				if (!hight.isEmpty()) {
//					int top = hight.peek();
//					if (top > arr[i]) {
//						bw.write(" " + index.peek());
//						hight.push(arr[i]);
//						index.push(i);
//						break;
//					} else {
//						hight.pop();
//						index.pop();
//					}
//				} else {
//					bw.write(" " + 0);
//					hight.push(arr[i]);
//					index.push(i);
//					break;
//				}
//			}
//		}
//		bw.flush();
//	}
public static void main(String[] args) throws NumberFormatException, IOException {
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	int T = Integer.parseInt(br.readLine());
    Stack<Character> stack = new Stack<>();
    StringBuilder sb = new StringBuilder();
	for(int t = 0; t < T; t++) {
		
		
		String s = br.readLine();
		int numLine = 0;
		int sum = 0;
		for(int i = 0; i < s.length(); i++) {
			char v = s.charAt(i);
			
			if(stack.isEmpty())
				stack.add(v);
			else if(v == ')' && stack.peek() == '(') {
//				System.out.println(i + "레이저 발견");
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
//			System.out.println("sum: " + sum);
//			System.out.println("numLine: " + numLine);
		}
		
		sb.append("#").append(t+1).append(" ").append(sum).append("\n");
	}
	System.out.println(sb);
}
}
