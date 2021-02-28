package Study6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_2118_두개의탑 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		int[] NArr = new int[N];
		for(int n = 0; n < N; n++) {
			NArr[n] = Integer.parseInt(br.readLine());
			System.out.println(NArr[n]);
		}
		
		System.out.println(Arrays.toString(NArr));
		
		int start = NArr[0];
		int end = NArr[N-1];
		
		
	}
}
