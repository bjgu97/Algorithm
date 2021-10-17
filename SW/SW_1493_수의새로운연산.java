

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SW_1493_수의새로운연산 {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		// 좌표 미리 저장
		int[][] arr = new int[100001][2]; // 최대한 크게 잡아주기,,
		
		int sum = 1;	
		int i = 0;
		int idx = 0;
		
		// 좌표 채우기
		// [1,1], [1,2] [2,1] , [1,3] [2,2] [3,1] , [1,4] [2,3] [3,2] [4,1] , ...
		outer:while(true) {
			for(int j = 1; j <= sum; j++) {
				idx = ++i; // arr[1]부터 채워넣어주기. 
				arr[idx][0] = j;
				arr[idx][1] = sum-j+1;
				if(idx >=100000)
					break outer;
			}
			sum++; // x 좌표 : 1 -> 1 2 -> 1 2 3 -> 1 2 3 4
		}

		
		for(int t = 0; t < T; t++) {
			st = new StringTokenizer(br.readLine());
			int p = Integer.parseInt(st.nextToken());
			int q = Integer.parseInt(st.nextToken());
			
			
			// 1. &(p) 
			int pX = arr[p][0];
			int pY = arr[p][1];

			
			// 2. &(q)
			int qX = arr[q][0];
			int qY = arr[q][1];

			
			// 3. &(p) + &(q)
			int pXqX = pX + qX;
			int pYqY = pY + qY;
			
			
			// 4. #( &(p) + &(q) )
			for(int j = 1; j <= 100000; j++) {
				if(arr[j][0] == pXqX && arr[j][1] == pYqY) 
					sb.append("#").append(t+1).append(" ").append(j).append("\n");
			}
			
		}
		
		System.out.println(sb);
	}

}
