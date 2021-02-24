

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class BAEKJOON_11719_그대로출력하기2 {
	public static void main(String[] args) throws IOException {
//		Scanner scan = new Scanner(System.in);
//		
//		while(scan.hasNextLine()) {
//			String a = scan.nextLine();
//			System.out.println(a);
//	}
//		
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		while(true) {
			String a = br.readLine();
			
			if(a == null)
				break;
			//sb.append(a).append("\n");
			System.out.print(a + "\n");
		}
		//System.out.println(sb);
	}
}
