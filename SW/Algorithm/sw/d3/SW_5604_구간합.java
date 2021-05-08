package Algorithm.sw.d3;

import java.util.*;
import java.io.*;

public class SW_5604_구간합 {
   
   static long eachArr[];
   static long res;
   static long start,end;
   static long place;
   
   public static void main(String[] args) throws Exception {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      StringBuilder sb = new StringBuilder();
      StringTokenizer st;
      
      int T=Integer.parseInt(br.readLine());
      
      for(int t=1;t<=T;t++) {
         st=new StringTokenizer(br.readLine());
         start = Long.parseLong(st.nextToken());
         end = Long.parseLong(st.nextToken());
         
         eachArr = new long[10];
         res = 0;
         place = 1;
         
         if(start == 0) 
        	 start=1;
         
         while(start <= end) {
        	 
            while(start % 10 !=0 && start <= end) {
               func(start);
               start++;
            }
            
            if(start > end) break;
            
            while(end % 10 != 9 && start <= end) {
               func(end);
               end--;
            }
            
            long setDiff = (end/10) -(start/10) + 1;
            
            for(int i=0; i<=9; i++) {
               eachArr[i] += setDiff*place;
            }
            
            place *= 10;
            start /=10;
            end /=10;
         }
         
         for(int i=1;i<=9;i++) {
            res+=(i*eachArr[i]);
         }
         
         
         sb.append("#"+t+" "+res+"\n");
      }
      System.out.println(sb);
   }

   static void func(long l) {
      for(long i=l;i>0;i/=10) {
         String str=Long.toString(i);
         
         int t=str.charAt(str.length()-1)-'0';
         eachArr[t]+=place;
      }
   }
}