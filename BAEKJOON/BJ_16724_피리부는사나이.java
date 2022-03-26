import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class BJ_16724_피리부는사나이 {
	static int N;
	static int M;
	static char[][] map;
	static boolean[][] visited;
	static int[][] tmp;
	
	static int startR;
	static int startC;
	static int idx;
	
	static int answer;
	static Set<Integer> set;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new char[N][M];
		visited = new boolean[N][M];
		tmp = new int[N][M];
		set = new HashSet<Integer>();
		
		for(int n = 0; n < N; n++) {
			Arrays.fill(tmp[n], -1);
		}
		
		for(int n = 0; n < N; n++) {
			String s = br.readLine();
			for(int m = 0; m < M; m++) {
				map[n][m] = s.charAt(m);
			}
		}
//		for(char[] a : map)
//			System.out.println(Arrays.toString(a));
		
		idx = 1;
		for(int n = 0; n < N; n++) {
			for(int m = 0; m < M; m++) {
				if(tmp[n][m] == -1) { // 방문하지 않았으면
					dfs(n, m, idx); // dfs() 돈다.
					idx++;
				}
			}
		}
		
		for(int[] a : tmp)
			System.out.println(Arrays.toString(a));
		
		for(char[] a : map)
			System.out.println(Arrays.toString(a));
		
		System.out.println(set);
		System.out.println(set.size());
	}
	
	static int dfs(int r, int c, int idx) {
		System.out.println("r, c, idx: " + r + "," + c + "," + idx);
//		if(tmp[r][c] != -1)
//			return tmp[r][c];
		
		if(tmp[r][c] != -1)
			return tmp[r][c];
		
		tmp[r][c] = idx;
		

		int nr = r, nc = c;
		
		if(map[r][c] == 'D') {
			nr = r + 1;
			nc = c;
		}
		else if(map[r][c] == 'R') {
			nr = r;
			nc = c + 1;
		}
		else if(map[r][c] == 'L') {
			nr = r;
			nc = c-1;
		}
		else if(map[r][c] == 'U') {
			nr = r-1;
			nc = c;
		}

		tmp[r][c] = dfs(nr, nc, idx);
		set.add(tmp[r][c]);

		return tmp[r][c];
	}
}
