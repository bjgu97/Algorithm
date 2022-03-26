import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class BJ_17829_222풀링 {
	static int N;
	static int[][] map;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		map = new int[N][N];
		
		for(int n = 0; n < N; n++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int m = 0; m < N; m++) {
				map[n][m] = Integer.parseInt(st.nextToken());
			}
		}
		
		while(true) {
			divide();
			N /= 2;
			conquere();
//			System.out.println("N: " + N);
			if(bigList.size() == 1) {
				System.out.println(bigList.get(0));
				break;
			}
		}
	}
	
	static void conquere() {
		map = new int[N][N];
		int idx = 0;
		for(int n = 0; n < N; n++) {
			for(int m =0; m < N; m++) {
				map[n][m] = bigList.get(idx++);
			}
		}
	}
	static List<Integer> bigList = new ArrayList<>();
	static void divide() {
		bigList.clear();
		List<Integer> list = new ArrayList<>();
		for(int r = 0; r < N; r+= 2) {
			for(int c = 0; c < N; c+= 2) {
				list.clear();
				for(int i = r; i < r+2; i++) {
					for(int j = c; j < c+2; j++) {
						list.add(map[i][j]);
					}
				}
				Collections.sort(list);
//				System.out.println(list);
				bigList.add(list.get(list.size()-2));
			}
		}		
	}
}
