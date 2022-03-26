import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ_2902_KMP는왜KMP일까 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		
		String[] arr = s.split("-");
		
		StringBuilder sb = new StringBuilder();
		
		for(String a : arr) {
			sb.append(a.charAt(0));
		}
		
		System.out.println(sb);
	}
}
