import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class BJ_16171_나는친구가적다 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String S = br.readLine();
		String T = br.readLine();
		char[] SArr = S.toCharArray();
		
		List<Character> list = new ArrayList<>();
		
		for(int c = 0; c < SArr.length; c++) {
			if(Character.isDigit(SArr[c]))
				continue;
			
			list.add(SArr[c]);
			
			
		}

		int answer = 0;
		boolean flag = false;
		for(int i = 0; i <= list.size() - T.length(); i++) { // 0 1
			for(int j = i; j < T.length()+i; j++) {
				if(list.get(j) == T.charAt(j)) {
					flag = true;
				}
			}
			
			System.out.println("flag: " + flag);
			
			if(true) {
				flag = true;
				break;
			}
			
			flag = false;
		}
		
		if(flag)
			System.out.println(1);
		else
			System.out.println(0);
}
}
