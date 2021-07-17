/*
 * 
 
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class BJ_3584_가장가까운공통조사 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for(int t = 0; t < T; t++) {
			int N = Integer.parseInt(br.readLine()); // 노드의 개수
			
			// 인접리스트
			int[] parent = new int[N+1];
			

			
			for(int n = 1; n < N; n++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				
				parent[b] = a;
			}
			
			System.out.println("parent: " + Arrays.toString(parent));
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int node1 = Integer.parseInt(st.nextToken());
			int node2 = Integer.parseInt(st.nextToken());
			
			int answ = func(node1, node2, parent);
			System.out.println(answ);
		}
	}
	
	static int func(int node1, int node2, int[] parent) {
		List<Integer> list1 = new ArrayList<>(); // node1의 조상들 저장
		List<Integer> list2 = new ArrayList<>(); // node2의 조상들 저장
		
		// node1의 조상들 list1에 저장
		int n1 = node1;
		list1.add(n1);
		while(true) {
			n1 = parent[n1];
			if(n1 == 0)
				break;
			list1.add(n1);
		}
		
		System.out.println(list1);
		
		// node2의 조상들 list2에 저장
		int n2 = node2;
		list2.add(n2);
		while(true) {
			n2 = parent[n2];
			if(n2 == 0)
				break;
			list2.add(n2);
		}

		System.out.println(list2);
		
		for(int i= 0; i < list1.size(); i++) {
			for(int j = 0; j < list2.size(); j++) {
				if(list1.get(i) == list2.get(j)) {
					return list1.get(i);
				}
			}
		}
		
		// 최소공통조상 없으면
		return -1;
	}
}

*/



import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class BJ_3584_가장가까운공통조사 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for(int t = 0; t < T; t++) {
			int N = Integer.parseInt(br.readLine()); // 노드의 개수
			
			// 인접리스트
			ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
			int[] parent = new int[N+1];
			
			for (int n = 0; n <= N; n++) {
				graph.add(new ArrayList<Integer>());
			}
			
			for(int n = 1; n < N; n++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				
				graph.get(a).add(b);
				parent[b] = a;
			}
			
			System.out.println("graph: "  + graph);
			System.out.println("parent: " + Arrays.toString(parent));
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int node1 = Integer.parseInt(st.nextToken());
			int node2 = Integer.parseInt(st.nextToken());
			
			int answ = func(node1, node2, graph, parent);
			System.out.println(answ);
		}
	}
	
	static int func(int node1, int node2, ArrayList<ArrayList<Integer>> graph, int[] parent) {
		List<Integer> list1 = new ArrayList<>(); // node1의 조상들 저장
		List<Integer> list2 = new ArrayList<>(); // node2의 조상들 저장
		
		// node1의 조상들 list1에 저장
		int n1 = node1;
		list1.add(n1);
		while(parent[n1] != 0) {
			n1 = parent[n1];
			list1.add(n1);
		}
		
		System.out.println(list1);
		
		// node2의 조상들 list2에 저장
		int n2 = node2;
		list2.add(n2);
		while(parent[n2] != 0) {
			n2 = parent[n2];
			list2.add(n2);
		}

		System.out.println(list2);
		
	
		
		for(int i= 0; i < list1.size(); i++) {
			for(int j = 0; j < list2.size(); j++) {
				if(list1.get(i).intValue() == list2.get(j).intValue()) {
					return list1.get(i);
				}
			}
		}
		
		

//		for(int i= 0; i < list1.size(); i++) {
//			int num = list1.get(i);
//			for(int j = 0; j < list2.size(); j++) {
//				if(num == list2.get(j)) {
//					return num;
//				}
//			}
//		}

		
		// 최소공통조상 없으면
		return -1;
	}
}
