

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_10163_색종이 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine()); // 색종이 장수
		
		int[][] NArr = new int[N][4];
		
		for(int n = 0; n < N; n++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			NArr[n][0] = Integer.parseInt(st.nextToken()); //왼쪽 아래 x 좌표
			NArr[n][1] = Integer.parseInt(st.nextToken()); //왼쪽 아래 y 좌표
			NArr[n][2] = Integer.parseInt(st.nextToken()); // 너비
			NArr[n][3] = Integer.parseInt(st.nextToken()); // 높이
		}
		
		int[][] arr = new int[101][101];
		int num = 1;
		for(int n = 0; n < N; n++) {
			for(int i= NArr[n][0]; i < NArr[n][0] + NArr[n][2]; i++) {
				for(int j = NArr[n][1]; j < NArr[n][1] + NArr[n][3]; j++) {
					arr[i][j] = num;
				}
			}
			num++;
		}

		
		int answ = 0;
		num = 1;
		for(int n = 0; n < N; n++) {
			answ = 0;
			for(int i= 0; i < 101; i++) {
				for(int j = 0; j < 101; j++) {
					if(arr[i][j] == num) {
						answ++;
					}
				}
			}
			System.out.println(answ);
			num++;
		}
		
	}
}
