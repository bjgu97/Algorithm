package Algorithm.sw.d3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SW_1954_달팽이숫자2 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		//테스트케이스 수 입력받기
		int T = Integer.parseInt(br.readLine());
		
		//테케 수 만큼 반복
		for(int t = 1; t <= T; t++) {
			int N = Integer.parseInt(br.readLine()); // 3
			
			int[][] arr = new int[N][N];
			
			int start = 0; 
			int end = N; 
			int num = 1;
			
			while(start <= end) {
				// 오른쪽으로 이동
				for(int j = start; j < end; j++) {
					System.out.println("1: " + num);

					arr[start][j] = num++;

				}
				for(int i = start+1; i < end; i++) {
					System.out.println("2: " + num);

					arr[i][end-1] = num++;

				}
				for(int j = end-2; j >= start; j--) {
					System.out.println("3: " + num);

					arr[end-1][j] = num++;

				}
				for(int i = end-2; i > start; i--) {
					System.out.println("4: " + num);

					arr[i][start] = num++;

				}
				start++;
				end--;
			}
			sb.append("#").append(t).append("\n");
			
			for(int i= 0;i  < N; i++) {
				for(int j =0; j < N; j++) {
					sb.append(arr[i][j]).append(" ");
				}
				sb.append("\n");
			}

			
			
			
		}
		System.out.println(sb);
	}
}



