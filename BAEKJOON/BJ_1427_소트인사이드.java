

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BJ_1427_소트인사이드 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		
		char[] cArr = s.toCharArray();
		
		Arrays.sort(cArr);
		
		for(int i = 0; i < cArr.length; i++) {
			System.out.print(cArr[cArr.length-1-i]);
		}
	}
}
