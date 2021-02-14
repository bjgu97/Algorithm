package 구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_14503_로봇청소기 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken()); // 세로 크기  N
		int M = Integer.parseInt(st.nextToken()); // 가로 크기 M
		
		st = new StringTokenizer(br.readLine());
		int r = Integer.parseInt(st.nextToken()); // x 좌표
		int c = Integer.parseInt(st.nextToken()); // y 좌표
		int d = Integer.parseInt(st.nextToken()); // 방향 d
		
		// 입력받기
		int[][] arr = new int[N][M];
		for(int n = 0; n < N; n++) {
			st = new StringTokenizer(br.readLine());
			for(int m = 0; m < M; m++) {
				arr[n][m] = Integer.parseInt(st.nextToken());
			}
		}
		
//		for(int[] a : arr)
//			System.out.println(Arrays.toString(a));
		
		int answ = 0;
		while(true) {
			// 현재 위치를 청소한다.
			answ++;
			 
			// 왼쪽방향에 청소하지 않은 공간 존재하면 한칸 전진 후 청소
		}
	}
}
