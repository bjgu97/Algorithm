package Algorithm.sw.d3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
 
public class SW_1247_최적경로 {
     
    static Point start;
    static Point end;
    static Point[] clients;
    static int N;
    static int[][] answer;
    static boolean[] visited;
     
    static int len = 0;
    static int minLen;
     
    public static class Point {
        int x;
        int y;
 
        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

		@Override
		public String toString() {
			return "Point [x=" + x + ", y=" + y + "]";
		}
    }
    
    
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int TC = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
         
        for(int tc = 0; tc < TC; tc++) {
            minLen = Integer.MAX_VALUE;
            N = Integer.parseInt(br.readLine()); // 고객의 수
            StringTokenizer st = new StringTokenizer(br.readLine());
            
            start = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
            end = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
             
            // 고객 좌표 다 저장 후 순열로?
            clients = new Point[N];
            for(int n = 0; n < N; n++) {
                clients[n] = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
            }
             
            visited = new boolean[N];
            perm(0, 0, start.x, start.y);
             
            sb.append("#").append(tc+1).append(" ").append(minLen).append("\n");
        }
        System.out.println(sb);
    }
     
    static void perm(int cnt, int len) {
    	if(len > minLen)
    		return;
    	
        if(cnt == N) {
        	minLen = Math.min(minLen, len);
            return;
        }
         
        for(int i = 0; i < N; i++) {
            if(visited[i]) continue;
            
            answer[cnt][0] = arr[i][0];
            answer[cnt][1] = arr[i][1];
            visited[i] = true;
            perm(cnt + 1);
            visited[i] = false;
        }
    }

}