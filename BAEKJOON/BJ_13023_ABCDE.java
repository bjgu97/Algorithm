import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;


public class BJ_13023_ABCDE {
	static ArrayList<ArrayList<Integer>> list;
	static boolean[] visited;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken()); // 사람의 수
		int M = Integer.parseInt(st.nextToken()); // 친구 관계의 수
		
		list = new ArrayList<>();
		
		for(int m = 0; m < N; m++) {
			list.add(new ArrayList<Integer>());
		}
		
		for(int m = 0; m < M; m++) {
			st = new StringTokenizer(br.readLine());
			int num1 = Integer.parseInt(st.nextToken());
			int num2 = Integer.parseInt(st.nextToken());
			list.get(num1).add(num2);
			list.get(num2).add(num1);
		}
		
//		System.out.println(list);
		// 깊이 4인 친구 존재?
		
		for(int n = 0; n < N; n++) {
			visited = new boolean[N];

			dfs(n, 0);
		}
		
		System.out.println(0);
	}
	
	static void dfs(int start, int depth) {
		if(depth == 4) {
			System.out.println(1);
			System.exit(0);
		}
		
		visited[start] = true;
		
		for(int i = 0; i < list.get(start).size(); i++) {
			int next = list.get(start).get(i);
			if(!visited[next])
				dfs(next, depth + 1);
		}
		
		visited[start] = false;
	}
}
