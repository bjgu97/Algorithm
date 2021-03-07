package 이진탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_10816_숫자카드2 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int M = Integer.parseInt(br.readLine());
		int[] MArr = new int[20000001]; // 카운트정렬
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int m = 0; m < M; m++) {
			MArr[Integer.parseInt(st.nextToken())+10000000]++;
		}
		
		int N = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		for(int n = 0; n < N; n++) {
			int num = Integer.parseInt(st.nextToken());
			
			sb.append(MArr[num+10000000] + " ");
		}
		
		System.out.println(sb);
	}
}
