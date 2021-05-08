import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class Solution {
	public static void main(String[] args) {
//		int k = 3;
//		int[] num = {12, 30, 1, 8, 8, 6, 20, 7, 5, 10, 4, 1};
//		int[][] links = {{-1, -1}, {-1, -1}, {-1, -1}, {-1, -1}, {8, 5}, {2, 10}, {3, 0}, {6, 1}, {11, -1}, {7, 4}, {-1, -1}, {-1, -1}};
//		System.out.println(Solution5(k, num, links));
		
		
		
		int n = 8;
		int k = 2;
		String[] cmd = {"D 2","C","U 3","C","D 4","C","Z","C","C"};
		System.out.println(Solution3(n, k, cmd));
		
		
//		String[][] places = {{"POOOP", "OXXOX", "OPXPX", "OOXOX", "POXXP"}, {"POOPX", "OXPXP", "PXXXO", "OXXXO", "OOOPP"}, {"PXOPX", "OXOXP", "OXPXX", "OXXXP", "POOXX"}, {"OOOXX", "XOOOX", "OOOXX", "OXOOX", "OOOOO"}, {"PXPXP", "XPXPX", "PXPXP", "XPXPX", "PXPXP"}};
//		System.out.println(Arrays.toString(Solution2(places)));
		
		
		
		
	}
	
	static class Tree {
		int right;
		int left;
		int val;
		
		Tree(int right, int left, int val) {
			this.right = right;
			this.left = left;
			this.val = val;
		}

		@Override
		public String toString() {
			return "tree [right=" + right + ", left=" + left + ", val=" + val + "]";
		}

	}
	
	
	
//	static int Solution(int k, int[] num, int[][] links) {
//		int answer = 0;
//		Tree tree = new Tree();
//		for(int i = 0; i < links.length; i++) {
//			Tree tree = new tree() 
//		}
//		return answer;
//	}
	
	
	

	static String Solution3(int n, int k, String[] cmd) {
		String answer = "";
		Stack<Integer> stack = new Stack<>();
		
		// 초기 배열 초기화: [0, 1, 2, 3, 4, 5, 6, 7]
		int[] initArray = new int[n];
		for(int i = 0; i < n; i++) {
			initArray[i] = i;
		}
	
		
		// 현재 가르키고 있는 인덱스
		int index = k;

		//		String[] cmd = {"D 2","C","U 3","C","D 4","C","U 2","Z","Z","U 1","C"};

		System.out.println("index:" + index);
		for(int c = 0; c < cmd.length; c++) {
			System.out.println("=============================cmd[c]: " + cmd[c]);
			String currentCmd = cmd[c];
			
			if(currentCmd.charAt(0) == 'D') {
				int val = currentCmd.charAt(2)- '0';
				int tempCnt = 0;
				for(int i = index; i < index + val; i++) {
					if(initArray[i] == -1) {
						tempCnt++;
					}
				}
				index = index + (val + tempCnt);
				System.out.println("D: index: " + index);
			}
			
			
			else if(currentCmd.charAt(0) == 'C') {
				stack.push(index); // 값 저장하고
				initArray[index] = -1; // 삭제
				System.out.println(Arrays.toString(initArray));
				System.out.println("stack: " + stack);
				index++; //8
				
				// 예외처리: 마지막값 삭제하게 된다면
				if(index == n) {
					index--;
					System.out.println("index, initArray[index]: " + index + "," + initArray[index]);
					while(true) {
						System.out.println("~~~~");
						index--;
						if(initArray[index] != -1)
							break;
					}
				}
				System.out.println("C: index: " + index);
				System.out.println(stack);
			}
			
			
			else if(currentCmd.charAt(0) == 'U') {
				int val = currentCmd.charAt(2) - '0';
				// 올라가는 길에 '-1' 있으면 건너뛰고 게속 val 값 빼주기
				int tempCnt = 0;
				for(int i = index; i >= index - val; i--) { // 5 4 3
					if(initArray[i] == -1) {
						tempCnt++;
					}
				}
				index = index - (val + tempCnt);
				System.out.println("U: index: " + index);
			}
			
			
			else if(currentCmd.charAt(0) == 'Z') { // 삭제값 복구
				int val = stack.pop();
				
				initArray[val] = val;
				
				System.out.println("z: index: " + index);
				System.out.println("inirArray: " + Arrays.toString(initArray));
			}
			System.out.println();
		}
		
		System.out.println(Arrays.toString(initArray));
		for(int i = 0; i < initArray.length; i++) {
			if(initArray[i] == -1)
				answer += 'X';
			else
				answer += 'O';
			
		}
		return answer;
	}
	
	
//	String answer = "";
//    
//    Stack<Integer> stack = new Stack<>();
//	
//	// 초기 배열 초기화: [0, 1, 2, 3, 4, 5, 6, 7, 8]
//	int[] initArray = new int[n];
//	for(int i = 0; i < n; i++) {
//		initArray[i] = i;
//	}
//
//	// 현재 가르키고 있는 인덱스
//	int index = k;
//	for(int c = 0; c < cmd.length; c++) {
//		String currentCmd = cmd[c];
//		
//		if(currentCmd.charAt(0) == 'D') {
//			int val = currentCmd.charAt(2)- '0';
//			int tempCnt = 0;
//			for(int i = index; i <= index + val; i++) {
//				if(initArray[i] == -1) {
//					tempCnt++;
//				}
//			}
//			index = index + (val + tempCnt);
//		}
//		
//		
//		else if(currentCmd.charAt(0) == 'C') {
//			stack.push(index); // 값 저장하고
//			initArray[index] = -1; // 삭제
//			index++; //8
//			
//			// 예외처리: 마지막값 삭제하게 된다면
//			if(index == n) {
//				index--;
//				while(true) {
//					index--;
//					if(initArray[index] != -1)
//						break;
//				}
//			}
//		}
//		
//		
//		else if(currentCmd.charAt(0) == 'U') {
//			int val = currentCmd.charAt(2) - '0';
//			// 올라가는 길에 '-1' 있으면 건너뛰고 게속 val 값 빼주기
//			int tempCnt = 0;
//			for(int i = index; i >= index - val; i--) { // 5 4 3
//				if(initArray[i] == -1) {
//					tempCnt++;
//				}
//			}
//			index = index - (val + tempCnt);
//		}
//		
//		
//		else if(currentCmd.charAt(0) == 'Z') { // 삭제값 복구
//			int val = stack.pop();
//			initArray[val] = val;
//	
//		}
//	}
//	
//	for(int i = 0; i < initArray.length; i++) {
//		if(initArray[i] == -1)
//			answer += 'X';
//		else
//			answer += 'O';
//		
//	}
//    return answer;
	
	static int[] Solution2(String[][] places) {
		int[] answer = new int[5];
		
		for(int p = 0; p < places.length; p++) {
			System.out.println(Arrays.toString(places[p]));
			char[][] map = new char[5][5];
			for(int i = 0; i < places[p].length; i++) {
				for(int j = 0; j < places[p][0].length(); j++) {
					map[j] = places[p][j].toCharArray();
				}
			}

			
			boolean check = true;
			
			int[][] deltas = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
			int[][] deltas2 = {{2, 0}, {-2, 0}, {0, 2}, {0, -2}};
			int[][] deltas3 = {{1, -1}, {-1, 1}, {-1, -1}, {1, 1}};
			
			outer:for(int i = 0; i < 5; i++) {
				for(int j = 0; j < 5; j++) {
					if(map[i][j] == 'P') {
						
						
						// 거리1로 앉아있으면.
						for(int d = 0; d < deltas.length; d++) {
							int ni = i + deltas[d][0];
							int nj = j + deltas[d][1];
							
							if(ni < 0 || nj < 0 || ni >= 5 || nj >= 5)
								continue;
							
							if(map[ni][nj] == 'P') {
								check = false;
								break outer;
							}
						}
						
						// 거리 2로 앉아있으면.
						for(int d = 0; d < deltas2.length; d++) {
							
							int ni = i + deltas2[d][0];
							int nj = j + deltas2[d][1];
							
							if(ni < 0 || nj < 0 || ni >= 5 || nj >= 5)
								continue;
							
							System.out.println("i, j: " + i + "," + j);

							if(map[ni][nj] == 'P') {
								if(i == ni && map[i][(nj + j)/2] == 'X') {
									check = true;
								}
								else if(j == nj && map[(ni + i)/2][j] == 'X') {
									check = true;
								}
								else {
									check = false;
									System.out.println("ni, nj: " + ni + "," + nj);
									System.out.println("????????????????");
									break outer;
								}
//								check = false;
							}
						}
						
						// 거리가 루트2이면
						for(int d = 0; d < deltas3.length; d++) {
							int ni = i + deltas3[d][0];
							int nj = j + deltas3[d][1];
							
							if(ni < 0 || nj < 0 || ni >= 5 || nj >= 5)
								continue;
							
							System.out.println("ni, nj: " + ni + "," + nj);
							
							
							if(map[ni][nj] == 'P') { 
			
								if(map[ni][j] == 'X' && map[i][nj] == 'X')
									check = true;
								else {
									check = false;
									break outer;
								}
//								if(i == ni && map[i][Math.abs(nj + j)/2] == 'X') {
//									check = true;
//								}
//								else if(j == nj && map[Math.abs(ni + i)/2][j] == 'X') {
//									check = true;
//								}
//								else {
//									check = false;
//									System.out.println("ni, nj: " + ni + "," + nj);
//									System.out.println("????????????????");
//								}
////								check = false;
							}
							
						}
					}
					// 거리 2 이하에 응시자가 있으면
						// 하지만 사이가 X이면
				}
			}
			
			if(check)
				answer[p] = 1;
			else
				answer[p] = 0;
		}
		return answer;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	static int solution(String s) {
		int answer = 0;
		String stringAnswer = "";
		String temp = "";
		for(int c = 0; c < s.length(); c++) {
			if(Character.isAlphabetic(s.charAt(c))) { // 알파벳이면
				temp = temp + s.charAt(c);
				System.out.println("temp: " + temp);
				if(temp.equals("zero"))  {
					stringAnswer += "0";
					temp = "";
				}
				else if(temp.equals("one")) {
					System.out.println("!!!!!!!!");
					stringAnswer += "1";
					temp = "";
				}
				else if(temp.equals("two")) {
					stringAnswer += "2";
					temp = "";
				}
				else if(temp.equals("three")) {
					stringAnswer += "3";
					temp = "";
				}
				else if(temp.equals("four")) {
					stringAnswer += "4";
					temp = "";
				}
				else if(temp.equals("five")) {
					stringAnswer += "5";
					temp = "";
				}
				else if(temp.equals("six")) {
					stringAnswer += "6";
					temp = "";
				}
				else if(temp.equals("seven")) {
					stringAnswer += "7";
					temp = "";
				}
				else if(temp.equals("eight")) {
					stringAnswer += "8";
					temp = "";
				}
				else if(temp.equals("nine")) {
					stringAnswer += "9";
					temp = "";
				}
				
				System.out.println("stringAnswer : " + stringAnswer);
			}
			else {
				stringAnswer = stringAnswer + s.charAt(c);
			}
				
			System.out.println("stringAnsweerr: " + stringAnswer);
		}
	
		answer = Integer.parseInt(stringAnswer);
		return answer;
	}

}
