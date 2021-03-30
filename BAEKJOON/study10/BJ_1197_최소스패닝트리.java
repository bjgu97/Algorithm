package study10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_1197_최소스패닝트리 {
	static class LinkNode {
		int from;
		int to;
		int cost;
		
		LinkNode(int from, int to, int cost) {
			this.from = from;
			this.to = to;
			this.cost = cost;
		}

		@Override
		public String toString() {
			return "LinkNode [from=" + from + ", to=" + to + ", cost=" + cost + "]";
		}

	}
	
	static LinkNode[] graph;
	static int[] parents;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int V = Integer.parseInt(st.nextToken()); //정점의 개수
		int E = Integer.parseInt(st.nextToken()); // 간선의 개수
		
		graph = new LinkNode[E];
		
		for(int e = 0; e < E; e++) {
			st = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken()); // 시작 간점
			int B = Integer.parseInt(st.nextToken()); // 끝 간점
			int C = Integer.parseInt(st.nextToken()); // 가중치
			
			graph[e] = new LinkNode(A-1, B-1, C);
		}
		
//		System.out.println(Arrays.toString(graph));
		
		// 1. 간선을 가중치 순으로 오름차순 정렬
		Arrays.sort(graph, (o1, o2) -> {
			return Integer.compare(o1.cost, o2.cost);
		});
		
//		System.out.println(Arrays.toString(graph));
		
		// 2. 간선을 훑으면서 양쪽 정점을 포함한 컴포넌트가 연결되어있지 않으면 간선을 뽑고 연결
		//    유니온파인드 알고리즘
		
		// 2-1. 유니온파인드 배열 초기화
		parents = new int[V+1];
		for(int i = 0; i < V; i++) {
			parents[i+1] = i+1;
		}
		
		int answ = 0;
		int cnt = 0;
		// 2-2. 연결 확인
		for(LinkNode node : graph) {
			// 싸이클 형성되지 않으면
			if(union(node.from, node.to)) {
				answ += node.cost;
				cnt++;
				// 정점-1개의 간선이 이어졌다면 종료
				if(cnt == V-1) {
//					System.out.println(answ);
					break;
				}
			}
		}
		
		System.out.println(answ);
	}
	
	static boolean union(int start, int end) {
		start = find(start);
		end = find(end);
		if(start == end)
			return false;
		
		parents[start] = end;
		return true;
	}
	
	static int find(int n) {
		if(n == parents[n])
			return n;
		return parents[n] = find(parents[n]);
	}
	
}
