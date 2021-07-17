

import java.io.*;
import java.util.*;

public class BOJ_3079_입국심사 {

   static long N, M, T[];

   public static void main(String[] args) throws IOException {
      // TODO Auto-generated method stub
//      System.out.println((int) Math.pow(10, 9));
//      System.out.println(Integer.MAX_VALUE);
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      StringTokenizer st = new StringTokenizer(br.readLine(), " ");
      N = Integer.parseInt(st.nextToken());
      M = Integer.parseInt(st.nextToken());

      T = new long[(int)N];
      for (int i = 0; i < N; i++) {
         T[i] = Integer.parseInt(br.readLine());
      }
      // 입력 끝

      Arrays.sort(T);
      
      long left = 0;
      long right = T[(int)N - 1] * M;
      
      long ans = Long.MAX_VALUE;
      
      while (left <= right) {
         long mid = (left + right) / 2;
         long tot = 0;
         for (int i = 0; i < N; i++) {
            tot += (long) (mid / T[i]);
            
         }
         
         if (tot >= M) {
            ans = Math.min(ans, mid);
            right = mid - 1;
         } else {
            left = mid + 1;
         }
      }
      System.out.println(ans);
   }

}