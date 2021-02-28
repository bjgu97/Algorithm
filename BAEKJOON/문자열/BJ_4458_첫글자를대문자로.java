package 문자열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BJ_4458_첫글자를대문자로 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		for(int n = 0; n < N; n++) {
			String s = br.readLine();
			
			char[] cArr = s.toCharArray();
			if(Character.isLowerCase(cArr[0])) {
				cArr[0] = (char) (cArr[0] -32);
			}
			
			for(char c : cArr)
				System.out.print(c);
			System.out.println();
		}
	}
}
