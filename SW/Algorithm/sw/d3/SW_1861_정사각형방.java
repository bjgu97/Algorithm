package Algorithm.sw.d3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SW_1861_정사각형방 {
	
	static int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}}; //상하좌우
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for(int t = 0; t < T; t++) { //
			int N = Integer.parseInt(br.readLine()); // 1000
			int[][] NArr = new int[N][N];
			
			//배열 입력
			for(int n  = 0; n < N; n++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for(int m = 0; m < N; m++) {
					NArr[n][m] = Integer.parseInt(st.nextToken());
				}
			}
			
			int cnt = 0;
			int i = 0;
			int j = 0;

			while(i >= 0 && i < N && j >= 0 && j < N) {
				if(j+1 < N && i+1<N) {
					if(NArr[i][j] == NArr[i][j+1] - 1 || NArr[i][j] == NArr[i+1][j]-1) {
						cnt++;
						if(NArr[i][j] == NArr[i][j+1] - 1)
							j = j+1;
						else if(NArr[i][j] == NArr[i][j-1] - 1)
							j = j-1;
						else if(NArr[i][j] == NArr[i-1][j]-1)
							i = i-1;
						else if(NArr[i][j] == NArr[i+1][j]-1)
							i = i+1;
					}
				}
				if(j-1 >=0 && i-1>=0) {
					if(NArr[i][j] == NArr[i][j-1]-1 || NArr[i][j] == NArr[i-1][j]-1) {
						cnt++;
						if(NArr[i][j] == NArr[i][j+1] - 1)
							j = j+1;
						else if(NArr[i][j] == NArr[i][j-1]- 1)
							j = j-1;
						else if(NArr[i][j] == NArr[i-1][j]-1)
							i = i-1;
						else if(NArr[i][j] == NArr[i+1][j]-1)
							i = i+1;
					}
				}
				if(j+1 == N || i+1 == N) {
					if(NArr[i][j] == NArr[i][j-1]- 1)
						j = j-1;
					else if(NArr[i][j] == NArr[i-1][j]-1)
						i = i-1;
				}
			}
			System.out.println(cnt);
			}
			
		}
}
//	}

//}
