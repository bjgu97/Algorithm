import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BJ_18405_경쟁적전염 {
	static int[][] map;
	static PriorityQueue<Virus> pq;
	static int N;
	static int M;
	static int K;
	static class Virus implements Comparable<Virus>{
		int k;
		int r;
		int c;
		int cnt;
		
		Virus(int k, int r, int c, int cnt) {
			this.k = k;
			this.r = r;
			this.c = c;
			this.cnt = cnt;
		}

		@Override
		public int compareTo(Virus o) {
			if(this.cnt != o.cnt)
				return this.cnt - o.cnt;
			if(this.k != o.k)
				return this.k - o.k;
			return 0;
		}

		@Override
		public String toString() {
			return "Virus [k=" + k + ", r=" + r + ", c=" + c + ", cnt=" + cnt + "]";
		}


		
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		map = new int[N][N];
		pq = new PriorityQueue<>();

		for(int n = 0; n < N; n++) {
			st = new StringTokenizer(br.readLine());
			for(int m = 0; m < N; m++) {
				map[n][m] = Integer.parseInt(st.nextToken());
				if(map[n][m] != 0) {
					pq.add(new Virus(map[n][m], n, m, 0));
				}
			}
		}
		
		st = new StringTokenizer(br.readLine());
		int S = Integer.parseInt(st.nextToken()); // 초
		int X = Integer.parseInt(st.nextToken()); 
		int Y = Integer.parseInt(st.nextToken());
				
		for(int s= 0; s < S; s++) {
			spread(s+1);
			
//			for(int[] a : map)
//				System.out.println(Arrays.toString(a));
//			System.out.println();
		}
		
		System.out.println(map[X-1][Y-1]);
	}
	static int[][] deltas = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
	static void spread(int t) {
//		System.out.println(pq);
		int size = pq.size();
		for(int i = 0;i < size; i++) {
			Virus virus = pq.poll();
//			System.out.println(virus);
			for(int d = 0; d < deltas.length; d++) {
				int nr = virus.r + deltas[d][0];
				int nc = virus.c + deltas[d][1];
				
				if(nr < 0 || nc < 0 || nr >= N || nc >= N)
					continue;
				if(map[nr][nc] != 0)
					continue;
				if(virus.cnt >= t)
					continue;
								
				map[nr][nc] = virus.k;
				pq.add(new Virus(virus.k, nr, nc, virus.cnt + 1));
			}
		}
	}
}
