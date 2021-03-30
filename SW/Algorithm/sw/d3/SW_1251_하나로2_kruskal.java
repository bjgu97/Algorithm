 package Algorithm.sw.d3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

// union-find 자료구조를 이용해서 간선 리스트에서 최소 간선 사용

public class SW_1251_하나로2_kruskal {

   static ArrayList<int []> list;
   static int repres[];
   static int N;
   
   static Edge[] edgeList;

   public static void main(String[] args) throws Exception {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      StringBuilder sb = new StringBuilder();
      int T=Integer.parseInt(br.readLine());
      


   }
   
   static long kuskal() {
	   make();
	   
	   int cnt = 0;
	   while(cnt < N-1) {
		   Edge edge = edges.poll();
	   }
   }
   static void make() {
	   repres = new int[N];
	   Arrays.fill(repres,  -1); // 음수를 가지고 있으면 내가 대표자 -> 음수로 처리 이유: 자식들의 개수 알아보기 위해서.
   }
   
   static int find(int a) {
	   if(repres[a] < 0) {
		   return a;
	   }
	   else {
		   return repres[a] = find(repres[a]);
	   }
   }
   
   static boolean union(int a, int b) {
	   a = find(a);
	   b = find(b);
	   if(a == b)
		   return false;
	   else {
		   repres[a] += repres[b];
		   repres[b] = a;
		   return true;
	   }
   }
   static class Edge implements Comparable<Edge> {
	   int e1, e2;
	   long len;
	   
	   public Edge(int e1, int e2, long len) {
		   super();
		   this.e1 = e1;
		   this.e2 = e2;
		   this.len = len;
	   }
	   
	   @Override
	   public int compareTo(Edge o) {
		   return Long.compare(this.len, o.len);
	   }

   }

}