package 스택;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_15654_N과M5 {
	static int[] answer;
	static boolean[] visited;
	static int[] numbers; 
	
	static int N;
	static int M;
	
	static StringBuilder sb;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		sb = new StringBuilder();
		
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		numbers = new int[M];
		
		
		for(int m = 0; m < M; m++) {
			numbers[m] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(numbers);
		//System.out.println(Arrays.toString(numbers));
		//수열
		answer = new int[N];
		visited = new boolean[M];
		
		//System.out.println("N: " + N  + "M: " + M);
		permutation(0);
		
		System.out.println(sb);
	}
	
	public static void permutation(int cnt) {
		if(cnt == N) {
			for(int i = 0; i < N; i++) {
				sb.append(answer[i]).append(" ");
			}
			sb.append("\n");
			return;
		}
		
		for(int i = 0; i < M; i++) {
			if(visited[i]) continue;
			
			answer[cnt] = numbers[i];
			visited[i] = true;
			
			permutation(cnt+1);
			
			visited[i] = false;
			
		}
	}
}
