// 중복 순열

package 백트레킹;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_15649_N과M1 {
	static int M;
	static int N;
	static int[] answer;
	static StringBuilder sb;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		
		answer = new int[N];
		
		PermutationDup(0);
	}
	static void PermutationDup(int cnt) {
		if(cnt == N) {
			for(int i = 0;  i < N; i++) {
				sn
			}
		}
	}
}
