import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
 
public class BJ_1987_알파벳 {
    public static int R;
    public static int C;
    //public static char[][] arr;
    public static int[][] arr;
    
    public static int[][] deltas = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
 
    public static boolean[] visited;
    
    public static int step = 1;
    public static int answ = 1;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        //arr = new char[R][C];
        
        // arr = new char[R][];
        // for(int r =0; r < R; r++) {
        // map[r] = br.readLine().toCharArray();
        //}
        arr = new int[R][C];
        for(int i=0; i < R; i++) {
            String s = br.readLine();
            for(int j=0; j < C; j++) {
            	arr[i][j] = s.charAt(j) - 'A';
                //arr[i][j] = s.charAt(j);
            }
        }
        
        //visited = new boolean['Z'+1]; // 알파벳의 방문 여부를 확인할 배열 
        visited = new boolean[26];
        
        dfs(0, 0, 0);
        System.out.println(answ);
    }
    
    public static void dfs(int r, int c, int cnt) {
    	if(visited[arr[r][c]]) {
    		answ = Math.max(answ, cnt);
    		return;
    	}
    	
    	if(cnt == 26)
    		return;
    	
    	visited[arr[r][c]] = true;
    	
        for(int i=0; i < 4; i++) {
            int nr = r + deltas[i][0];
            int nc = c + deltas[i][1];
            
            if(nr < 0 || nc < 0 || nr >= R || nc >= C) 
            	continue;
            
//            char alpha = arr[nr][nc];
//            if(!visited[alpha]) {
//            	visited[alpha] = true;
//            	dfs(nr, nc, cnt+1);
//            visited[alpha] = false; // 안간척
//            }
            
            dfs(nr, nc, cnt+1);
        }

        visited[arr[r][c]] = false;
    }
}
 