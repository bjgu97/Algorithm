package 스택;

import java.awt.List;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Stack;

public class 백준_1935_후위표기식 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		Stack<Character> stack = new Stack<>();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		String s = br.readLine();
		ArrayList<Integer> list = new ArrayList<Integer>();
		
		for(int n = 0; n < N; n++) {
			int A = Integer.parseInt(br.readLine());
			list.add(A);
		}
		
		System.out.println(list);
		System.out.println(s);
		
		for(int n = 0; n < 2*N-1; n++) {
			
		}
	}
}
