

import java.io.*;
import java.util.*;

public class Bj_21938영상처리 {
   
   static int n,m;
   static int flag;
   static int[][] pixel;
   static int[][] display;
   static int[][] deltas= {{-1,0},{1,0},{0,-1},{0,1}};
   static boolean[][] visited;
   static boolean check;
   
   public static void main(String[] args)throws Exception {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      StringTokenizer st;
      StringBuilder sb = new StringBuilder();
      
      st=new StringTokenizer(br.readLine());
      n=Integer.parseInt(st.nextToken());
      m=Integer.parseInt(st.nextToken());
      pixel=new int[n][m*3];
      display=new int[n][m];
      // global로 크기까지 선언하면 안먹음 ..
      visited=new boolean[n][m];
      
      for(int i=0;i<n;i++) {
         st=new StringTokenizer(br.readLine());
         for(int j=0;j<m*3;j++) {
            pixel[i][j]=Integer.parseInt(st.nextToken());
         }
      }
      flag=Integer.parseInt(br.readLine());
      /*
      for(int i=0;i<n;i++) {
         //st=new StringTokenizer(br.readLine());
         for(int j=0;j<m*3;j++) {
            sb.append(pixel[i][j]);
         }
         sb.append("\n");
      }
      System.out.println(sb);
      */
      for(int i=0;i<n;i++) {
         for(int j=0;j<m*3;j+=3) {
            int sum=0;
            for(int k=j;k<j+3;k++) {
               sum+=pixel[i][k];
            }
            if(sum/3>=flag) {
               display[i][j/3]=255;
            }
            else {
               display[i][j/3]=0;
            }
         }
      }
      /*
      for(int i=0;i<n;i++) {
         for(int j=0;j<m;j++) {
            sb.append(display[i][j]+" ");
         }
         sb.append("\n");
      }
      System.out.println(sb);
      */
      int ans=0;
      for(int i=0;i<n;i++) {
         for(int j=0;j<m;j++) {
            if(display[i][j]==255&&!visited[i][j]) {
               visited[i][j]=true;
               System.out.println(i+" "+j);
               dfs(i,j, 0);
               ans++;
            }
         }
      }
      
      System.out.println(ans);
   }
   
   static void dfs(int sx,int sy,int cnt) {
	      System.out.println("DFS!!");
	      for(int i=0;i<4;i++) {
	         int tx=deltas[i][0]+sx;
	         int ty=deltas[i][1]+sy;
	         
	         if(isIn(tx,ty)&&!visited[tx][ty]&&display[tx][ty]==255) {
	            visited[tx][ty]=true;
	            System.out.println("cnt: " + cnt);
	            dfs(tx,ty,cnt+1);
//	            visited[tx][ty]=false;
	            //System.out.println(tx+" "+ty);
	         }
//	         else return;
	         
	      }
	      
	   }
//   static void dfs(int sx,int sy) {
//      
//      for(int i=0;i<4;i++) {
//         int tx=deltas[i][0]+sx;
//         int ty=deltas[i][1]+sy;
//         if(isIn(tx,ty)&&!visited[tx][ty]&&display[tx][ty]==255) {
//            visited[tx][ty]=true;
//            dfs(tx,ty);
//            //visited[tx][ty]=false;
//            //System.out.println(tx+" "+ty);
//         }
//         else break;
//         
//      }
//      
//   }
   
   static boolean isIn(int x,int y) {
      return 0<=x&&x<n&&0<=y&&y<m;
   }
}