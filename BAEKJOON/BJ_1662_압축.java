import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class BJ_1662_압축 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String S = br.readLine();
		
		Stack<String> stack  = new Stack<>();
		Stack<Integer> len = new Stack<>();
		
		for(int s = 0; s < S.length(); s++) {
			String c = S.charAt(s) + "";

			if(c.equals(")")) {

				int l = 0;
				while(true){
             		String cc = stack.pop(); // 9
             		
             		System.out.println("cc: " + cc);
             		if(cc.contentEquals("("))
             			break;
             		
             		l += len.pop(); // 1
             		System.out.println("num: " + l);
                }

				
				int n = Integer.parseInt(stack.pop()); // ( 앞 숫자
				len.pop();
				stack.push("0");
				
				System.out.println("l: " + l);
				System.out.println("n: " + n);
				len.push(l * n);
				
			}
			else if(c.equals("(")){
				stack.push(c);
//				len.push(1);
			}
			else {
				stack.push(c);
				len.push(1);
			}
			
			System.out.println("STACK: " + stack);
			System.out.println("len: " + len);
			System.out.println();
		}
		
		int answer = 0;
		while(!len.isEmpty()) {
			answer += len.pop();
		
		}
		System.out.println(answer);
			}

}
