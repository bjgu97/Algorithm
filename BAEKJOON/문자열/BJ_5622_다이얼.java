package 문자열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ_5622_다이얼 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		
		char[] arr = s.toCharArray();
		
		int answ = 0;
		for(int i = 0; i < arr.length; i++) {
			char c = arr[i];
			if(c == 'A' || c == 'B' || c == 'C') {
				answ += 3;
			}
			else if(c == 'D' || c == 'E' || c == 'F')
				answ += 4;
			else if(c == 'G' || c == 'H' || c == 'I')
				answ += 5;
			else if(c == 'J' || c == 'K' || c == 'L')
				answ += 6;
			else if(c == 'M' || c == 'N' || c == 'O')
				answ += 7;
			else if(c == 'P' || c == 'Q' || c == 'R' || c == 'S')
				answ += 8;
			else if(c == 'T' || c == 'U' || c == 'V')
				answ += 9;
			else if(c == 'W' || c == 'X' || c == 'Y' || c == 'Z')
				answ += 10;
		}
		
		System.out.println(answ);
	}
}
