package study13;

import java.io.*;
import java.util.*;

public class 거의소수_우선언니 {

   public static void main(String[] args) throws IOException {
      // TODO Auto-generated method stub
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      StringTokenizer st = new StringTokenizer(br.readLine());
      long A = Long.parseLong(st.nextToken());
      long B = Long.parseLong(st.nextToken());
      
      long max = (long) Math.pow(10, 14);
      int maxSqrt = (int)Math.sqrt(max);
//      System.out.println(maxSqrt);
      boolean[] isPrime = new boolean[maxSqrt+1];
      Arrays.fill(isPrime, true);
      isPrime[1] = false;
      for (int i = 2; i <= maxSqrt; i++) {
         for (int j = i * 2; j <= maxSqrt; j += i) {
            isPrime[j] = false;
         }
      }
      
      int result = 0;
      
      for (long i=A;i<=B;i++) {
         //System.out.println("i: "+i);
         for (int j=2;j<=(int)Math.sqrt(i);j++) {
            //System.out.println("j: "+j);
            if (isPrime[j]) {
               if (f(j, i)) {
                  result++;
                  //System.out.println("j: "+j+ "i: "+i);
                  break;
               }
            }
         }
      }
      System.out.println(result);
   }

   static boolean f(long x, long y) {
      long mul = x;
      while (mul * x < y) {
         mul *= x;
      }
      if (mul == (int)y/x) return true;
   
      else return false;
   }

}