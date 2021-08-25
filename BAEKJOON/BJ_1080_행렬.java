

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;


public class BJ_1080_행렬 {
	static int N;
	static int M;
	
	public static void main(String[] args) throws IOException {
		// A를 B로 바꾸는 데 필요한 연산의 횟수의 최솟값
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		int[][] A = new int[N][M];
		int[][] B = new int[N][M];
		
		// 입력 받기
		for(int n = 0; n < N; n++) {
			String s = br.readLine();
			for(int m = 0; m < M; m++) {
				A[n][m] = s.charAt(m) - '0';
			}
		}
		
		for(int n = 0; n < N; n++) {
			String s = br.readLine();
			for(int m = 0; m < M; m++) {
				B[n][m] = s.charAt(m) - '0';
			}
		}
		
		int cnt = 0;
		boolean check = false;
		
		// 행/열이 3보다 작으면 그냥 비교.
		if(N < 3 || M < 3) {
			// A와 B 가 동일하다면 0 출력
			if(check(A, B))
				System.out.println(0);
			// A와 B 동일하지 않다면 둘이 같아질 수 없으므로 -1 출력
			else
				System.out.println(-1);
		}
		
		// 행/열 크기가 3보다 크다면
		else {
			outer: for(int n = 0; n <= N-3; n++) {
				for(int m = 0; m <= M-3; m++) {
					// A와 B 다른 부분 존재 한다면
					if(A[n][m] != B[n][m]){ 
						// 횟수 하나 증가 시키고
						cnt++;
						
						// 3*3 영역 flip.
						for(int i = n; i < n+3; i++) { 
							for(int j = m; j < m+3; j++) {
								
								if(A[i][j] == 1)
									A[i][j] = 0;
								else
									A[i][j] = 1;
							}
						}
					}
					// A와 B 같은지 다시 확인.
					if(check(A, B)) { 
						// 같으면 check를 true로 바꾸고 종료. 
						check = true; 
						break outer; 
					}
					
				}
			}
			if(!check)
				System.out.println(-1);
			else
				System.out.println(cnt);
		}
	}
	
	static boolean check(int[][] A, int[][] B) {
		boolean flag = true;
		for(int n = 0; n < N; n++) {
			for(int m = 0; m < M; m++) {
				if(A[n][m] != B[n][m])
					flag = false;
			}
		}
		
		return flag;
		
	}
	
}
