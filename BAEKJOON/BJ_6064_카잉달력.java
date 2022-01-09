import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

import javax.swing.plaf.synth.SynthSplitPaneUI;

public class BJ_6064_카잉달력 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		// M과 N보다 작거나 같은 두 자연수 x, y
		// 각 년도: <x:y>
		// 첫번째 해: <1,1> , 두번째해: <2,2>
		// x >= M 이면 x = 1
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int t = 0; t < T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int M = Integer.parseInt(st.nextToken());
			int N = Integer.parseInt(st.nextToken());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			
			long cnt = 1;
			boolean flag = false;
			for(int k = x-1; k < N*M; k += M) {
//				System.out.println("a, b, cnt: " + k + "," + b + "," + cnt);
				if(k %  N == y-1) {
					flag = true;
					System.out.println(k+1);
					break;
				}
				
			}
			
			if(!flag)
				System.out.println(-1);
		}
	}
	
	static long gcd(int a, int b) {
		while(b != 0) {
			int r = a % b;
			
			a = b;
			b= r;
		}
		return a;
	}
}
