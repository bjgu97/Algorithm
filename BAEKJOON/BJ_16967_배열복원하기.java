import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_16967_배열복원하기 {
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int H = Integer.parseInt(st.nextToken());
		int W = Integer.parseInt(st.nextToken());
		int X = Integer.parseInt(st.nextToken());
		int Y = Integer.parseInt(st.nextToken());
		
		int[][] B = new int[H+X][W+Y];
		int[][] A = new int[H][W];
		
		for(int i = 0; i < (H+X); i++) {
			st = new StringTokenizer(br.readLine());
			for(int s= 0; s < (W+Y); s++) {
				B[i][s] = Integer.parseInt(st.nextToken());
			}
		}
		
		// 안겹치는부분 1
		for(int i = 0; i < X; i++) { 
			for(int j = 0; j < W; j++) { 
				A[i][j] = B[i][j];
			}
		}

		// 안겹치는부분 2
		for(int i = X; i < H; i++) {
			for(int j = 0; j < Y; j++) {
				A[i][j] = B[i][j];
			}
		}

		// 겹치는부분
		for(int i = X; i < H; i++) {
			for(int j = Y; j < W; j++) {
				A[i][j] = B[i][j] - A[i-X][j-Y];
			}
		}
		
		// 출력
		for(int h = 0; h < H; h++) {
			for(int w = 0; w < W; w++) {
				System.out.print(A[h][w] + " ");
			}
			System.out.println();
		}
		
	}
}
