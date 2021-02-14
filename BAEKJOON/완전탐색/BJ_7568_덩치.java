package 완전탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_7568_덩치 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine()); // 사람 수 N
		int[][] NArr = new int[N][2];
		
		for(int n = 0; n < N; n++) {
			st = new StringTokenizer(br.readLine());
			NArr[n][0] = Integer.parseInt(st.nextToken());
			NArr[n][1] = Integer.parseInt(st.nextToken());
		}
		
		int cnt = 0;
		for(int n = 0; n < N; n++) {
			cnt = 0;
			for(int m = 0; m < N; m++) {
				if(NArr[n][0] < NArr[m][0] && NArr[n][1] < NArr[m][1]) {
					cnt++;
				}
			}
			sb.append(cnt+1).append(" ");
		}
		System.out.println(sb);
	}
}
