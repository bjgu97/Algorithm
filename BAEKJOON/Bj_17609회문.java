

import java.util.*;
import java.io.*;

//비교하다 달라졌을 때, 왼쪽에 한번 빼보고 오른쪽 한번 빼보고 비교 지속 -> 회문이면 1  아니면 2

public class Bj_17609회문 {

   public static void main(String[] args) throws Exception{
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      StringTokenizer st;
      StringBuilder sb = new StringBuilder();
      int n=Integer.parseInt(br.readLine());
      
      for(int i=0;i<n;i++) {
         String str=br.readLine();
         char[] ch=new char[str.length()];
         ch=str.toCharArray();
         sb.append(isP(ch)+"\n");
      }
      System.out.println(sb);
   }
   
   static int isP(char[] c) {
      int start=0;
      int end=c.length-1;
      int flag=0;
      while(start<=end) {
         if(c[start]==c[end]) {
            start++;
            end--;
            continue;
         }
         else if(flag==0){
            if(c[start+1]==c[end]) {
               flag=1;
               start+=2;
               end--;
            }
            else if(c[start]==c[end-1]) {
               flag=1;
               start++;
               end-=2;
            }
            else {
               flag=2;
               break;
            }
         }
         else if(flag==1) {
            return 2;
         }
      }
      
      if(flag==0) return 0;
      else if(flag==2) return 2;
      else return 1;
   }

}