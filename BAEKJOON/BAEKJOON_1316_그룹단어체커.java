

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BAEKJOON_1316_그룹단어체커 {
	static char[][] charr;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		boolean[] arr = new boolean[26];
		
		for(int i = 0; i < N; i++) {
			String word = br.readLine();
			
			for(int j = 0; j < word.length(); j++) {
				char a = word.charAt(j);
				int aa = Integer.parseUnsignedInt(a);
				arr[aa] = 1;
				
			}
			
			
		}

	}
}
