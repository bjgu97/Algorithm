package baekjoon.bronze;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Bj_3040백설공주와일곱난쟁이 {

    static int numbers[]=new int[8];
    static int sum=0;
    static int temp[]=new int[8];
    static int ans[]=new int[8];
    static int c=0;
    static StringBuilder sb = new StringBuilder();
    static int[] p=new int[10];

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for(int i=0;i<9;i++) {
            p[i]=Integer.parseInt(br.readLine());
        }
        //System.out.println(Arrays.toString(p));
        comb(0,0);

        System.out.println(Arrays.toString(ans));
        //System.out.println(sb);
    }



    static void comb(int cnt,int start) {
        if(cnt==7) {
            c++;
            sum=0;
            for(int i=0;i<7;i++) {
                sum+=numbers[i];
                temp[i]=numbers[i];
            }

            if(sum==100) {
                //System.out.println("합이 100일때만!");
                for(int i=0;i<7;i++) {
                    sb.append(temp[i]+"\n");
                }
                ans=temp;
                System.out.println(Arrays.toString(ans));
            }
            return;
        }

        //i=start!!!!!!!!!
        for(int i=start;i<9;i++) {
            numbers[cnt]=p[i];
            //System.out.print(p[i]);
            comb(cnt+1,i+1);
        }
    }

}