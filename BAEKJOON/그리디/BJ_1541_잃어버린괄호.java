package 그리디;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_1541_잃어버린괄호 {
   
   static int L,R,C;
   static int deltas[][]= {{0,0,1},{0,0,1},{0,1,0},{0,-1,0},{1,0,0},{-1,0,0}};
   static int map[][][];
   static boolean visited[][][];
   
   public static void main(String[] args) throws Exception {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      StringTokenizer st;
      while(true) {
         st = new StringTokenizer(br.readLine());
         L=Integer.parseInt(st.nextToken()); //층수
         R=Integer.parseInt(st.nextToken()); //행
         C=Integer.parseInt(st.nextToken()); //열
         
         map=new int[L+1][R+1][C+1];
         visited=new boolean[L+1][R+1][C+1];
         if(L==0&&R==0&&C==0)
            return;
         
         else {
            /*int sh=0;
            int sx=0;
            int sy=0;*/
            
            for(int l=1;l<=L;l++) {
               for(int i=1;i<=R;i++) {
                  String str=br.readLine();
                  System.out.println(str);
                  for(int j=1;j<=C;j++) {
                     if(str.charAt(j-1)=='.') {
                        map[l][i][j]=0;
                     }
                     else if(str.charAt(j-1)=='#') {
                        map[l][i][j]=-1;
                     }
                     else if(str.charAt(j-1)=='E') {//탈출구
                        map[l][i][j]=1;
                     }
                     else {
                        /*sh=l;
                        sx=i;
                        sy=j;*/
                        map[l][i][j]=-1;
                     }
                  }
               }   
               br.readLine();
            }
            
            /*for(int l=1;l<=L;l++) {
               for(int i=1;i<=R;i++) {
                  for(int j=1;j<=C;j++) {
                     System.out.print(map[l][i][j]);
                  }
                  System.out.println();
               }
               System.out.println();
            }*/
            br.readLine();
         }
      }
   }
   
   static void bfs(int r,int c) {
      Queue<Integer> q=new LinkedList<Integer>();
      
      
   }
   
   static boolean isIn(int h,int r,int c) {
      return 1<=h&&h<=L&&1<=r&&r<=R&&1<=c&&c<=C;
   }

}