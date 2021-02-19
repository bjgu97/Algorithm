package 완전탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_2961_도영이가만든맛있는음식2 {
	static int N;
	static int[][] answer;
	static int[][] NArr;
	static int min = Integer.MAX_VALUE;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;		
		
		N = Integer.parseInt(br.readLine());
		NArr = new int[N][2];
		
		// 신맛, 쓴맛 저장 완료
		for(int n = 0; n < N; n++) {
			st = new StringTokenizer(br.readLine());
			NArr[n][0] = Integer.parseInt(st.nextToken());
			NArr[n][1] = Integer.parseInt(st.nextToken());
		}
		
		//부분집합
		for(int n = 1; n <= N; n++) {
			answer = new int[n][2];
			comb(0, 0, n);
		}
		
		System.out.println(min);

	}
	public static void comb(int cnt, int start, int n) {
		if(cnt ==n) {
			int taste1 = 1;
			int taste2 = 0;
			for(int i = 0; i < n; i++) {
//				System.out.print(answer[i][0] + ", ");
//				System.out.println(answer[i][1]);
				taste1 *= answer[i][0];
				taste2 += answer[i][1];
			}
			min = Math.min(min, Math.abs(taste1-taste2));
			return;
		}
		
		for(int i = start; i < N; i++) {
			answer[cnt][0] = NArr[i][0];
			answer[cnt][1] = NArr[i][1];
			comb(cnt+1, i+1, n);
		}
		
	}
}
