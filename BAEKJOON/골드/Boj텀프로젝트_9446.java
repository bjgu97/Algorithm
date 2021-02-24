package 골드;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj텀프로젝트_9446 {
    static int[] arr;
    static int[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String[] in;

        int t = Integer.parseInt(br.readLine());
        while(t-- > 0){
            int n = Integer.parseInt(br.readLine());
            arr = new int[n+1];
            visited = new int[n+1];
            in = br.readLine().split(" ");
            for(int i = 1; i <= n; ++i)
                arr[i] = Integer.parseInt(in[i-1]);

            for(int i = 1; i <= n; ++i){
                if(visited[i] == 0)
                    rec(i, i);
            }
            int ans = 0;
            for(int i = 1; i <= n; ++i)
                if(visited[i] != 2)
                    ans++;
            sb.append(ans).append('\n');
        }
        System.out.print(sb);
    }

    static void rec(int src, int cur){
        if(visited[cur] == 2)
            return;

        int next = arr[cur];
        if(visited[src] == 0 && visited[next] > 0)
            return;
        visited[cur]++;
        rec(src, next);

    }
}