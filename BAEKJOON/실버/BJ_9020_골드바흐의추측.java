package 실버;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class BJ_9020_골드바흐의추측 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		
		boolean[] check = new boolean[10001];
		check[1] = true;
		for(int i= 2; i <= 10000; i++) {
			for(int j = i * 2; j <= 10000; j+=i) {
				check[j] = true;
			}
		}
		List<Integer> list1 = new ArrayList<Integer>();
		List<Integer> list2 = new ArrayList<Integer>();
		
		for(int t = 0; t < T; t++) {
			int n = Integer.parseInt(br.readLine());
			
			int a = 0;
			int b = 0;
			for(a = n/2, b = n/2;; a++, b--) {
				if(check[a] == false && check[b] == false) {
					sb.append(b).append(" ").append(a).append("\n");
					break;
				}
			}
		}
		
		System.out.println(sb);
	}
}
