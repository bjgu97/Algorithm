package 스택;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class d {
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
		
		int M = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		MArr = new int[M];
		visited = new boolean[M];
		answer = new int[N];
		st = new StringTokenizer(br.readLine());
		for(int m = 0; m < M; m++) {
			MArr[m] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(MArr);
		
		Combination(0, 1);
	}
	
	public static void Combination(int cnt, int start) {
		if(cnt == N) {
			for(int i = 0; i < N; i++) {
				sb.append(MArr[i]).append(" ");
				System.out.println(sb);
			}
			sb.append("\n");
			return;
		}
		
		for(int i = start; i < M; i++) {
			if(visited[cnt]) continue;
			Combination(cnt+1, start+1);
		}
	}
}
