package 실버;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_10157_자리배정 {
	static int[][] deltas = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int C = Integer.parseInt(st.nextToken());
		int R = Integer.parseInt(st.nextToken());
		
		int K = Integer.parseInt(br.readLine());
		
		int[][] arr = new int[R][C];
		
		// 시작 좌표
		int x = R-1;
		int y = 0;
		
		// 시작 방향
		int d = 0;
		
		// 시작 값
		int cnt = 1;
		
		boolean check = false;
		while(true) {
			//while문 종료 조건
			if(cnt == K) { // K번째
				check = true;
//				System.out.println(R-x + " " + y+1);
				break;
			}
			else if(cnt == R*C + 1) {
				check = false;
				break;
			}
			
			arr[x][y] = cnt;
			
			int nx = x + deltas[d][0];
			int ny = y + deltas[d][1];
			
			if(nx >= R || ny >= C || nx < 0 || ny < 0) { // 배열 모서리 만나면
				d++; // 방향 바꾸기
				if(d >= 4) {
					d = 0;
				}
				
				nx = x + deltas[d][0];
				ny = y + deltas[d][1];
			}
			
			if(arr[nx][ny] != 0) { // 이미 숫자 있는 곳 만나면
				d++; // 방향 바꾸기
				if(d >= 4) {
					d = 0;
				}
				
				nx = x + deltas[d][0];
				ny = y + deltas[d][1];
			}
			
			x = nx;
			y = ny;
			
			cnt++;
//			System.out.println("x, y: " + x + "," + y);
		}
		
//		for(int i = 0; i < R; i++) {
//			for(int j = 0; j < C; j++) {
//				System.out.print(arr[i][j] + " ");
//			}
//			System.out.println();
//		}
		
		if(check)
			System.out.println((y+1) + " " + (R-x));
		else
			System.out.println(0);
		
	}
}
