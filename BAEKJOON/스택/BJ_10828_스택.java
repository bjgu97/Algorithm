package 스택;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class BJ_10828_스택 {
public static void main(String[] args) throws NumberFormatException, IOException {
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	StringTokenizer st;
	StringBuilder sb = new StringBuilder();
	int N = Integer.parseInt(br.readLine());
	Stack<Integer> stack = new Stack<>();
	
	for(int n = 0; n < N; n++) {
		st = new StringTokenizer(br.readLine());
		String command = st.nextToken();
		switch(command) {
		case "push":
			int num = Integer.parseInt(st.nextToken());
			stack.push(num);
			break;
		case "top":
			if(stack.isEmpty())
				sb.append(-1).append("\n");
			else
				sb.append(stack.peek()).append("\n");
			break;
		case "size":
			sb.append(stack.size()).append("\n");
			break;
		case "empty":
			if(stack.isEmpty())
				sb.append(1).append("\n");
			else
				sb.append(0).append("\n");
			break;
		case "pop":
			if(stack.isEmpty())
				sb.append(-1).append("\n");
			else
				sb.append(stack.pop()).append("\n");
		}
	}
	
	System.out.println(sb);
}
}
