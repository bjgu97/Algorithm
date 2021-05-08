import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BJ_2239_스도쿠 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		char[][] map = new char[9][9];
		for(int i= 0; i < 9; i++) {
			String s = br.readLine();
			map[i] = s.toCharArray();
		}
		
//		for(char[] a : map)
//			System.out.println(Arrays.toString(a));
		int N = 0;
		for(int i = 0; i < 9; i++) {
			for(int j = 0; j < 0; j++) {
				if(map[i][j] == '0')
					N++;
			}
		}
		
		dfs(0, N);
	}
	
	static void dfs(int cnt, int N) {
		if(cnt == N)
			return;
	}
}
