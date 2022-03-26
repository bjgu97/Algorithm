import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BJ_11656_접미사배열 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String S = br.readLine();
		int len = S.length();
		String[] arr = new String[S.length()];
		
		for(int s = 0; s < len; s++) {
			arr[s] = S;
			S = S.substring(1);
		}
		
//		System.out.println(Arrays.toString(arr));
		
		Arrays.sort(arr);
		for(String s : arr)
			System.out.println(s);
	}
}