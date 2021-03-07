package 실버;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_1929_소수구하기 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int M = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		
		boolean[] check = new boolean[1000001];
		int cnt = 0;
		check[1] = true;
		for(int i= 2; i <= 1000000; i++) {
			for(int j = i * 2; j <= 1000000; j+=i) {
				check[j] = true;
				cnt++;
			}
		}
		
		for(int i = M; i <= N; i++) {
			if(check[i] == false) {
				System.out.println(i);
			}
		}
	}
}
