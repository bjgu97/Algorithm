

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ_10989_수정렬하기3 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] NArr = new int[10001];
		StringBuilder sb = new StringBuilder();
		
		
		for(int n = 0; n < N; n++) {
			NArr[Integer.parseInt(br.readLine())]++;
		}
		
		for(int i = 0; i < NArr.length; i++) {
			while(NArr[i] != 0) {
				sb.append(i).append("\n");
				NArr[i]--;
			}
		}
		System.out.println(sb);
	}
}
