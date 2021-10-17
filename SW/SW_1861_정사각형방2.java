

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;
import java.io.IOException;

class Pos{
    int x;
    int y;

    Pos(int x, int y){
        this.x = x;
        this.y = y;
    }
}

public class SW_1861_정사각형방2 {    
    static int[][] arr;
    static int n;
    static boolean[] visited;
    static int max;
    static int start;
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int testNum = Integer.parseInt(br.readLine());

        for(int test=1; test<=testNum; test++){
            n = Integer.parseInt(br.readLine());

            // init for testcase
            arr = new int[n][n];
            max = 0;
            start = 101;

            // n개의 줄
            for(int i=0; i<n; i++){
                String[] temp = br.readLine().split(" ");

                // n개의 문자
                for(int j=0; j<n; j++){
                    arr[i][j] = Integer.parseInt(temp[j]);
                }
            }

            for(int i=0; i<n; i++){
                for(int j=0; j<n; j++){
                    visited = new boolean[n*n+1];
                    int move = dfs(i,j);
                    if(max < move){
                        max = move;
                        start = arr[i][j];
                    }
                    else if(move != 0 && max == move){
                        // 시작점이 더 작은지 비교
                        if(arr[i][j] < start)   
                            start = arr[i][j];
                    }
                }
            }

            bw.write("#" + test + " " + start + " " + max);
            bw.newLine();
        }

        bw.flush();
        bw.close();
        br.close();
    }

    public static int dfs(int x, int y){
        // 상, 하, 좌, 우
        int[] xdir = {-1, 1, 0, 0};
        int[] ydir = {0, 0, -1 ,1};
        Stack<Pos> stack = new Stack<>();
        int move = 1;

        stack.push(new Pos(x, y));
        while(!stack.isEmpty()){
            Pos p = stack.pop();
            int a = p.x;
            int b = p.y;

            for(int i=0; i<4; i++){
                int dx = a + xdir[i];
                int dy = b + ydir[i];
                // 배열을 벗어나지 않았는지
                if(isValidPosition(dx, dy)){
                    // 방문하지 않았는지
                    if(!visited[arr[dx][dy]]){
                        // 다음 방문하려는 곳이 시작점보다 1이 큰지
                        if(arr[dx][dy] - arr[a][b] == 1){
                            visited[arr[dx][dy]] = true;
                            stack.push(new Pos(dx, dy));
                            move++;
                        }
                    }
                }
            }
        }

        return move;
    }

    public static boolean isValidPosition(int x, int y){
        if(x < 0 || x > n-1 || y < 0 || y > n-1)
            return false;
        return true;
    }
}