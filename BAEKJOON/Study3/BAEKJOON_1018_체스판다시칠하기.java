package Study3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BAEKJOON_1018_체스판다시칠하기 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		System.out.println(N);
		System.out.println(M);
		
		// 판 생성
		char[][] arr = new char[N][M];
		
		System.out.println("start");
		for(int i = 0; i < N; i++) {
			String s = br.readLine();
			for(int j = 0; j < M; j++) {
				arr[i][j]= s.charAt(j);
			}
		}
		
		//탐색
		for(int i = 0; i <= N-8; i++) {
			for(int j = 0;j <= M-8; j++) {
				
			}
		}
		
	}
}
