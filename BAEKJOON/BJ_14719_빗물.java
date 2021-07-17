import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_14719_빗물 {
	static int H;
	static int W;
	static int[] map;
	
	static int rain;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		H = Integer.parseInt(st.nextToken());
		W = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		map = new int[W];
		for(int i = 0; i < W; i++) {
			map[i] = Integer.parseInt(st.nextToken()); // 배열에 각 블록 높이 저장.
		}
		
		for(int w = 1; w < W-1; w++) { // 3 1 2  3 4 1 1 2
			int left = 0;
			int right = 0;
			
			for(int k = w; k >= 0; k--) { 
				left = Math.max(map[k], left); // 3   4
			}
			
			for(int k = w; k < W; k++) {
				right = Math.max(map[k], right); // 4    2
			
//			System.out.println(left + "," + right);
			int height = Math.min(left, right); // 3   2
			
			rain += (height - map[w]); // 2 + 1 + 0 / 1 + 1
		}
		
		
		System.out.println(rain);

	}
	}
}
