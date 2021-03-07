package baekjoon.silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Bj_11724연결요소의개수 {

   static int N,M;
   static int[][] map;
   static boolean visited[][];
   
   
   public static void main(String[] args) throws Exception {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      StringTokenizer st = new StringTokenizer(br.readLine());
      
      N=Integer.parseInt(st.nextToken());
      M=Integer.parseInt(st.nextToken());
      
      map=new int[N+1][N+1];
      visited=new boolean[N+1][N+1];
      
      
      for(int i=0;i<M;i++) {
         st=new StringTokenizer(br.readLine());
         int x=Integer.parseInt(st.nextToken());
         int y=Integer.parseInt(st.nextToken());
         
         map[x][y]=map[y][x]=1;
      }
      
      for(int i=1;i<=N;i++) {
         for(int j=1;j<=N;j++) {
            if(map[i][j]==1&&!visited[i][j]) {
               visited[i][j]=true;
               visited[j][i]=true;
               dfs(j);
               max++;
            }
         }
      }
      
      System.out.println(max);
   }

   static boolean isIn(int r,int c) {
      return 1<=r&&r<=N&&1<=c&&c<=N;
   }
   
   static int max=0;
   
   static void dfs(int r) {
      
      
      for(int j=1;j<=N;j++) {
         if(map[r][j]==1&&!visited[r][j]) {
            visited[r][j]=true;
            visited[j][r]=true;
            dfs(j);
         }
      }
      
      
   }
   
}