

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class BJ_2961_도영이가만든맛있는음식 {
	static int[][] NArr;
	static int N;
	static int[] answer;
	static int min = Integer.MAX_VALUE;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine()); // 재료의 개수 N

		NArr = new int[N][2];
		answer = new int[N];
		
		for(int n = 0; n < N; n++) {
			st = new StringTokenizer(br.readLine());
			NArr[n][0] = Integer.parseInt(st.nextToken());
			NArr[n][1] = Integer.parseInt(st.nextToken());
		}
		
		for(int n =1; n <= N; n++) {
			answer = new int[n];
			comb(0, 1, n);
		}
		
		System.out.println(min);
	}
	
	public static void comb(int cnt, int start, int n) {
		if(cnt == n) {
//			System.out.println(Arrays.toString(answer));
			int taste1 = 1;
			int taste2 = 0;
			
			for(int i = 0; i < answer.length; i++) {
				taste1 *= NArr[answer[i]-1][0];
				taste2 += NArr[answer[i]-1][1];
			}
			min = Math.min(min, Math.abs(taste1 - taste2));

			return;
		}
		
		for(int i = start; i <= N; i++) {
			answer[cnt] = i;
			comb(cnt+1, i+1, n);
		}
	}

}
