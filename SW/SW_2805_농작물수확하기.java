

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SW_2805_농작물수확하기 {
public static void main(String[] args) throws NumberFormatException, IOException {
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	StringTokenizer st;
	StringBuilder sb = new StringBuilder();
	// Test case
	int T = Integer.parseInt(br.readLine());
	
	for(int t = 0; t < T; t++) {
		// 크기 N
		int N = Integer.parseInt(br.readLine());
		
		//가치 입력받기
		int[][] arr = new int[N][N];
		
		// 입력받기
		for(int i = 0; i < N; i++) {
			String line = br.readLine();
			for(int j = 0; j < N; j++) {
				arr[i][j] = line.charAt(j) - '0';
			}
		}
	
		int sum = 0;
		
		//위아래 삼각
		for(int i = 0; i < N/2; i++) { //0 1
			for(int j = N/2-i; j <= N/2+i; j++) {
				sum += arr[i][j];
				sum+= arr[N-1-i][j];
			}
		}
		
		//가운데줄		
		for(int j = 0; j < N; j++) {
			sum += arr[N/2][j];
		}

		sb.append("#").append(t+1).append(" ").append(sum).append("\n");
	}
	System.out.println(sb);

}
}
