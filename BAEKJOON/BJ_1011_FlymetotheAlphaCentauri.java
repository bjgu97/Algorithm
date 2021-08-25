

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_1011_FlymetotheAlphaCentauri {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for(int t = 0; t < T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			
			int d = M-N;
			
			int max = (int)Math.sqrt(d);

			if(max == Math.sqrt(d)) {
				System.out.println((max * 2 - 1));
			}
			else if(d <= max*max + max)
				System.out.println(max*2);
			else
				System.out.println(max * 2 + 1);
		}
	}
}
