package 실버;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_10158_개미 {

    static int w,h; //w 가로 h세로

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        w=Integer.parseInt(st.nextToken());
        h=Integer.parseInt(st.nextToken());
        st=new StringTokenizer(br.readLine()); 
        int x=Integer.parseInt(st.nextToken());
        int y=Integer.parseInt(st.nextToken()); 
        int T=Integer.parseInt(br.readLine());

        x+=T;
        y+=T;

        if((x/w)%2==0) {
            x=x%w;
        }
        else {
            x=w-(x%w);
        }
        if((y/h)%2==0) {
            y=y%h;
        }
        else {
            y=h-(y%h);
        }


        System.out.println(x+" "+y);
    }

}