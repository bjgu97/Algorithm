// 1018, 체스판 다시 칠하기
package 완전탐색;

import java.io.;
import java.util.;

public class BOJ_1018 {

    static char[][] board;

    public static void main(String[] args) throws IOException {
        // TODO Auto-generated method stub
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        board = new char[N][M];

        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            for (int j = 0; j < M; j++) {
                board[i][j] = s.charAt(j);
            }
        }

        int min = Integer.MAX_VALUE;

        for (int i = 0; i < N - 8 + 1; i++) {
            for (int j = 0; j < M - 8 + 1; j++) {
                min = Math.min(min, repaint(i, j));
            }
        }
        System.out.println(min);
    }

    static int repaint(int r, int c) {
        /*
         * i) (0, 0)이 W
         * ii) (0, 0)이 B
        */
        int cnt_w = 0, cnt_b = 0; // cnt_w: (0,0)이 W, cnt_b: (0, 0)이 B
        for (int i = r; i < r + 8; i++) {
            for (int j = c; j < c + 8; j++) {
                if ((i + j) % 2 == 0 && board[i][j] == 'B') {
                    cnt_w++;
                }
                if ((i + j) % 2 == 1 && board[i][j] == 'W') {
                    cnt_w++;
                }

                if ((i + j) % 2 == 0 && board[i][j] == 'W') {
                    cnt_b++;
                }
                if ((i + j) % 2 == 1 && board[i][j] == 'B') {
                    cnt_b++;
                }
            }
        }
        return Math.min(cnt_w, cnt_b);
    }
