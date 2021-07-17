import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class BJ_11437_LCA {
	public static void main(String[] args) {
		
	}
//	public static void main(String[] args) throws IOException {
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		int N = Integer.parseInt(br.readLine());
//		int[] parentArr = new int[N+1];
//
//		for(int n = 0; n < N-1; n++) {
//			StringTokenizer st = new StringTokenizer(br.readLine());
//			int parent = Integer.parseInt(st.nextToken());
//			int child = Integer.parseInt(st.nextToken());
//			
//			if(parentArr[child] == 0)
//				parentArr[child] = parent;
//			else
//				parentArr[parent] = child;
//			
//			System.out.println(Arrays.toString(parentArr));
//		}
//		
//		
//		int M = Integer.parseInt(br.readLine());
//		for(int m = 0; m < M; m++) {
//			StringTokenizer st = new StringTokenizer(br.readLine());
//			int node1 = Integer.parseInt(st.nextToken());
//			int node2 = Integer.parseInt(st.nextToken());
//			
//			System.out.println(func(node1, node2, parentArr));
//		}
//
//	}
//	
//	static int func(int node1, int node2, int[] parentArr) {
//		List<Integer> list1 = new ArrayList<>();
//		List<Integer> list2 = new ArrayList<>(); 
//		
//		int n1 = node1;
//		int n2 = node2;
//		
//		list1.add(n1);
//		while(parentArr[n1] != 0) {
//			n1 = parentArr[n1];
//			list1.add(n1);
//		}
//		
//	
//		list2.add(n2);
//		while(parentArr[n2] != 0) {
//			n2 = parentArr[n2];
//			list2.add(n2);
//		}
//
//		for(int i= 0; i < list1.size(); i++) { // 최악의 경우 6억 -> 시간초과
//			for(int j = 0; j < list2.size(); j++) {
//				if(list1.get(i).intValue() == list2.get(j).intValue()) {
//					return list1.get(i);
//				}
//			}
//		}
//		return 0;
//	}
}
