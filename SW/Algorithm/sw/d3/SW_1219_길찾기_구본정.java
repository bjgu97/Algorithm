package Algorithm.sw.d3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class SW_1219_길찾기 {
	static ArrayList<ArrayList<Integer>> graph ;
	static boolean check;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		for(int tc = 0; tc < 10; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int T = Integer.parseInt(st.nextToken()); // 테케 번호
			int L = Integer.parseInt(st.nextToken()); // 길의 총 개수
			
			graph = new ArrayList<>();
			
			for(int i = 0; i < 100; i++) {
				graph.add(new ArrayList<>());
			}
			
			st = new StringTokenizer(br.readLine());
			for(int l = 0; l < L; l++) {
				int start = Integer.parseInt(st.nextToken());
				int end = Integer.parseInt(st.nextToken());
				
				graph.get(start).add(end);
			}
			
//			System.out.println(graph);
			check = false;
			dfs(0);
			sb.append("#").append(T).append(" ");
			if(check) 
				sb.append(1).append("\n");
			else
				sb.append(0).append("\n");
		}
		
		System.out.println(sb);
	}
	
	static void dfs(int n) {
		if(n == 99) {// 99 도착 하면
			check = true;
			return;
		}
		
		for(int i = 0; i < graph.get(n).size(); i++) {			
			dfs(graph.get(n).get(i));
		}
	}
}

// 구본정 dfs + 인접리스트