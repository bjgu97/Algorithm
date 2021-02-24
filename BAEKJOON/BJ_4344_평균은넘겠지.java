

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;


public class BJ_4344_평균은넘겠지 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int C= Integer.parseInt(br.readLine()); // 테케 수
		
		for(int c = 0; c < C; c++) {
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int[] nArr = new int[N];
			int sum = 0;
			
			for(int n = 0; n < N; n++) {
				nArr[n] = Integer.parseInt(st.nextToken());
				sum += nArr[n];
			}
			double avg = sum / N;
			double cnt = 0;
			
			for(int n = 0; n < N; n++) {
				if(nArr[n] > avg)
					cnt++;
			}
			
			System.out.printf("%.3f%%\n", cnt / N * 100);
			//System.out.print(cnt/N);
			//System.out.println();
		}
		
	}

}
