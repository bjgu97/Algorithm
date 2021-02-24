

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
 
public class BJ_1475_방번호 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
 
        String s = br.readLine();
 
        int[] arr = new int[10];
        int digit = 0;
        for (int i = 0; i < s.length(); i++) {
            digit = s.charAt(i) - '0';
            arr[digit]++;
 
        }

        int k = (arr[6] + arr[9]);
        if (k % 2 == 0) {
            arr[6] = k / 2;
            arr[9] = k / 2;
        }
        else {
            arr[6] = k / 2;
            arr[9] = k / 2 + 1;
        }
 
        int max = 0;
        for (int i : arr) {
            max = Math.max(max, i);
        }
        
        System.out.println(max);
    }
 
}