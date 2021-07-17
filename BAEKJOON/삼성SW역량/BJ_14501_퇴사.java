package 삼성SW역량;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_14501_퇴사 {
	static int N;
	static int[] T;
	static int[] P;
	static int answer;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		T = new int[N];
		P = new int[N];
		
		for(int n = 0; n < N; n++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			T[n] = Integer.parseInt(st.nextToken());
			P[n] = Integer.parseInt(st.nextToken());
		}
		
		dfs(0, 0);
		
		System.out.println(answer);
	}
	
	static void dfs(int idx, int sum) {
		System.out.println("idx: " + idx);
		// 도착 하면
		if(idx == N) {
			System.out.println(answer);
			answer = Math.max(answer, sum);
			return;
		}
		
		// 도착 범위 넘어가면
		if(idx > N) {
			return;
		}
		
		dfs(idx + 1, sum); // 현재 idx 선택 안하고 다른날로 넘어가기
		dfs(idx + T[idx], sum + P[idx]); // 현재 idx 선택
		
		
	}
}
