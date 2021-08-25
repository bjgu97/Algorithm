

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_1912_연속합 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] NArr= new int[N];
		for(int n = 0; n < N; n++) {
			NArr[n] = Integer.parseInt(st.nextToken());
		}
		
		
		int[] mem = new int[N];
		mem[0] = NArr[0];
		int answ = Integer.MIN_VALUE;
		
		for(int n = 1; n < N; n++) {
			mem[n] = mem[n-1] + NArr[n];
			mem[n] = Math.max(mem[n], NArr[n]);
			
			answ = Math.max(answ, mem[n-1]);
		}
		
		answ = Math.max(answ, mem[N-1]);
		System.out.println(answ);
		
		
	}
}
