

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SW_1974_스도쿠검증 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		// 9*9 2차배열 만들기
		// 1. 행별로 계산. 모든 행이 합이 45 되는지.
		// 2. 열별로 계산. 모든 열 합이 45 되는지.
		// 3*3 영역별로 계산. 모든 영역 합이 45가 되는지.
		// 세 경우가 모두 true이면 1. 아니면 0
		
		
		
		int[][] arr = new int[9][9];
		
		for(int t = 0; t < T; t++) {
			for(int i = 0; i < 9; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j = 0; j < 9; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			
			int check = 0;
			int sum = 0;
			
			// 가로 줄 검사
			for(int i = 0; i < 9; i++) {
				sum = 0;
				for(int j= 0; j <9; j++) {
					sum += arr[i][j];
				}
				check += (sum == 45?1:0);
			}
			
			
			
			// 세로줄 검사
			for(int j = 0; j < 9; j++) {
				sum = 0;
				for(int i =  0; i < 9; i++) {
					sum += arr[i][j];
				}
				check += (sum == 45?1:0);
			}
			
			
			// 사각형 검사
			
			//0 ~ 2, 3~5, 6~8
			for(int c = 0; c <= 2; c++) {
				for(int w = 0; w <= 2; w++) {
				sum = 0;
				for(int k = 0 + 3*c; k <= 2 + 3*c; k++) {
					
					for(int j = 0 + 3*w; j <= 2 + 3*w; j++) {
						sum += arr[k][j];
					}
				}
				check += (sum == 45?1:0);
			}
			}
						
			sb.append("#").append(t+1).append(" ");
			if(check == 27)
				sb.append(1).append("\n");
			else
				sb.append(0).append("\n");
		}
		System.out.println(sb);
		
	}
}
