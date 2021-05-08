import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
 
public class SW_5643 {
 
    static int N, M;
    static int map[][];
    static int cnt1, cnt2;
 
    public static void main(String[] args) throws IOException {
 
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
 
        int T = Integer.parseInt(br.readLine());
        
        for (int tc = 1; tc <= T; tc++) {
 
            N = Integer.parseInt(br.readLine()); 
            M = Integer.parseInt(br.readLine()); 
            
            map = new int[N + 1][N + 1];
            
            int i, j;
            for (int m = 1; m <= M; m++) {
                st = new StringTokenizer(br.readLine());
                
                i = Integer.parseInt(st.nextToken());
                j = Integer.parseInt(st.nextToken());

                map[i][j] = 1;
            }
 
            int res = 0;
            
            for (int k = 1; k <= N; k++) {
            	
            	cnt1 = 0;
            	BFS1(k);
            	
            	cnt2 = 0;
                BFS2(k);

                if(cnt1 + cnt2 == N - 1) 
                	res++;
            }
            
            System.out.println("#" + tc + " " + res);
        }
 
    }


    private static void BFS1(int start) {
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[N + 1];
        queue.add(start);
        visited[start] = true;
        
        while(!queue.isEmpty()) {
            int q = queue.poll();
            for (int i = 1; i <= N; i++) {
                if (map[q][i] == 1 && !visited[i]) {
                	queue.add(i);
                    visited[i] = true;
                    cnt1++;
                }
            }
        }
 
    }
 

    private static void BFS2(int start) { 
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[N + 1];
        queue.add(start);
        visited[start] = true;
   
        while(!queue.isEmpty()) {
            int q = queue.poll();
            for (int i = 1; i <= N; i++) {
                if (map[i][q] == 1 && !visited[i]) {
                	queue.add(i);
                    visited[i] = true;
                    cnt2++;
                }
            }
        }
 
    }
}
