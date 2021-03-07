package 이진탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_2110_공유기설치 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		// 집의 개수
		int N = Integer.parseInt(st.nextToken());
		// 공유기의 개수
		int M = Integer.parseInt(st.nextToken());
		
		int[] NArr = new int[N];
		for(int n = 0; n < N; n++) {
			NArr[n] = Integer.parseInt(br.readLine());
		}
		// 1 2 4 8 9
	}
}
