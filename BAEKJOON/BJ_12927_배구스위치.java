import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BJ_12927_배구스위치 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String S = br.readLine();
		boolean[] arr = new boolean[S.length()+1];
		
		int L = S.length();
		
		for(int s = 1; s <= L; s++) {
			if(S.charAt(s-1) == 'Y')
				arr[s] = false;
			else
				arr[s] = true;
		}
		int answer = 0;
		for(int s = 1; s <= L; s++) {
			if(!arr[s]) { // L 이면
				for(int i = s; i <= L; i+=s) {
					if(arr[i]) arr[i] = false;
					else arr[i] = true;
				}
				answer++;
			}
		}
		System.out.println(answer);
	}
}
