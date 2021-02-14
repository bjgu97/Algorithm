package 완전탐색;

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

		
		// 판 생성
		char[][] arr = new char[N][M];
		
		for(int i = 0; i < N; i++) {
			String s = br.readLine();
			for(int j = 0; j < M; j++) {
				arr[i][j]= s.charAt(j);
			}
		}
		
		int cnt1 = 0;
		int minCnt1 = 64;
		
		for(int i = 0; i < N-8+1; i++) {
			for(int j = 0; j < M-8+1; j++) {
				cnt1 = 0;
				for(int x = i; x < i+8; x++) {
					for(int y = j; y < j+8; y++) {
						// W부터 시작하는 경우
						if((x+y)%2==0 && arr[x][y] != 'W') { // 짝수합 = W, 홀수합 = B
//							System.out.println("(x, y): " + x + ", " + y);
							cnt1++;
						}
						else if((x+y)%2 != 0 && arr[x][y] != 'B') {
//							System.out.println("(x, y): " + x + ", " + y);
							cnt1++;
						}
					}
				}
				minCnt1 = Math.min(cnt1, minCnt1);
			}
		}
		
//		System.out.println("min1: " + minCnt1);
		
		
		int cnt2 = 0;
		int minCnt2 = 64;
		for(int i = 0; i < N-8+1; i++) {
			for(int j = 0; j < M-8+1; j++) {
				cnt2 = 0;
				// B부터 시작하는 경우
				for(int x = i; x < i+8; x++) {
					for(int y = j; y < j+8; y++) {
						if((x+y)%2==0 && arr[x][y] != 'B') { // 짝수합 = B, 홀수합 = W
//							System.out.println("(x, y): " + x + ", " + y);
							cnt2++;
						}
						else if((x+y)%2 != 0 && arr[x][y] != 'W') {
//							System.out.println("(x, y): " + x + ", " + y);
							cnt2++;
						}
					}
				}
				minCnt2 = Math.min(cnt2, minCnt2);
			}
		}
		
//		System.out.println("min2: " + minCnt2);
		
		System.out.println(Math.min(minCnt1, minCnt2));
	}
}
