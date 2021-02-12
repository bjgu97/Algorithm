package 정렬;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ_11931_수정렬하기4 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] NArr = new int[2000005];
		StringBuilder sb = new StringBuilder();
		
		
		for(int n = 0; n < N; n++) {
			NArr[1000000 + Integer.parseInt(br.readLine())]++;
		}
		
		for(int i = 0; i <NArr.length; i++) {
			while(NArr[i] != 0) {
				sb.append(i-1000000).append("\n");
				NArr[i]--;
			}
		}
		System.out.println(sb);
	}
}
