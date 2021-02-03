package 워밍업;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BAEKJOON_11024_더하기4 {
public static void main(String[] args) throws IOException {
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	StringTokenizer st = new StringTokenizer(br.readLine());
	StringBuilder sb = new StringBuilder();
	int T = Integer.parseInt(st.nextToken());
	
	for(int i = 0; i < T; i++) {
		st = new StringTokenizer(br.readLine(), " ");
		int sum = 0;
		int num = st.countTokens();
		for(int j = 0; j < num; j++) {
			sum += Integer.parseInt(st.nextToken());
		}
		sb.append(sum).append("\n");
	}
	System.out.println(sb);
	}
}

