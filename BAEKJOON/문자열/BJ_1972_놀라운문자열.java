package 문자열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class BJ_1972_놀라운문자열 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while(true) {
			String s = br.readLine();
			if(s.charAt(0) == '*')
				break;
			
			List<String> list = new ArrayList<String>();
			
			boolean check = true;
			for(int n = 1; n < s.length()-1; n++) {
				for(int c = 0; c < s.length()-n; c++) {
					String ss = "" + s.charAt(c) + s.charAt(c + n);
					if(list.contains(ss)) {
						check = false;
					}
					list.add(ss);
				}
				list.clear();
			}
			
			if(check) 
				System.out.println(s + " is surprising.");
			else
				System.out.println(s + " is NOT surprising.");
			
		}
	}
}
