

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_11328_Strfry {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		for(int n = 0; n < N; n++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			String s1 = st.nextToken();
			String s2 = st.nextToken();
			
			int[] arr1 = new int[26];
			int[] arr2 = new int[26];
			
			for(int i = 0; i < s1.length(); i++) {
				arr1[s1.charAt(i) - 97]++;
			}
			
			for(int i = 0; i < s2.length(); i++) {
				arr2[s2.charAt(i) - 97]++;
			}
			

			boolean check = true;
			for(int i = 0; i < arr1.length; i++) {
				if(arr1[i] != arr2[i]) {
					check = false;
				}
			}
			
			if(check)
				System.out.println("Possible");
			else
				System.out.println("Impossible");
		}
		
	}
}
