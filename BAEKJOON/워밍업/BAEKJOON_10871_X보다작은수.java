package 워밍업;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BAEKJOON_10871_X보다작은수 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int X = Integer.parseInt(st.nextToken());
		
		int XArr[] = new int[N];
		st = new StringTokenizer(br.readLine());

		for(int i = 0; i < N; i++) {
			int a = Integer.parseInt(st.nextToken());
			if(a < X)
				XArr[i] = a;
				
		}
		StringBuilder sb = new StringBuilder();
		
		for(int i = 0; i < XArr.length; i++) {
			if(XArr[i] != 0)
				sb.append(XArr[i]).append(" ");
		}
		
		System.out.println(sb);
	}

}
