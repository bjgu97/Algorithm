import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_3568_iSarp {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String s = br.readLine();
		
		// 문자열 파싱
		String[] arr = s.split(" ");
		String init = arr[0];
		
		String[] letters = new String[arr.length-1];
		StringBuilder sb = new StringBuilder();
		
		for(int i = 1; i < arr.length; i++) {
			sb.append(init);
			String letter = arr[i];
			letter = letter.replace(",", "");
			letter = letter.replace(";", "");
			
			char[] alpha = letter.toCharArray();
			
			int start = 0;
			for(int j = alpha.length-1; j >= 1; j--) {
				if(Character.isLetter(alpha[j])) {
					start = j;
					 break;
				}
				if(alpha[j] == ']')
					sb.append('[');
				else if(alpha[j] == '[')
					sb.append(']');
				else
					sb.append(alpha[j]);
			}
			sb.append(" ");
			for(int ss = 0; ss <= start; ss++) {
				sb.append(alpha[ss]);
			}
			sb.append(';').append("\n");
		}
		System.out.println(sb);
	
	}
}
