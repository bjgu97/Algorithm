package 문자열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ_8595_히든넘버 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine()); // 단어의 길이
		String s = br.readLine();
		
		long sum = 0l;
		long num = 0l;
		long result = 0l;
		
		for(int n = 0; n < N; n++) {
			char c = s.charAt(n);
			if(Character.isDigit(c)) { // 숫자이면
				num = c - '0';
				result = 10 * result + num;
			}
			else { // 숫자가 아닌 문자이면
				sum += result;
				result = 0;
			}
		}
		
		if(result != 0)
			sum += result;
		System.out.println(sum);
	}
}
