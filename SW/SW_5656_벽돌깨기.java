

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
 
public class SW_5656_벽돌깨기 {
    static int T;
    static int N,W,H;
    static int min;
    static Queue<Point> queue = new LinkedList<>();
    
    static class Point {
        int r;
        int c;
        
        Point(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }
     
    public static void main(String[] args) throws IOException  {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        T = Integer.parseInt(br.readLine());
        int t = 1;
        
        for(int tc = 0; tc < T; tc++) {
            
            StringTokenizer st = new StringTokenizer(br.readLine());
            
            N = Integer.parseInt(st.nextToken());
            W = Integer.parseInt(st.nextToken());
            H = Integer.parseInt(st.nextToken());
            
            int[][] map = new int[H][W];
            min = Integer.MAX_VALUE;
            
            for (int i = 0; i < H; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < W; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            
            solve(map,0);
            int answer = 0;
            if(min == Integer.MAX_VALUE)
            	answer = 0;
            else
            	answer = min;
            sb.append("#").append(tc+1).append(" ").append(answer).append("\n");
        }
        System.out.println(sb);
    }
    
    static void solve(int[][] map, int cnt ) {
        
        if(cnt == N) {
            int sum = 0;
            for (int i = 0; i < H; i++) {
                for (int j = 0; j < W; j++) {
                    if(map[i][j] != 0) 
                    	sum++;
                }
            }
            min = Math.min(min,sum);
            return;
        }
        
        for (int i = 0; i < W; i++) {
            int j = 0;
            
            while(j < H) {
                if(map[j][i] != 0) 
                	break;
                j++;
            }
            
            if(j == H) 
            	continue;
            int[][] temp = new int[H][W];
            for(int ii = 0; ii < H; ii++) {
            	for(int jj = 0; jj < W; jj++) {
            		temp[ii][jj] = map[ii][jj];
            	}
            }
            int[][] map2 = temp;
            
            queue.add(new Point(j, i));
            bfs(map2);
            solve(map2,cnt+1);
        }
        
    }
    
    static void bfs(int[][] map) {
        while(!queue.isEmpty()) {
        	Point p = queue.poll();
        	
        	int nr = p.r;
        	int nc = p.c;
            int range = map[nr][nc]-1;
            
            map[nr][nc] = 0;
            
            for (int i = nr-range < 0 ? 0 : nr-range ; i <= (nr+range >= H ? H-1 :nr+range); i++) {
                if(map[i][nc] == 0) 
                	continue;
                
                if(map[i][nc] == 1) {
                    map[i][nc] = 0;
                }
                else {
                    queue.add(new Point(i, nc));
                }
            }
            
            for (int i = nc-range < 0 ? 0 : nc-range ; i <= (nc+range >= W ? W-1 : nc+range); i++) {
                if(map[nr][i] == 0) 
                	continue;
                
                if(map[nr][i] == 1) {
                    map[nr][i] = 0;
                }
                else {
                    queue.add(new Point(nr, i));
                }
            }
        }
        
        for (int i = H-2; i >= 0; i--) {
            for (int j = 0; j < W; j++) {
                if(map[i][j] == 0) 
                	continue;
                
                int range = map[i][j];
                int temp = i;
                
                map[i][j] = 0;
                
                while(true) {
                    if(temp+1 >= H || map[temp+1][j] != 0) 
                    	break;
                    temp++;
                }
                map[temp][j] = range;
            } 
        }
        
    }

}
 

