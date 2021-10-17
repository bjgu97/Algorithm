import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;


public class BJ_1342_행운의문자열 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		
		boolean[] selected = new boolean[s.length()];
		char[] stringArr = new char[s.length()];
		char[] arr = s.toCharArray();
		
		perm(0, arr, selected, stringArr);
		
		char[] alphabet = new char[26];
		for(int i = 0; i < s.length() ;i++) {
			alphabet[arr[i] - 'a']++;
		}
		
		for(int i = 0; i < 26; i++) {
			if(alphabet[i] > 1)
				answer = answer / factorial(alphabet[i]);
		}
		System.out.println(answer);
	}
	
	static int answer;
	static void perm(int cnt, char[] arr, boolean[] selected, char[] stringArr) {
		if(cnt == arr.length) {
			check(stringArr);
			return;
		}
		
		for(int i = 0; i < arr.length; i++) {
			if(selected[i])
				continue;
			
			stringArr[cnt] = arr[i];
			
			selected[i] = true;
			perm(cnt+1, arr, selected, stringArr);
			selected[i] = false;
		}
	}
		
	static void check(char[] stringArr) {
		boolean flag = true;
		for(int i = 1; i < stringArr.length-1; i++) {
			if(stringArr[i-1] == stringArr[i] || stringArr[i] == stringArr[i+1])
				flag = false;
		}
		
		if(flag) {
			answer++;
		}
			
	}
	
	static int factorial(int n) {
		if(n == 1)
			return 1;
		return n * factorial(n-1);
	}
}
