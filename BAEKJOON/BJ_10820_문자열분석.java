

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import sun.security.x509.IssuingDistributionPointExtension;

public class BJ_10820_문자열분석 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		while(true) {
			String s = br.readLine();
			if(s == null)
				break;
			char[] cArr = s.toCharArray();
			
			int a = 0;
			int b = 0;
			int c = 0;
			int d = 0;
			
			for(int i = 0; i< cArr.length; i++) {
				char ch = cArr[i];
				// 소문자
				if(Character.isLowerCase(ch))
					a++;
				
				// 대문자
				if(Character.isUpperCase(ch))
					b++;
				
				// 숫자
				if(Character.isDigit(ch))
					c++;
				
				//공백
				if(ch == ' ')
					d++;
			}
			
			System.out.println(a + " " + b + " " + c + " " + d);
		}
	}
}
