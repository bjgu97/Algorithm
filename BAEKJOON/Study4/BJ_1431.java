package Study4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class BJ_1431 {
   static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
   static StringBuilder output = new StringBuilder();
   static StringTokenizer tokens;

   public static void main(String[] args) throws IOException {
      input = new BufferedReader(new StringReader(src));
      int T = Integer.parseInt(input.readLine());

      String[] s = new String[T];

      for (int i = 0; i < T; i++) {
         String s1 = input.readLine();
         s[i] = s1;
      }

      // 기본 소팅 방법 // 기존 것을 오버라이딩
      Arrays.sort(s, new Comparator<String>() {
         @Override
         public int compare(String o1, String o2) {

            // 첫 문장이 두번째 문장보다 짧을 때
            if (o1.length() < o2.length()) {
               return -1;
            
            //문장들의 길이가 같을 때 숫자들의 합을 구해서 비교해준다.
            } else if (o1.length() == o2.length()) {
               //숫자합도 같아 => 두 문장 비교해서 아스키로 비교
               if (countSum(o1) == countSum(o2)) {
                  return o1.compareTo(o2);
               } else {
                  return Integer.compare(countSum(o1), countSum(o2));
               }
            }

            else {
               return 1;
            }

         }
      });
      
      for (String i : s) {
         System.out.println(i);
      }

   }

   //값이 같을 경우 포한된 숫자들의 합을 구한다.구해서 비교한다.
   public static int countSum(String s) {
      int sum = 0;
      for (int i = 0; i < s.length(); i++) {
         if (s.charAt(i) >= '0' && s.charAt(i) <= '9') {
            sum += s.charAt(i) - '0';
         }
      }
      return sum;
   }

   static String src = "5\r\n" + "ABCD\r\n" + "145C\r\n" + "A\r\n" + "A910\r\n" + "Z321";
}