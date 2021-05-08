import java.io.*;
import java.util.*;

public class BJ_12904_A와B_찬영언니 {

	static String S, T;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		S = br.readLine();
		T = br.readLine();
		
		List<Character> charListT = new ArrayList<Character>();
		for (int i=0;i<T.length();i++) {
			charListT.add(T.charAt(i));
		}
		
		int index = charListT.size()-1;
		while (charListT.size()>S.length()) {
			System.out.println("1. charListT: " + charListT);
			if (charListT.get(index)=='A') {
				charListT.remove(index);
			} else {
				charListT.remove(index);
				Collections.sort(charListT, Collections.reverseOrder());
				System.out.println("1-2. charListT: " + charListT);
			}
			index--;
		}
		
		System.out.println("2. charListT: " + charListT);
		for (int i=0;i<S.length();i++) {
			if (S.charAt(i)!=charListT.get(i)) {
				System.out.println("3. charListT: " + charListT);
				System.out.println(0);
				System.exit(0);
			}
		}
		System.out.println(1);
		//System.out.println(charListT);
	}

}