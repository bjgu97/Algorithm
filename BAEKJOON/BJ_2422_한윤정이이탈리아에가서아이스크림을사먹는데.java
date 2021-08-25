

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class BJ_2422_한윤정이이탈리아에가서아이스크림을사먹는데 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int[] NArr = new int[N];
		for(int n = 0; n < N; n++) {
			NArr[n] = n+1;
		}
		
		boolean[][] MArr = new boolean[201][201];
		for(int m = 0; m < M; m++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			MArr[a][b] = true;
			MArr[b][a] = true;
		}
		
		// 정보 저장 완료
		int answer = 0;
		for(int i = 1; i <= N; i++) {
			for(int j = i+1; j <= N; j++) {
				for(int k = j+1; k <= N; k++) {
					if(MArr[i][j] || MArr[i][k] || MArr[j][k]) {
						//System.out.println("i, j, k: " + i + "," + j + "," + k);
						continue;
					}
					answer++;
				}
			}
		}
		System.out.println(answer);
	}
}
