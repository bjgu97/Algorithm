// 조합

package 백트레킹;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_15650_N과M2 {
	static int M;
	static int N;
	static StringBuilder sb;
	
	static int[] answer;
	static boolean[] visited;
		
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		sb = new StringBuilder();
		
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		
		visited = new boolean[M];
		answer = new int[N+1];
		
		Combination(0, 1);
		
		System.out.println(sb);
		
	}
	
	public static void Combination(int cnt, int start) {
		if(cnt == N) {
			for(int i = 0; i < N; i++) {
				sb.append(answer[i]).append(" ");
			}
			sb.append("\n");
			return;
		}
		
		for(int i = start; i <= M; i++) {
			answer[cnt] = i;
			Combination(cnt+1, i+1);
			
		}
	}
}
