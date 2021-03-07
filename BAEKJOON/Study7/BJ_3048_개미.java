package Study7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_3048_개미 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N1 = Integer.parseInt(st.nextToken()); // 첫번째 그룹의 개미 수
		int N2 = Integer.parseInt(st.nextToken()); // 두번째 그룹의 개미 수
		
		String s1 = br.readLine();
		String s2 = br.readLine();
		
		char[] temp = s1.toCharArray();
		char[] c1 = new char[s1.length()];
		for(int i= 0; i < c1.length; i++) {
			c1[i] = temp[temp.length-i-1];
		}
		char[] c2 = s2.toCharArray();
		
		System.out.println(Arrays.toString(c1));
		System.out.println(Arrays.toString(c2));
		
		
		int T = Integer.parseInt(br.readLine()); // 시간
		
		if(T == 0) {
			for(int i= 0; i < c1.length; i++) {
				System.out.print(c1[c1.length-i-1]);
			}
			for(int i= 0; i < c2.length; i++) {
				System.out.print(c2[i]);
			}
		}
	}
}
