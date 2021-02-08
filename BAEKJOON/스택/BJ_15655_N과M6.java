package 스택;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_15655_N과M6 {
	static int M;
	static int N;
	static StringBuilder sb;
	static int[] MArr;
	static boolean[] visited;
	static int[] answer;
	//조합
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		sb = new StringBuilder();
		
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		
		//System.out.println(M);
		//System.out.println(N);
		MArr = new int[M+1];
		answer = new int[N];
		
		st = new StringTokenizer(br.readLine());
		for(int m = 1; m <= M; m++) {
			MArr[m] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(MArr);
		
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
			answer[cnt] = MArr[i];
			Combination(cnt+1, i+1);
		}
	}
}
