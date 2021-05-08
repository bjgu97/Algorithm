import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BJ_2617_구슬찾기 {
	public static void main(String[] args) throws IOException {
		// 무게가 전체의 중간이 될 수 없는 구슬 찾기
		// 자기보다 가볍거나 무거운 구슬의 개수가 N(N-1)/2 보다 큰 구슬
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken()); // 구슬의 개수
		int M = Integer.parseInt(st.nextToken()); // 저울에 올려본 쌍의 개수
		
		// 인접리스트
		ArrayList<ArrayList<Integer>> map1 = new ArrayList<>();
		ArrayList<ArrayList<Integer>> map2 = new ArrayList<>();

		for(int i= 0; i < N+1; i++) {
			map1.add(new ArrayList<>()); 
			map2.add(new ArrayList<>());
		}
		
		for(int m = 0; m < M; m++) {
			st = new StringTokenizer(br.readLine());
			int num1 = Integer.parseInt(st.nextToken());
			int num2 = Integer.parseInt(st.nextToken());
			map1.get(num1).add(num2); // 무거운 구슬 - 가벼운 구슬
			map2.get(num2).add(num1); // 가벼운 구슬 - 무거운 구슬
		}

		
		// dfs
		int answer = 0;
		for(int n = 1; n <= N; n++) {
			boolean[] visited = new boolean[N+1];
			int numLighterMarble = dfs(n,  map1, visited);
			int numHeavierMarble = dfs(n, map2, visited);

			if(numLighterMarble >= (N+1)/2 || numHeavierMarble >= (N+1)/2) { 
				answer++; // 가벼운/무거운 구슬 개수가 (N+1)/2개 이상이면 중간값 될 수 없음
			}
		}
		
		System.out.println(answer);
	}
	
	static int dfs(int node, ArrayList<ArrayList<Integer>> map, boolean[] visited) {
		visited[node] = true; // 방문처리
		int cntTemp = 0;
		for(int i = 0; i < map.get(node).size(); i++) {
			int next = map.get(node).get(i);
			if(!visited[next]) {
				cntTemp++; // 무거운/가벼운 구슬 개수 추가
				cntTemp += dfs(next,  map, visited); // 자식 노드의 자식 노드 개수 추가. 
			}
		}
		return cntTemp;
	}
}
