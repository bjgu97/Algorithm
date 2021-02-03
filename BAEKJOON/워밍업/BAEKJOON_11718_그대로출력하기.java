package 워밍업;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class BAEKJOON_11718_그대로출력하기 {
public static void main(String[] args) throws IOException {
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	StringBuilder sb = new StringBuilder();
	
	while(true) {
		String a = br.readLine();
		if(a == null || a.length() == 0)
			break;
		sb.append(a).append("\n");
	}
	
	System.out.println(sb);
	
}
}
