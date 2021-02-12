package 스택;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
 
public class Al2504_RE{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        Stack<String> stack = new Stack<>();
        
        /* 문자열의 길이가 홀수일 경우 정답이 될 수 없다. */
        if(str.length() %2 != 0) {
            System.out.println(0);
            return;
        }
        
        for (int i = 0; i < str.length(); i++) {
            String temp = String.valueOf(str.charAt(i));
            
            if(temp.equals("(") || temp.equals("[")) {
                stack.push(temp);
            }
            else if(temp.equals(")")){
                if(stack.isEmpty()) {
                    System.out.println(0); return;
                }
                /* 괄호 사이에 동일 괄호 외 아무것도 존재하지 않을 경우 */
                if(stack.peek().equals("(")) {
                    stack.pop();
                    stack.push("2");
                }
                /* 괄호 사이에 다른 괄호값(숫자)가 존재 할 경우 */
                else {
                    int sum = 0;
                    while(!stack.isEmpty()) {
                        String temp2 = stack.pop();
                        if(temp2.equals(")") || temp2.equals("[") || temp2.equals("]")){
                            System.out.println(0); return;
                        }
                        /* 괄호가 나오면 지금까지 더했던 값들을 *2 하여 다시 push */
                        if(temp2.equals("(")) {
                            stack.push(String.valueOf(sum*2));
                            break;
                        }
                        sum += Integer.parseInt(temp2);
                    }
                }
            }
            else if(temp.equals("]")){
                if(stack.isEmpty()) {
                    System.out.println(0); return;
                }
                /* 괄호 사이에 동일 괄호 외 아무것도 존재하지 않을 경우 */
                if(stack.peek().equals("[")) {
                    stack.pop();
                    stack.push("3");
                }
                /* 괄호 사이에 다른 괄호값(숫자)가 존재 할 경우 */
                else {
                    int sum = 0;
                    while(!stack.isEmpty()) {
                        String temp2 = stack.pop();
                        if(temp2.equals(")") || temp2.equals("(") || temp2.equals("]")){
                            System.out.println(0); return;
                        }
                        /* 괄호가 나오면 지금까지 더했던 값들을 *3 하여 다시 push */
                        if(temp2.equals("[")) {
                            stack.push(String.valueOf(sum*3));
                            break;
                        }
                        sum += Integer.parseInt(temp2);
                    }
                }
            }
        }
        int ans = 0;
        while(!stack.isEmpty()) {
            String temp3 = stack.pop();
            if(temp3.equals("(") || temp3.equals("[") || temp3.equals(")") || temp3.equals("]")) {
                System.out.println(0);
                return;
            }
            ans += Integer.parseInt(temp3);
        }
        System.out.println(ans);
    }
}
