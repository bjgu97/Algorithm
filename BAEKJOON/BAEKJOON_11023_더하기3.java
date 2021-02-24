

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class BAEKJOON_11023_더하기3 {
public static void main(String[] args) throws IOException {
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
	StringTokenizer st = new StringTokenizer(br.readLine(), " ");
	int sum = 0;
	int num = st.countTokens();
	for(int i = 0; i < num; i++) {
		sum += Integer.parseInt(st.nextToken());
	}
	
	System.out.println(sum);
	
}
}
