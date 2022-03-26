import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class BJ_17471_게리맨더링_1 {
	static int answer = Integer.MAX_VALUE;
	static int[] peopleCnt;
	
	// 조합용
	static int N;
	static int[] group1;
	static List<List<Integer>> list;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		peopleCnt = new int[N+1];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int n = 1; n <= N; n++) {
			peopleCnt[n] = Integer.parseInt(st.nextToken());
		}
		
		list = new ArrayList<>();
		for(int n = 0; n <= N; n++) {
			list.add(new ArrayList<>());
		}
		for(int n = 1; n <= N; n++) {
			st = new StringTokenizer(br.readLine());
			int C = Integer.parseInt(st.nextToken());
			for(int c = 0; c < C; c++) {
				int node = Integer.parseInt(st.nextToken());
				list.get(n).add(node);
			}
		}
//		System.out.println("LIST: " +list);
		for(int i = 1; i <= N/2; i++) {
			group1 = new int[i];
			comb(0, 1, i);
		}
		
		if(answer == Integer.MAX_VALUE)
			System.out.println(-1);
		else
			System.out.println(answer);
	}
	
	static void comb(int cnt, int start, int K) { // N개에서 K개
		if(cnt == K) {
//			System.out.println(Arrays.toString(group1));
			
			List<Integer> list = new ArrayList<>();
			for(int i : group1)
				list.add(i);
			
			int[] group2 = new int[N-K];
			int idx = 0;
			for(int i = 1; i <= N; i++) {
				if(!list.contains(i)) group2[idx++] = i;
			}
			
//			System.out.println(Arrays.toString(group2));

			if(checkLinked(group1)) {
//				System.out.println("----------group2 검사 시작 ---------------");
				if(checkLinked(group2)) {
//					System.out.println("group1: " + group1);
//					System.out.println("group2: " + group2);
					answer = Math.min(answer, diff(group1, group2));
				}
			}
			return;
		}
		for(int i = start; i <= N; i++) {
			group1[cnt] = i;
			comb(cnt+1, i+1, K);
		}
	}
	static boolean[] visited;
	
	static boolean checkLinked(int[] group) {
		boolean flag = true;
		
		visited = new boolean[N+1];
		Arrays.fill(visited, false);
		visited[group[0]] = true;
		dfs(group[0], group);
		
		for(int g : group) {
			if(visited[g] == false) {
				flag = false;
			}
		}
		
		return flag;
	}
	
	static void dfs(int node, int[] group) {
//		System.out.println("visited: " + Arrays.toString(visited));
		for(int n : list.get(node)) {
			if(!visited[n] && hasVal(group, n)) {
				visited[n] = true;
				dfs(n, group);
			}
		}
	}
	
	static boolean hasVal(int[] group, int n) {
		boolean flag = false;
		
		for(int g = 0; g < group.length; g++) {
			if(group[g] == n)
				flag = true;
		}
		
		return flag;
	}
	
	static int diff(int[] group1, int[] group2) {
		int sum1 = 0;
		int sum2 = 0;
		
		for(int g : group1) {
			sum1 += peopleCnt[g];
		}
		
		for(int g : group2) {
			sum2 += peopleCnt[g];
		}
		
		return Math.abs(sum1- sum2);
	}
	
}
