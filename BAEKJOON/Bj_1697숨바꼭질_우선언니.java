

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Bj_1697숨바꼭질_우선언니 {

    static int N,K;
    static boolean[] visited=new boolean[100001];
    static Queue<int []> q=new LinkedList<>();
    static int min=Integer.MAX_VALUE;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N=Integer.parseInt(st.nextToken());
        K=Integer.parseInt(st.nextToken());
        if(N!=K){
            visited[N]=true;
            q.offer(new int[]{N,0});
            bfs();
        }
        else{
            min=0;
        }
        System.out.println(min);

    }



    static void bfs() {

        while(!q.isEmpty()) {
            int x=q.peek()[0];
            int c=q.poll()[1];
            c++;
            
            int dx=x*2;
            if(dx==K) {
                if(min>c)
                    min=c;

            }
            else if(isIn(dx)&&visited[dx]==false){
                visited[dx]=true;
                q.offer(new int[]{dx,c});
            }
            dx=x-1;
            if(dx==K) {
                if(min>c)
                    min=c;

            }
            else if(isIn(dx)&&visited[dx]==false){
                visited[dx]=true;
                q.offer(new int[]{dx,c});
            }
            dx=x+1;
            if(dx==K) {
                if(min>c)
                    min=c;
            }
            else if(isIn(dx)&&visited[dx]==false){
                visited[dx]=true;
                q.offer(new int[]{dx,c});
            }
        }
    }

    static boolean isIn(int x) {
        return 0<=x&&x<K+1;
    }
}