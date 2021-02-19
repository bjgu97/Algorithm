package 구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ_10988_펠림드롬인지확인하기 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		
		char[] sArr = s.toCharArray();
		boolean check = true;
		for(int c = 0; c < sArr.length; c++) {
			if(sArr[c] != sArr[sArr.length-1-c])
				check = false;
		}
		
		if(check)
			System.out.println(1);
		else
			System.out.println(0);
	}
}
