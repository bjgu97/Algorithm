package BOJ;

import java.io.*;
import java.util.*;

public class BOJ_21939_문제추천시스템Version1 {

   static int N, P, L, M, x;

   public static void main(String[] args) throws IOException {
      // TODO Auto-generated method stub
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

      N = Integer.parseInt(br.readLine());

      // 문제 어려운 순서
      PriorityQueue<Problem> pq1 = new PriorityQueue<>(new Comparator<Problem>() {
         @Override
         public int compare(Problem o1, Problem o2) {
            if (o1.lv == o2.lv) {
               return Integer.compare(o1.num, o2.num);
            } else {
               return Integer.compare(o1.lv, o2.lv);
            }
         }
      });

      // 문제 쉬운 순서
      PriorityQueue<Problem> pq2 = new PriorityQueue<>(new Comparator<Problem>() {
         @Override
         public int compare(Problem o1, Problem o2) {
            if (o1.lv == o2.lv) {
               return Integer.compare(o2.num, o1.num);
            } else {
               return Integer.compare(o2.lv, o1.lv);
            }
         }
      });

      for (int i = 0; i < N; i++) {
         StringTokenizer st = new StringTokenizer(br.readLine(), " ");
         P = Integer.parseInt(st.nextToken());
         L = Integer.parseInt(st.nextToken());
         pq1.add(new Problem(P, L, false));
         pq2.add(new Problem(P, L, false));
      }

//      Iterator it = pq1.iterator();
//      while (it.hasNext()) {
//         System.out.println(it.next().getClass().);
//      }
      
//      M = Integer.parseInt(br.readLine());
//      StringBuilder sb = new StringBuilder();
//      Set<Problem> set = new HashSet<>();
//      for (int i = 0; i < M; i++) {
//         StringTokenizer st = new StringTokenizer(br.readLine());
//         String command = st.nextToken();
//         if (command.equals("recommend")) {
//            x = Integer.parseInt(st.nextToken());
//            if (x == 1) {
//               while (!set.contains(pq1.peek())) {
//                  pq1.poll();
//               }
//               sb.append(pq1.peek().num);
//               set.add(pq1.poll());
//            } else if (x == -1) {
//               while (!set.contains(pq2.peek())) {
//                  pq2.poll();
//               }
//               sb.append(pq2.peek().num);
//               set.add(pq2.poll());
//            }
//         } else if (command.equals("add")) {
//            P = Integer.parseInt(st.nextToken());
//            L = Integer.parseInt(st.nextToken());
//            pq1.add(new Problem(P, L, false));
//            pq2.add(new Problem(P, L, false));
//         } else {
//            P = Integer.parseInt(st.nextToken());
////            Iterator it = pq1.iterator();
////            while (it.hasNext()) {
////               System.out.println(it.);
////            }
//         }
//      }
   }

   static class Problem {
      int num;
      int lv;
      boolean solved;

      Problem(int num, int lv, boolean solved) {
         this.num = num;
         this.lv = lv;
         this.solved = solved;
      }

      boolean equals(Problem o) {
         if (this.num == o.num && this.lv == o.lv) {
            return true;
         } else {
            return false;
         }
      }

      @Override
      public int hashCode() {
         int result = 1;
         result = 31 * result + num;
         result = 31 * result + lv;
         return result;
      }

      @Override
      public String toString() {
         return num + " " + lv + " " + solved;
      }
   }
}