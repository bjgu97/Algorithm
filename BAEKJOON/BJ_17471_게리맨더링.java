import java.util.Scanner;

// 17471 게리맨더링

public class BJ_17471_게리맨더링 {
	static int N, d, answer = Integer.MAX_VALUE;
	static int[] people;
	static int[][] arr;
	static int[] temp, areaA, areaB;
	static boolean[] visited, mask;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		arr = new int[N+1][];
		people = new int[N+1];

		for(int i=1; i<=N; i++) people[i] = sc.nextInt();
		
		for(int i=1; i<=N; i++) {
			int area = sc.nextInt();
			arr[i] = new int[area];
			for(int j=0; j<area; j++) {
				arr[i][j] = sc.nextInt();
			}
		}
		
		
		
		for(int i=1; i<N; i++) {
			temp = new int[N+1];
			mask = new boolean[N+1];
			temp[0] = 1;
			d = i;
			recur(1, 0);
		}
		
		if(answer == Integer.MAX_VALUE) System.out.println("-1");
		else System.out.println(answer);
		
	}
	
	public static void recur(int start, int depth) {
		if(depth == d) {
			
			areaA = new int[d];
			areaB = new int[N-d];
			
			boolean[] check = new boolean[N+1];
			
			for(int i=1; i<=d; i++) {
				areaA[i-1] = temp[i];
				check[temp[i]] = true;
			}
			
			int idx = 0;
			for(int i=1; i<=N; i++) if(!check[i]) areaB[idx++] = i;
			
			visited = new boolean[N+1];
			DFS(areaA[0], areaA);
			for(int i=1; i<=d; i++) if(!visited[areaA[i-1]]) return;
		
			
			visited = new boolean[N+1];
			DFS(areaB[0], areaB);
			for(int i=1; i<=N-d; i++) if(!visited[areaB[i-1]]) return;
			
			
			int sumA = 0;
			int sumB = 0;
			for(int i=1; i<=d; i++) sumA += people[areaA[i-1]];
			for(int i=1; i<=N-d; i++) sumB += people[areaB[i-1]];
			
			answer = Math.min(Math.abs(sumA-sumB), answer);
			
			return;
		}
		for(int i=temp[start-1]; i<=N; i++) {
			if(mask[i]) continue;
			temp[start] = i;
			mask[i] = true;
			recur(start+1, depth+1);
			mask[i] = false;
		}
	}
	
	public static void DFS(int x, int[] area) {
		visited[x] = true;
		
		for(int i=0; i<arr[x].length; i++) {
			
			int nx = arr[x][i];
			
			if(!visited[nx]) {
				for(int j=0; j<area.length; j++) {
					if(area[j] == nx) DFS(nx, area );
				}
			}
		}
	}
}