package Algorithm.sw.d3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SW_1940_가랏RC카 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		

		for(int t = 0; t < T; t++) {
			int dist = 0;
			int speed = 0;
			
			int N = Integer.parseInt(br.readLine());
			for(int n = 0; n < N; n++) {
				st = new StringTokenizer(br.readLine());
				// 0:유지, 1:가속, 2:감속
				int command = Integer.parseInt(st.nextToken()); 
				if(command == 0) { //속도 유지
					dist = dist + speed;
				}
				else {
					// 가속값
					int acc = Integer.parseInt(st.nextToken());
					if(command == 1) {
						speed = speed + acc;
						dist = dist + speed;
					}
					else if(command == 2) {
						if(acc > speed) 
							speed = 0;
						else
							speed = speed - acc;
						dist = dist + speed;
					}
				}
			}
			sb.append("#").append(t+1).append(" ").append(dist).append("\n");
		}
		System.out.println(sb);
	}
}
