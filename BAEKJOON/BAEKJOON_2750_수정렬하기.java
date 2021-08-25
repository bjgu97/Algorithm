

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BAEKJOON_2750_수정렬하기 {
public static void main(String[] args) throws NumberFormatException, IOException {
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));      
    
	StringTokenizer st = new StringTokenizer(br.readLine()); //지정한 구분자로 쪼개기
	StringBuilder sb = new StringBuilder();
	int N = Integer.parseInt(st.nextToken());
	int[] NArr = new int[N];
	
	for(int i = 0; i < N; i++) {
		st = new StringTokenizer(br.readLine());
		NArr[i] = Integer.parseInt(st.nextToken());
	}
	
	Arrays.sort(NArr);
	
	for(int i = 0; i < N; i++) {
		sb.append(NArr[i]);
		sb.append("\n");
	}
	
	System.out.println(sb);
}
}
