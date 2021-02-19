

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 조합으로부분집합 {
    static int N;
    static int[] NArr;
    static int[] answer;

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine()); 
        NArr = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int n = 0; n < N; n++) {
            NArr[n] = Integer.parseInt(st.nextToken());
        }

        for(int n = 0; n <= N; n++) {
        	answer = new int[n];
            comb(0, 0, n);
        }

    }

    public static void comb(int cnt, int start, int n) {
        if(cnt == n) {
            System.out.println(Arrays.toString(answer));
            return;
        }

        for(int i= start; i < N; i++) {
            answer[cnt] = i;
            comb(cnt+1, i+1, n);
        }
    }

}