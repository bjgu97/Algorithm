package 실버;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BJ_1181_단어정렬 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		String[] NArr = new String[N];
		for(int n = 0; n < N; n++) {
			NArr[n] = br.readLine();
		}
		
		System.out.println(Arrays.toString(NA));
	}
}
