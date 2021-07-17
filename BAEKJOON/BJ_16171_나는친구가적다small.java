import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ_16171_나는친구가적다small {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		String want = br.readLine();
		String charS = "";
		for(int i = 0; i < s.length(); i++) {
			if(!Character.isDigit(s.charAt(i))) {
				charS += s.charAt(i);
			}
		}

		
		if(charS.contains(want)) {
			System.out.println(1);
		}
		else
			System.out.println(0);
//		for(int i = 0; i < charS.length() - want.length() + 1; i++) {
//			flag = false;
//			for(int j = i; j < want.length() + i; j++) {
//				System.out.print(charS.charAt(j) + " ");
//				if(charS.charAt(j) == want.charAt(j - i)) {
//					flag = true;
//					cnt++;
//				}
//				else
//					flag = false;
//			}
//			System.out.println();
//			if(flag && (cnt == want.length())) {
//				ans = true;
//				break;
//			}
//		}
//		
//		if(ans)
//			System.out.println(1);
//		else
//			System.out.println(0);
	}
}
