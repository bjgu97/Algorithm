import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ_17609_회문_1 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for(int t = 0; t < T; t++) {
			String s = br.readLine();
			
			if(checkPalindrome(s, 0, s.length()-1)) {
				System.out.println(0);
			}
			else if(checkPseudoPalindrome(s)) {
				System.out.println(1);
			}
			else {
				System.out.println(2);
			}
		}
		
	}
	
	static boolean checkPalindrome(String s, int front, int back) {
		char[] arr = s.toCharArray();

		while(front <= back) {
			if(arr[front] != arr[back]) {
				return false;
			}
			front++;
			back--;
		}
		
		return true;
	}
	
	static boolean checkPseudoPalindrome(String s) {
		char[] arr = s.toCharArray();
		
		int front = 0;
		int back = s.length()-1;
		boolean flag = false;
		while(front <= back) {
			if(arr[front] != arr[back]) {
				if(checkPalindrome(s, front+1, back)) {
					return true;
				}
				else if(checkPalindrome(s,  front, back-1))
					return true;
				else
					return false;
			}
			
			front++;
			back--;
		}
		
		return true;
	}
}
