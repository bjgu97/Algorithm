import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_1260_DFS와BFS_2 {
	static ArrayList<Integer>[] graph;
	
	static boolean[] visited;
	
	static int N;
	static int M;
	static int V;
	
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken()); // 정점의 개수 (1번 ~ N번)
		M = Integer.parseInt(st.nextToken()); // 간선의 개수 
		V = Integer.parseInt(st.nextToken()); // 시작 정점의 번호
		
		// 인접 리스트로 입력 받기
		graph = new ArrayList[N+1];
		
		
	}
}