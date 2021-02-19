package Algorithm.sw.d3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Solution_1493_수의새로운연산 {
	static int[][] xy;

	public static void main(String[] args) throws NumberFormatException, IOException {
		make();
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int TC = Integer.parseInt(br.readLine());
		
		for(int tc=1; tc<=TC; tc++) {
			st = new StringTokenizer(br.readLine());
			
			int p = Integer.parseInt(st.nextToken());
			int q = Integer.parseInt(st.nextToken());
			
			int x1 = xy[p][0];
			int y1 = xy[p][1];
			int x2 = xy[q][0];
			int y2 = xy[q][1];
			
			int x = x1+x2;
			int y = y1+y2;
			
			for(int n=1; n<=50000; n++) {
				if(xy[n][0]==x && xy[n][1]==y) {
					sb.append("#").append(tc).append(" ").append(n).append("\n");
					break;
				}
			}
		}
		
		System.out.println(sb);
	}

	static void make() {
		xy = new int[50001][2];

		int round = 1;
		int num = 1; // p,q에 사용되는 숫자.
		while (true) {
			for (int r = 1; r <= round; r++) {
				xy[num][0] = r; // x 좌표
				xy[num][1] = round-r+1;
				num++;
				
				if(num>50000)
					return;
			}
			round++;
		}
	}
}