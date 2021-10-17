import java.util.Arrays;

public class kakao2021_6 {
	public static void main(String[] args) {
		int[][] board = {{5,5,5,5,5},{5,5,5,5,5},{5,5,5,5,5},{5,5,5,5,5}};
		int[][] skill = {{1,0,0,3,4,4},{1,2,0,2,3,2},{2,1,0,3,1,2},{1,0,1,3,3,1}};
		
		System.out.println(solution(board, skill));
	}
	
	// 1000 * 1000
	// 250000
	// [type, r1, c1, r2, c2, degree]
	static int solution(int[][] board, int[][] skills) {
		int answer = 0;
		
		for(int[] skill : skills) {
			int type = skill[0];
			int r1 = skill[1];
			int c1 = skill[2];
			int r2 = skill[3];
			int c2 = skill[4];
			int degree = skill[5];
			
			if(type == 1) {
				for(int i = r1; i <= r2; i++) {
					for(int j = c1; j <= c2; j++) {
						board[i][j] -= degree;
					}
				}
				
				for(int[] a : board)
					System.out.println(Arrays.toString(a));
			}
			else {
				for(int i = r1; i <= r2; i++) {
					for(int j = c1; j <= c2; j++) {
						board[i][j] += degree;
					}
				}
				
				for(int[] a : board)
					System.out.println(Arrays.toString(a));
			}
			System.out.println();
		}
		
		
		for(int i = 0; i < board.length; i++) {
			for(int j = 0; j < board[0].length; j++) {
				if(board[i][j] > 0)
					answer++;
			}
		}
		return answer;
	}
}
