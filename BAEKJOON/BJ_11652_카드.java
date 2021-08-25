

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BJ_11652_카드 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		int[] NArr = new int[N];
		for(int n = 0; n < N; n++) {
			int a = Integer.parseInt(br.readLine());
			NArr[n] = a;
		}
		
		
		for(int i = 0; i < N; i++) {
			countArr[NArr[i]]++;
		}
		int max = 0;
		for(int i= 0; i < countArr.length; i++) {
			max = (int) Math.max(max, countArr[i]);
		}
		
		System.out.println(max);
	}
}
