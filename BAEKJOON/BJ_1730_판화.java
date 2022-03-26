import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BJ_1730_판화 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		// 상하좌우 
		// 아래 목판 놓으면 그 위에 선 자동으로 이어주는.
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		char[][] map = new char[N][N];
		for(char[] a : map)
			Arrays.fill(a, '.');
		
		for(char[] a : map)
			System.out.println(Arrays.toString(a));
		
		String s = br.readLine();
		int L = s.length();
		
		int r = 0;
		int c = 0;
		for(int i = 0; i < L; i++) {
			char cc = s.charAt(i);
			
			if(cc == 'D') {
				map[r][c] = '|';
				r++;
			}
			else if(cc == 'R') {
				if(i > 0 && s.charAt(i-1) == cc) {
					map[r][c] = '-';
				}
				else
					map[r][c] = '+';
				c++;
			}
			else if(cc == 'L') {
				map[r][c] = '+';
				c--;
			}
			else if(cc == 'U') {
				map[r][c] = '|';
				r--;
			}
		}
		
		for(char[] a : map)
			System.out.println(Arrays.toString(a));
	}
}
