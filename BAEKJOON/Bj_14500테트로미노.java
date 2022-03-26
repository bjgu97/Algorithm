

import java.io.*;
import java.util.*;

public class Bj_14500테트로미노 {
   
   static int N,M;
   static int[][] map;
   static int[][] deltas= {{-1,0},{1,0},{0,1},{0,-1}};
   
   public static void main(String[] args)throws Exception {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      StringTokenizer st;
      StringBuilder sb=new StringBuilder();
      
      st=new StringTokenizer(br.readLine());
      N=Integer.parseInt(st.nextToken());
      M=Integer.parseInt(st.nextToken());
      
      map=new int[N][M];
      
      for(int i=0;i<N;i++) {
         st=new StringTokenizer(br.readLine());
         for(int j=0;j<M;j++) {
            map[i][j]=Integer.parseInt(st.nextToken());
         }
      }
      
      //입력확인
      /*
      for(int i=0;i<N;i++) {
         //st=new StringTokenizer(br.readLine());
         for(int j=0;j<M;j++) {
            //map[i][j]=Integer.parseInt(st.nextToken());
            sb.append(map[i][j]+" ");
         }
         sb.append("\n");
      }
      
      System.out.println(sb);
      */
      visited = new boolean[N][M];
      for(int i=0;i<N;i++) {
         for(int j=0;j<M;j++) {
            System.out.println("****"+i+" "+j);
            visited[i][j]=true;
            dfs(i,j,1,map[i][j]);
            visited[i][j] = false;
         }
      }
      
      System.out.println(max);
      
      
   }
      
   static boolean visited[][];
   static int max=0;
   
   //static void bfs(int)
   
   static void dfs(int r,int c,int cnt,int sum) {
      if(cnt==4) {
         if(max<sum){
            max=sum;
         }
         return;
      }
      int dx=0;
      int dy=0;
      
      for(int i=0;i<4;i++) {
         dx=r+deltas[i][0];
         dy=c+deltas[i][1];
         System.out.println("**"+i+" "+dx+" "+dy+" "+cnt);
         if(isIn(dx,dy)&&cnt<4&&!visited[dx][dy]) {
            cnt++;
            visited[dx][dy]=true;
            sum+=map[dx][dy];
            dfs(dx,dy,cnt,sum);
            visited[dx][dy] = false;
         }
      }
   }
   
   static boolean isIn(int x,int y) {
      return 0<=x&&x<N&&0<=y&&y<M;
   }
}