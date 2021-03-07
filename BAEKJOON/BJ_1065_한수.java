import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ_1065_한수 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int answ = 0;
		for(int n = 1; n <= N; n++) {
			String s = Integer.toString(n);
			char[] arr = s.toCharArray();
			boolean check = true;
			for(int i = 1; i < s.length()-1; i++) {
				if(arr[i] - arr[i-1] != arr[i+1] - arr[i]) {
					check = false;
				}
			}
			
			if(check)
				answ++;
		}
		System.out.println(answ);
	}
}
