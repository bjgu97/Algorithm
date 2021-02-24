

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_2563_색종이 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		// 색종이 수
		int N = Integer.parseInt(br.readLine());
		int[][] NArrX = new int[N][2];
		int[][] NArrY = new int[N][2];
		
		for(int n = 0; n < N; n++) {
			st = new StringTokenizer(br.readLine());
			NArrX[n][0] = Integer.parseInt(st.nextToken());
			NArrX[n][1] = Integer.parseInt(st.nextToken());
		} 
		
		for(int n = 0; n < N; n++) {
			NArrY[n][0] = NArrX[n][0] + 10;
			NArrY[n][0] = NArrX[n][0] + 10;
		}
		
		// 전체 도화지 100*100
		boolean[][] totalArea = new boolean[100][100];
		
		for(int a = 0; a < N; a++) {
			for(int m = NArrX[a][0]; m < NArrX[a][0] + 10; m++) {
				for(int n = NArrX[a][1]; n < NArrX[a][1] + 10; n++) {
					totalArea[m][n] = true;
				}
			}
		}
		int answer = 0;
		
		for(int i = 0;i < 100; i++) {
			for(int j = 0; j < 100; j++) {
				if(totalArea[i][j] == true)
					answer++;
			}
		
		}
		
		System.out.println(answer);
	}
}
