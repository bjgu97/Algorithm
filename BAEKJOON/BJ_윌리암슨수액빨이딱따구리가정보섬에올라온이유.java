import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_윌리암슨수액빨이딱따구리가정보섬에올라온이유 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int n, m;
    static int map[][];
    static boolean visited[][];
    
    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new int[n][m];
        visited = new boolean[n][m];

        String s;
        int r = 0;
        int c = 0;
        for(int i = 0; i < n; i++) {
            s = br.readLine();
            for(int j = 0; j < m; j++) {
            	map[i][j] = s.charAt(j) -'0';
                if(map[i][j] == 2) {
                    r = i;
                    c = j;
                }
            }
        }

        int ans = bfs(r, c);
        
        if(ans == -1 ) {
			System.out.println("NIE");
		} else {
			System.out.println("TAK");
            System.out.println(ans);
		}

    }

    static int[][] deltas = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    public static int bfs(int r, int c) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[] {r, c, 0});

        while(!queue.isEmpty()) {
            int[] curr = queue.poll();

            for(int d = 0; d < 4; d++) {
                int nr = curr[0] + deltas[d][0];
                int nc = curr[1] + deltas[d][1];
                if(nr < 0 || nr >= n || nc < 0 || nc >= m || visited[nr][nc] || map[nr][nc] == 1) 
                	continue;
                if(map[nr][nc] == 3 || map[nr][nc] == 4 || map[nr][nc] == 5) 
                	return curr[2] + 1;
                
                visited[nr][nc] = true;
                queue.offer(new int[] {nr, nc, curr[2] + 1});
            }

        }
        return -1;
    }
}