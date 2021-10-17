

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SW_1954_달팽이숫자 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		//테스트케이스 수 입력받기
		int T = Integer.parseInt(br.readLine());
		
		//테케 수 만큼 반복
		for(int t = 1; t <= T; t++) {
			
			//크기 입력받기
			int N = Integer.parseInt(br.readLine());
			
			int num=1;
			int X1=0, Y1 = 0;
			int X2 = N, Y2 = N;

			int[][] arr = new int[N][N];
			
			while(num<=N*N) {
				for(int i = Y1; i<=Y2-1; i++) {
					arr[X1][i] = num;
					num++;
				}
				for(int j=++X1;j<=X2-1;j++) {
					arr[j][Y2-1]=num;
					num++;
				}
				for(int j=(--Y2)-1;j>=Y1;j--) {
					arr[X2-1][j]=num;
					num++;
				}
				for(int j=(--X2)-1;j>=X1;j--) {
					arr[j][Y1]=num;
					num++;
				}
				Y1++;
			}
//			System.out.println("#" + t);
			sb.append("#").append(t).append("\n");
			for(int a=0;a<N;a++) {
				for(int b=0;b<N;b++) {
					sb.append(arr[a][b]).append(" ");
//					System.out.print(arr[a][b]+" ");
				}
				sb.append("\n");
			}
		}
		
		System.out.println(sb);
	}
}



